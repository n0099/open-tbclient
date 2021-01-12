package com.baidu.tieba.ala.livecard.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    private int bHL;
    private View dividerLine;
    public int eMg;
    private boolean fmB;
    private int fmD;
    private IndicatorView fmw;
    private FrsAlaStageLiveViewPager hjH;
    private FrsAlaStageLiveViewItemAdapter hjI;
    private LinearLayout hjJ;
    private View hjK;
    private h hjL;
    private com.baidu.tieba.ala.livecard.vc.a hjM;
    private com.baidu.tieba.ala.livecard.vc.b hjN;
    private com.baidu.tieba.ala.livecard.vc.c hjO;
    private ForbidParentSwipeBackRelativeLayout hjn;
    private boolean hjq;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHL = 1;
        this.fmB = false;
        this.fmD = 5;
        this.hjq = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.d.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.bHL = i;
                if (d.this.hjN != null) {
                    int qa = d.this.hjN.qa(i + 1);
                    d.this.bHL = qa;
                    if (d.this.fmw != null) {
                        d.this.fmw.setPosition(d.this.hjN.qb(qa));
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.hjI.getCount()) >= 2) {
                    int currentItem = d.this.hjH.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.hjH.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.hjH.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.hjO = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.a.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bz bzVar) {
                d.this.e(view, bzVar);
                d.this.X(bzVar);
                d.this.a(d.this.mTbPageContext, bzVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bz bzVar) {
                d.this.e(view, bzVar);
            }
        };
        this.hjn = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hjK = getView().findViewById(R.id.divider_pager_and_indicator);
        this.hjH = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.hjJ = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.fmw = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.hjM = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.hjn);
        this.hjM.setUniqueId(getTag());
        this.hjH.setBackgroundResource(R.drawable.transparent_bg);
        this.hjH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hjI = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.hjH.setAdapter(this.hjI);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hjq = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hjq = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hjn.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.a.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.hjL != null && !x.isEmpty(d.this.hjL.nkC) && d.this.hjL.nkC.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hjq);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hjq);
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
        if (hVar != null && hVar.nkC != null) {
            this.hjL = hVar;
            setVisibility(0);
            if (this.hjN == null) {
                this.hjN = new com.baidu.tieba.ala.livecard.vc.b(hVar.nkC, this.fmB, this.fmD);
                this.hjN.qd(2);
                this.hjN.qc(6);
                this.hjN.qe(1);
            }
            this.hjN.cC(hVar.nkC);
            this.hjI.setForumName(this.mForumName);
            this.hjI.a(this.hjN.bvh(), this.hjO);
            this.hjH.setCurrentItem(this.hjN.bvg(), false);
            if (hVar.nkC.size() >= 2) {
                this.hjJ.setVisibility(0);
                if (this.fmw.getCount() != this.hjN.bvf()) {
                    this.fmw.setCount(this.hjN.bvf());
                    this.bHL = this.hjN.bvg();
                }
                this.fmw.setPosition(this.hjN.qb(this.bHL));
            } else {
                this.hjJ.setVisibility(8);
            }
            if (hVar.nkC.size() > 0) {
                this.hjM.l(hVar.nkC.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bXR();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bXR() {
        int qb;
        if (this.hjL != null && x.isEmpty(this.hjL.nkC) && (qb = this.hjN.qb(this.bHL)) < this.hjL.nkC.size() && qb >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.hjL.nkC != null && this.hjL.nkC.get(qb) != null) {
                this.hjL.nkC.get(qb).eMg = this.eMg;
            }
            customMessage.setData(this.hjL.nkC.get(qb));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.hjL.nkC.get(qb) != null) {
                TiebaStatic.log(new aq("c12804").dW("tid", this.hjL.nkC.get(qb).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(bz bzVar) {
        if (bzVar.bnQ() != null && bzVar.bnQ().user_info != null && bzVar.bnQ().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dW("tid", bzVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bz bzVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bzVar);
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
    public void uN(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hjn, R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.hjK, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.hjM.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            if (bzVar.bnQ() != null && bzVar.bnQ().user_info != null) {
                alaLiveInfoCoreData.userName = bzVar.bnQ().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hjL != null && !x.isEmpty(this.hjL.nkC)) {
                for (bz bzVar2 : this.hjL.nkC) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
        alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
        return alaLiveInfoCoreData;
    }
}
