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
    public int cLB;
    private IndicatorView dgm;
    private boolean dgr;
    private int dgt;
    private View dividerLine;
    private ForbidParentSwipeBackRelativeLayout eJM;
    private boolean eJP;
    private FrsAlaStageLiveViewPager eKg;
    private FrsAlaStageLiveViewItemAdapter eKh;
    private LinearLayout eKi;
    private View eKj;
    private g eKk;
    private com.baidu.tieba.ala.livecard.vc.a eKl;
    private com.baidu.tieba.ala.livecard.vc.b eKm;
    private com.baidu.tieba.ala.livecard.vc.c eKn;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dgr = false;
        this.dgt = 5;
        this.eJP = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.eKm != null) {
                    int lk = d.this.eKm.lk(i + 1);
                    d.this.mCurrentIndex = lk;
                    if (d.this.dgm != null) {
                        d.this.dgm.setPosition(d.this.eKm.ll(lk));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.eKh.getCount()) >= 2) {
                    int currentItem = d.this.eKg.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.eKg.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.eKg.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.eKn = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bj bjVar) {
                d.this.d(view, bjVar);
                d.this.T(bjVar);
                d.this.a(d.this.mTbPageContext, bjVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bj bjVar) {
                d.this.d(view, bjVar);
            }
        };
        this.eJM = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.eKj = getView().findViewById(R.id.divider_pager_and_indicator);
        this.eKg = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.eKi = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dgm = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.eKl = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.eJM);
        this.eKl.setUniqueId(getTag());
        this.eKg.setBackgroundResource(R.drawable.transparent_bg);
        this.eKg.setOnPageChangeListener(this.mOnPageChangeListener);
        this.eKh = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.eKg.setAdapter(this.eKh);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.eJP = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.eJP = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.eJM.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.eKk != null && !v.isEmpty(d.this.eKk.kdh) && d.this.eKk.kdh.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eJP);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.eJP);
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
        if (gVar != null && gVar.kdh != null) {
            this.eKk = gVar;
            setVisibility(0);
            if (this.eKm == null) {
                this.eKm = new com.baidu.tieba.ala.livecard.vc.b(gVar.kdh, this.dgr, this.dgt);
                this.eKm.ln(2);
                this.eKm.lm(6);
                this.eKm.lo(1);
            }
            this.eKm.ac(gVar.kdh);
            this.eKh.setForumName(this.mForumName);
            this.eKh.a(this.eKm.aGo(), this.eKn);
            this.eKg.setCurrentItem(this.eKm.aGn(), false);
            if (gVar.kdh.size() >= 2) {
                this.eKi.setVisibility(0);
                if (this.dgm.getCount() != this.eKm.aGm()) {
                    this.dgm.setCount(this.eKm.aGm());
                    this.mCurrentIndex = this.eKm.aGn();
                }
                this.dgm.setPosition(this.eKm.ll(this.mCurrentIndex));
            } else {
                this.eKi.setVisibility(8);
            }
            if (gVar.kdh.size() > 0) {
                this.eKl.e(gVar.kdh.get(0), "ala_frs_stage_live_feed_back_type");
            }
            beM();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void beM() {
        int ll;
        if (this.eKk != null && v.isEmpty(this.eKk.kdh) && (ll = this.eKm.ll(this.mCurrentIndex)) < this.eKk.kdh.size() && ll >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.eKk.kdh != null && this.eKk.kdh.get(ll) != null) {
                this.eKk.kdh.get(ll).cLB = this.cLB;
            }
            customMessage.setData(this.eKk.kdh.get(ll));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.eKk.kdh.get(ll) != null) {
                TiebaStatic.log(new an("c12804").cp("tid", this.eKk.kdh.get(ll).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(bj bjVar) {
        if (bjVar.aAq() != null && bjVar.aAq().user_info != null && bjVar.aAq().user_info.is_official == 2) {
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
    public void po(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJM, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eKj, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.eKl.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            if (bjVar.aAq() != null && bjVar.aAq().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aAq().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.eKk != null && !v.isEmpty(this.eKk.kdh)) {
                for (bj bjVar2 : this.eKk.kdh) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData R(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
        alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
        return alaLiveInfoCoreData;
    }
}
