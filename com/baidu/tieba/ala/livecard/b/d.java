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
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<g> implements x {
    public int cLr;
    private IndicatorView dga;
    private boolean dgf;
    private int dgh;
    private View dividerLine;
    private ForbidParentSwipeBackRelativeLayout eIC;
    private boolean eIF;
    private FrsAlaStageLiveViewPager eIW;
    private FrsAlaStageLiveViewItemAdapter eIX;
    private LinearLayout eIY;
    private View eIZ;
    private g eJa;
    private com.baidu.tieba.ala.livecard.vc.a eJb;
    private com.baidu.tieba.ala.livecard.vc.b eJc;
    private com.baidu.tieba.ala.livecard.vc.c eJd;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dgf = false;
        this.dgh = 5;
        this.eIF = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.eJc != null) {
                    int lk = d.this.eJc.lk(i + 1);
                    d.this.mCurrentIndex = lk;
                    if (d.this.dga != null) {
                        d.this.dga.setPosition(d.this.eJc.ll(lk));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.eIX.getCount()) >= 2) {
                    int currentItem = d.this.eIW.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.eIW.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.eIW.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.eJd = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bj bjVar) {
                d.this.d(view, bjVar);
                d.this.S(bjVar);
                d.this.a(d.this.mTbPageContext, bjVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bj bjVar) {
                d.this.d(view, bjVar);
            }
        };
        this.eIC = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eIZ = getView().findViewById(R.id.divider_pager_and_indicator);
        this.eIW = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.eIY = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dga = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.eJb = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.eIC);
        this.eJb.setUniqueId(getTag());
        this.eIW.setBackgroundResource(R.drawable.transparent_bg);
        this.eIW.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eIX = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.eIW.setAdapter(this.eIX);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eIF = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eIF = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eIC.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.eJa != null && !v.isEmpty(d.this.eJa.jZE) && d.this.eJa.jZE.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eIF);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eIF);
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
    public void a(g gVar) {
        if (gVar != null && gVar.jZE != null) {
            this.eJa = gVar;
            setVisibility(0);
            if (this.eJc == null) {
                this.eJc = new com.baidu.tieba.ala.livecard.vc.b(gVar.jZE, this.dgf, this.dgh);
                this.eJc.ln(2);
                this.eJc.lm(6);
                this.eJc.lo(1);
            }
            this.eJc.ad(gVar.jZE);
            this.eIX.setForumName(this.mForumName);
            this.eIX.a(this.eJc.aFV(), this.eJd);
            this.eIW.setCurrentItem(this.eJc.aFU(), false);
            if (gVar.jZE.size() >= 2) {
                this.eIY.setVisibility(0);
                if (this.dga.getCount() != this.eJc.aFT()) {
                    this.dga.setCount(this.eJc.aFT());
                    this.mCurrentIndex = this.eJc.aFU();
                }
                this.dga.setPosition(this.eJc.ll(this.mCurrentIndex));
            } else {
                this.eIY.setVisibility(8);
            }
            if (gVar.jZE.size() > 0) {
                this.eJb.e(gVar.jZE.get(0), "ala_frs_stage_live_feed_back_type");
            }
            ber();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ber() {
        int ll;
        if (this.eJa != null && v.isEmpty(this.eJa.jZE) && (ll = this.eJc.ll(this.mCurrentIndex)) < this.eJa.jZE.size() && ll >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.eJa.jZE != null && this.eJa.jZE.get(ll) != null) {
                this.eJa.jZE.get(ll).cLr = this.cLr;
            }
            customMessage.setData(this.eJa.jZE.get(ll));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.eJa.jZE.get(ll) != null) {
                TiebaStatic.log(new an("c12804").cp("tid", this.eJa.jZE.get(ll).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(bj bjVar) {
        if (bjVar.azX() != null && bjVar.azX().user_info != null && bjVar.azX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").cp("tid", bjVar.getId()));
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
    public void pm(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIC, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eIZ, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.eJb.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.azE() != null && bjVar.azX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
            if (bjVar.azX() != null && bjVar.azX().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.azX().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eJa != null && !v.isEmpty(this.eJa.jZE)) {
                for (bj bjVar2 : this.eJa.jZE) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(Q(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData Q(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
        alaLiveInfoCoreData.userName = bjVar.azE().getUserName();
        return alaLiveInfoCoreData;
    }
}
