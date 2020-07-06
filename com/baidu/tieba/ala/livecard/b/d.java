package com.baidu.tieba.ala.livecard.b;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    public int dJw;
    private View dividerLine;
    private IndicatorView ehS;
    private boolean ehX;
    private int ehZ;
    private h fSA;
    private com.baidu.tieba.ala.livecard.vc.a fSB;
    private com.baidu.tieba.ala.livecard.vc.b fSC;
    private com.baidu.tieba.ala.livecard.vc.c fSD;
    private ForbidParentSwipeBackRelativeLayout fSc;
    private boolean fSf;
    private FrsAlaStageLiveViewPager fSw;
    private FrsAlaStageLiveViewItemAdapter fSx;
    private LinearLayout fSy;
    private View fSz;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.ehX = false;
        this.ehZ = 5;
        this.fSf = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.fSC != null) {
                    int mO = d.this.fSC.mO(i + 1);
                    d.this.mCurrentIndex = mO;
                    if (d.this.ehS != null) {
                        d.this.ehS.setPosition(d.this.fSC.mP(mO));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.fSx.getCount()) >= 2) {
                    int currentItem = d.this.fSw.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.fSw.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.fSw.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.fSD = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bu buVar) {
                d.this.e(view, buVar);
                d.this.X(buVar);
                d.this.a(d.this.mTbPageContext, buVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bu buVar) {
                d.this.e(view, buVar);
            }
        };
        this.fSc = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fSz = getView().findViewById(R.id.divider_pager_and_indicator);
        this.fSw = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.fSy = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.ehS = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.fSB = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.fSc);
        this.fSB.setUniqueId(getTag());
        this.fSw.setBackgroundResource(R.drawable.transparent_bg);
        this.fSw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fSx = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.fSw.setAdapter(this.fSx);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fSf = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fSf = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fSc.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.fSA != null && !w.isEmpty(d.this.fSA.lDF) && d.this.fSA.lDF.size() > 1) {
                    if (d.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                        ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(false);
                    }
                }
            }

            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void enableSwipeBack() {
                if (d.this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fSf);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fSf);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_stage_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.lDF != null) {
            this.fSA = hVar;
            setVisibility(0);
            if (this.fSC == null) {
                this.fSC = new com.baidu.tieba.ala.livecard.vc.b(hVar.lDF, this.ehX, this.ehZ);
                this.fSC.mR(2);
                this.fSC.mQ(6);
                this.fSC.mS(1);
            }
            this.fSC.bN(hVar.lDF);
            this.fSx.setForumName(this.mForumName);
            this.fSx.a(this.fSC.aZr(), this.fSD);
            this.fSw.setCurrentItem(this.fSC.aZq(), false);
            if (hVar.lDF.size() >= 2) {
                this.fSy.setVisibility(0);
                if (this.ehS.getCount() != this.fSC.aZp()) {
                    this.ehS.setCount(this.fSC.aZp());
                    this.mCurrentIndex = this.fSC.aZq();
                }
                this.ehS.setPosition(this.fSC.mP(this.mCurrentIndex));
            } else {
                this.fSy.setVisibility(8);
            }
            if (hVar.lDF.size() > 0) {
                this.fSB.l(hVar.lDF.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bzi();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bzi() {
        int mP;
        if (this.fSA != null && w.isEmpty(this.fSA.lDF) && (mP = this.fSC.mP(this.mCurrentIndex)) < this.fSA.lDF.size() && mP >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.fSA.lDF != null && this.fSA.lDF.get(mP) != null) {
                this.fSA.lDF.get(mP).dJw = this.dJw;
            }
            customMessage.setData(this.fSA.lDF.get(mP));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.fSA.lDF.get(mP) != null) {
                TiebaStatic.log(new ao("c12804").dk("tid", this.fSA.lDF.get(mP).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(bu buVar) {
        if (buVar.aSJ() != null && buVar.aSJ().user_info != null && buVar.aSJ().user_info.is_official == 2) {
            TiebaStatic.log(new ao("c12805").dk("tid", buVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bu buVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(buVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fSc, R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.fSz, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.fSB.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bu buVar) {
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            if (buVar.aSJ() != null && buVar.aSJ().user_info != null) {
                alaLiveInfoCoreData.userName = buVar.aSJ().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fSA != null && !w.isEmpty(this.fSA.lDF)) {
                for (bu buVar2 : this.fSA.lDF) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(buVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(bu buVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
        alaLiveInfoCoreData.userName = buVar.aSp().getUserName();
        return alaLiveInfoCoreData;
    }
}
