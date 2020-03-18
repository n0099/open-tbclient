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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.x;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<h> implements x {
    public int cPT;
    private View dividerLine;
    private IndicatorView dkT;
    private boolean dkY;
    private int dla;
    private FrsAlaStageLiveViewPager eOL;
    private FrsAlaStageLiveViewItemAdapter eOM;
    private LinearLayout eON;
    private View eOO;
    private h eOP;
    private com.baidu.tieba.ala.livecard.vc.a eOQ;
    private com.baidu.tieba.ala.livecard.vc.b eOR;
    private com.baidu.tieba.ala.livecard.vc.c eOS;
    private ForbidParentSwipeBackRelativeLayout eOr;
    private boolean eOu;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dkY = false;
        this.dla = 5;
        this.eOu = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.eOR != null) {
                    int lD = d.this.eOR.lD(i + 1);
                    d.this.mCurrentIndex = lD;
                    if (d.this.dkT != null) {
                        d.this.dkT.setPosition(d.this.eOR.lE(lD));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.eOM.getCount()) >= 2) {
                    int currentItem = d.this.eOL.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.eOL.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.eOL.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.eOS = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bj bjVar) {
                d.this.d(view, bjVar);
                d.this.V(bjVar);
                d.this.a(d.this.mTbPageContext, bjVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bj bjVar) {
                d.this.d(view, bjVar);
            }
        };
        this.eOr = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eOO = getView().findViewById(R.id.divider_pager_and_indicator);
        this.eOL = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.eON = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dkT = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.eOQ = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.eOr);
        this.eOQ.setUniqueId(getTag());
        this.eOL.setBackgroundResource(R.drawable.transparent_bg);
        this.eOL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eOM = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.eOL.setAdapter(this.eOM);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eOu = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eOu = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eOr.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.eOP != null && !v.isEmpty(d.this.eOP.kgc) && d.this.eOP.kgc.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eOu);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eOu);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ala_stage_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.kgc != null) {
            this.eOP = hVar;
            setVisibility(0);
            if (this.eOR == null) {
                this.eOR = new com.baidu.tieba.ala.livecard.vc.b(hVar.kgc, this.dkY, this.dla);
                this.eOR.lG(2);
                this.eOR.lF(6);
                this.eOR.lH(1);
            }
            this.eOR.ac(hVar.kgc);
            this.eOM.setForumName(this.mForumName);
            this.eOM.a(this.eOR.aIK(), this.eOS);
            this.eOL.setCurrentItem(this.eOR.aIJ(), false);
            if (hVar.kgc.size() >= 2) {
                this.eON.setVisibility(0);
                if (this.dkT.getCount() != this.eOR.aII()) {
                    this.dkT.setCount(this.eOR.aII());
                    this.mCurrentIndex = this.eOR.aIJ();
                }
                this.dkT.setPosition(this.eOR.lE(this.mCurrentIndex));
            } else {
                this.eON.setVisibility(8);
            }
            if (hVar.kgc.size() > 0) {
                this.eOQ.e(hVar.kgc.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bhe();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bhe() {
        int lE;
        if (this.eOP != null && v.isEmpty(this.eOP.kgc) && (lE = this.eOR.lE(this.mCurrentIndex)) < this.eOP.kgc.size() && lE >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.eOP.kgc != null && this.eOP.kgc.get(lE) != null) {
                this.eOP.kgc.get(lE).cPT = this.cPT;
            }
            customMessage.setData(this.eOP.kgc.get(lE));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.eOP.kgc.get(lE) != null) {
                TiebaStatic.log(new an("c12804").cx("tid", this.eOP.kgc.get(lE).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bj bjVar) {
        if (bjVar.aCK() != null && bjVar.aCK().user_info != null && bjVar.aCK().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").cx("tid", bjVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, bj bjVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bjVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eOr, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eOO, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.eOQ.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCr().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            if (bjVar.aCK() != null && bjVar.aCK().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aCK().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eOP != null && !v.isEmpty(this.eOP.kgc)) {
                for (bj bjVar2 : this.eOP.kgc) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
        alaLiveInfoCoreData.userName = bjVar.aCr().getUserName();
        return alaLiveInfoCoreData;
    }
}
