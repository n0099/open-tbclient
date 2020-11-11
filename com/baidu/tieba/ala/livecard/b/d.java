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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<h> implements z {
    private View dividerLine;
    public int eBK;
    private IndicatorView faQ;
    private boolean faV;
    private int faX;
    private FrsAlaStageLiveViewPager gTF;
    private FrsAlaStageLiveViewItemAdapter gTG;
    private LinearLayout gTH;
    private View gTI;
    private h gTJ;
    private com.baidu.tieba.ala.livecard.vc.a gTK;
    private com.baidu.tieba.ala.livecard.vc.b gTL;
    private com.baidu.tieba.ala.livecard.vc.c gTM;
    private ForbidParentSwipeBackRelativeLayout gTl;
    private boolean gTo;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.faV = false;
        this.faX = 5;
        this.gTo = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gTL != null) {
                    int qv = d.this.gTL.qv(i + 1);
                    d.this.mCurrentIndex = qv;
                    if (d.this.faQ != null) {
                        d.this.faQ.setPosition(d.this.gTL.qw(qv));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gTG.getCount()) >= 2) {
                    int currentItem = d.this.gTF.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gTF.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gTF.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gTM = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bw bwVar) {
                d.this.e(view, bwVar);
                d.this.V(bwVar);
                d.this.a(d.this.mTbPageContext, bwVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bw bwVar) {
                d.this.e(view, bwVar);
            }
        };
        this.gTl = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gTI = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gTF = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gTH = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.faQ = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gTK = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gTl);
        this.gTK.setUniqueId(getTag());
        this.gTF.setBackgroundResource(R.drawable.transparent_bg);
        this.gTF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gTG = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gTF.setAdapter(this.gTG);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gTo = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gTo = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gTl.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gTJ != null && !y.isEmpty(d.this.gTJ.mUJ) && d.this.gTJ.mUJ.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gTo);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gTo);
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
        if (hVar != null && hVar.mUJ != null) {
            this.gTJ = hVar;
            setVisibility(0);
            if (this.gTL == null) {
                this.gTL = new com.baidu.tieba.ala.livecard.vc.b(hVar.mUJ, this.faV, this.faX);
                this.gTL.qy(2);
                this.gTL.qx(6);
                this.gTL.qz(1);
            }
            this.gTL.cr(hVar.mUJ);
            this.gTG.setForumName(this.mForumName);
            this.gTG.a(this.gTL.btR(), this.gTM);
            this.gTF.setCurrentItem(this.gTL.btQ(), false);
            if (hVar.mUJ.size() >= 2) {
                this.gTH.setVisibility(0);
                if (this.faQ.getCount() != this.gTL.btP()) {
                    this.faQ.setCount(this.gTL.btP());
                    this.mCurrentIndex = this.gTL.btQ();
                }
                this.faQ.setPosition(this.gTL.qw(this.mCurrentIndex));
            } else {
                this.gTH.setVisibility(8);
            }
            if (hVar.mUJ.size() > 0) {
                this.gTK.l(hVar.mUJ.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bVX();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bVX() {
        int qw;
        if (this.gTJ != null && y.isEmpty(this.gTJ.mUJ) && (qw = this.gTL.qw(this.mCurrentIndex)) < this.gTJ.mUJ.size() && qw >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gTJ.mUJ != null && this.gTJ.mUJ.get(qw) != null) {
                this.gTJ.mUJ.get(qw).eBK = this.eBK;
            }
            customMessage.setData(this.gTJ.mUJ.get(qw));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gTJ.mUJ.get(qw) != null) {
                TiebaStatic.log(new aq("c12804").dR("tid", this.gTJ.mUJ.get(qw).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bw bwVar) {
        if (bwVar.bmU() != null && bwVar.bmU().user_info != null && bwVar.bmU().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dR("tid", bwVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bw bwVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bwVar);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gTl, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gTI, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gTK.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            if (bwVar.bmU() != null && bwVar.bmU().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.bmU().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gTJ != null && !y.isEmpty(this.gTJ.mUJ)) {
                for (bw bwVar2 : this.gTJ.mUJ) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
        alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
        return alaLiveInfoCoreData;
    }
}
