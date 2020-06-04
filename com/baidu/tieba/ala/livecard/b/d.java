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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    public int dDb;
    private IndicatorView dZi;
    private boolean dZn;
    private int dZp;
    private View dividerLine;
    private ForbidParentSwipeBackRelativeLayout fGT;
    private boolean fGW;
    private FrsAlaStageLiveViewPager fHn;
    private FrsAlaStageLiveViewItemAdapter fHo;
    private LinearLayout fHp;
    private View fHq;
    private h fHr;
    private com.baidu.tieba.ala.livecard.vc.a fHs;
    private com.baidu.tieba.ala.livecard.vc.b fHt;
    private com.baidu.tieba.ala.livecard.vc.c fHu;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dZn = false;
        this.dZp = 5;
        this.fGW = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.fHt != null) {
                    int mu = d.this.fHt.mu(i + 1);
                    d.this.mCurrentIndex = mu;
                    if (d.this.dZi != null) {
                        d.this.dZi.setPosition(d.this.fHt.mv(mu));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.fHo.getCount()) >= 2) {
                    int currentItem = d.this.fHn.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.fHn.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.fHn.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.fHu = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bk bkVar) {
                d.this.e(view, bkVar);
                d.this.W(bkVar);
                d.this.a(d.this.mTbPageContext, bkVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bk bkVar) {
                d.this.e(view, bkVar);
            }
        };
        this.fGT = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fHq = getView().findViewById(R.id.divider_pager_and_indicator);
        this.fHn = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.fHp = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dZi = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.fHs = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.fGT);
        this.fHs.setUniqueId(getTag());
        this.fHn.setBackgroundResource(R.drawable.transparent_bg);
        this.fHn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fHo = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.fHn.setAdapter(this.fHo);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fGW = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fGW = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fGT.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.fHr != null && !v.isEmpty(d.this.fHr.ljK) && d.this.fHr.ljK.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fGW);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fGW);
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
        if (hVar != null && hVar.ljK != null) {
            this.fHr = hVar;
            setVisibility(0);
            if (this.fHt == null) {
                this.fHt = new com.baidu.tieba.ala.livecard.vc.b(hVar.ljK, this.dZn, this.dZp);
                this.fHt.mx(2);
                this.fHt.mw(6);
                this.fHt.my(1);
            }
            this.fHt.bE(hVar.ljK);
            this.fHo.setForumName(this.mForumName);
            this.fHo.a(this.fHt.aXl(), this.fHu);
            this.fHn.setCurrentItem(this.fHt.aXk(), false);
            if (hVar.ljK.size() >= 2) {
                this.fHp.setVisibility(0);
                if (this.dZi.getCount() != this.fHt.aXj()) {
                    this.dZi.setCount(this.fHt.aXj());
                    this.mCurrentIndex = this.fHt.aXk();
                }
                this.dZi.setPosition(this.fHt.mv(this.mCurrentIndex));
            } else {
                this.fHp.setVisibility(8);
            }
            if (hVar.ljK.size() > 0) {
                this.fHs.e(hVar.ljK.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bwm();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bwm() {
        int mv;
        if (this.fHr != null && v.isEmpty(this.fHr.ljK) && (mv = this.fHt.mv(this.mCurrentIndex)) < this.fHr.ljK.size() && mv >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.fHr.ljK != null && this.fHr.ljK.get(mv) != null) {
                this.fHr.ljK.get(mv).dDb = this.dDb;
            }
            customMessage.setData(this.fHr.ljK.get(mv));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.fHr.ljK.get(mv) != null) {
                TiebaStatic.log(new an("c12804").dh("tid", this.fHr.ljK.get(mv).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(bk bkVar) {
        if (bkVar.aQS() != null && bkVar.aQS().user_info != null && bkVar.aQS().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").dh("tid", bkVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bk bkVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bkVar);
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
    public void qy(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGT, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fHq, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.fHs.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            if (bkVar.aQS() != null && bkVar.aQS().user_info != null) {
                alaLiveInfoCoreData.userName = bkVar.aQS().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.fHr != null && !v.isEmpty(this.fHr.ljK)) {
                for (bk bkVar2 : this.fHr.ljK) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }
}
