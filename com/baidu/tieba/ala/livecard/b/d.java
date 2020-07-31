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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    public int dPI;
    private View dividerLine;
    private IndicatorView eod;
    private boolean eoj;
    private int eol;
    private FrsAlaStageLiveViewPager fXP;
    private FrsAlaStageLiveViewItemAdapter fXQ;
    private LinearLayout fXR;
    private View fXS;
    private h fXT;
    private com.baidu.tieba.ala.livecard.vc.a fXU;
    private com.baidu.tieba.ala.livecard.vc.b fXV;
    private com.baidu.tieba.ala.livecard.vc.c fXW;
    private ForbidParentSwipeBackRelativeLayout fXv;
    private boolean fXy;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eoj = false;
        this.eol = 5;
        this.fXy = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.fXV != null) {
                    int ng = d.this.fXV.ng(i + 1);
                    d.this.mCurrentIndex = ng;
                    if (d.this.eod != null) {
                        d.this.eod.setPosition(d.this.fXV.nh(ng));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.fXQ.getCount()) >= 2) {
                    int currentItem = d.this.fXP.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.fXP.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.fXP.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.fXW = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bv bvVar) {
                d.this.e(view, bvVar);
                d.this.U(bvVar);
                d.this.a(d.this.mTbPageContext, bvVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bv bvVar) {
                d.this.e(view, bvVar);
            }
        };
        this.fXv = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fXS = getView().findViewById(R.id.divider_pager_and_indicator);
        this.fXP = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.fXR = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eod = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.fXU = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.fXv);
        this.fXU.setUniqueId(getTag());
        this.fXP.setBackgroundResource(R.drawable.transparent_bg);
        this.fXP.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fXQ = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.fXP.setAdapter(this.fXQ);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fXy = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fXy = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fXv.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.fXT != null && !x.isEmpty(d.this.fXT.lKU) && d.this.fXT.lKU.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fXy);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fXy);
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
        if (hVar != null && hVar.lKU != null) {
            this.fXT = hVar;
            setVisibility(0);
            if (this.fXV == null) {
                this.fXV = new com.baidu.tieba.ala.livecard.vc.b(hVar.lKU, this.eoj, this.eol);
                this.fXV.nj(2);
                this.fXV.ni(6);
                this.fXV.nk(1);
            }
            this.fXV.bR(hVar.lKU);
            this.fXQ.setForumName(this.mForumName);
            this.fXQ.a(this.fXV.bdo(), this.fXW);
            this.fXP.setCurrentItem(this.fXV.bdn(), false);
            if (hVar.lKU.size() >= 2) {
                this.fXR.setVisibility(0);
                if (this.eod.getCount() != this.fXV.bdm()) {
                    this.eod.setCount(this.fXV.bdm());
                    this.mCurrentIndex = this.fXV.bdn();
                }
                this.eod.setPosition(this.fXV.nh(this.mCurrentIndex));
            } else {
                this.fXR.setVisibility(8);
            }
            if (hVar.lKU.size() > 0) {
                this.fXU.l(hVar.lKU.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bCw();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bCw() {
        int nh;
        if (this.fXT != null && x.isEmpty(this.fXT.lKU) && (nh = this.fXV.nh(this.mCurrentIndex)) < this.fXT.lKU.size() && nh >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.fXT.lKU != null && this.fXT.lKU.get(nh) != null) {
                this.fXT.lKU.get(nh).dPI = this.dPI;
            }
            customMessage.setData(this.fXT.lKU.get(nh));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.fXT.lKU.get(nh) != null) {
                TiebaStatic.log(new ap("c12804").dn("tid", this.fXT.lKU.get(nh).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bv bvVar) {
        if (bvVar.aWF() != null && bvVar.aWF().user_info != null && bvVar.aWF().user_info.is_official == 2) {
            TiebaStatic.log(new ap("c12805").dn("tid", bvVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bv bvVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bvVar);
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
    public void rn(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fXv, R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.fXS, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.fXU.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bv bvVar) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            if (bvVar.aWF() != null && bvVar.aWF().user_info != null) {
                alaLiveInfoCoreData.userName = bvVar.aWF().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fXT != null && !x.isEmpty(this.fXT.lKU)) {
                for (bv bvVar2 : this.fXT.lKU) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bv bvVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
        alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
        return alaLiveInfoCoreData;
    }
}
