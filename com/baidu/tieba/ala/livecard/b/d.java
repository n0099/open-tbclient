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
    private IndicatorView dKN;
    private boolean dKS;
    private int dKU;
    private View dividerLine;
    public int doZ;
    private ForbidParentSwipeBackRelativeLayout fsL;
    private boolean fsO;
    private FrsAlaStageLiveViewPager ftf;
    private FrsAlaStageLiveViewItemAdapter ftg;
    private LinearLayout fth;
    private View fti;
    private h ftj;
    private com.baidu.tieba.ala.livecard.vc.a ftk;
    private com.baidu.tieba.ala.livecard.vc.b ftl;
    private com.baidu.tieba.ala.livecard.vc.c ftm;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.dKS = false;
        this.dKU = 5;
        this.fsO = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.ftl != null) {
                    int lP = d.this.ftl.lP(i + 1);
                    d.this.mCurrentIndex = lP;
                    if (d.this.dKN != null) {
                        d.this.dKN.setPosition(d.this.ftl.lQ(lP));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.ftg.getCount()) >= 2) {
                    int currentItem = d.this.ftf.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.ftf.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.ftf.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.ftm = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
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
        this.fsL = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.fti = getView().findViewById(R.id.divider_pager_and_indicator);
        this.ftf = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.fth = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.dKN = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.ftk = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.fsL);
        this.ftk.setUniqueId(getTag());
        this.ftf.setBackgroundResource(R.drawable.transparent_bg);
        this.ftf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ftg = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.ftf.setAdapter(this.ftg);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.fsO = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.fsO = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.fsL.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.ftj != null && !v.isEmpty(d.this.ftj.kQh) && d.this.ftj.kQh.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fsO);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.fsO);
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
        if (hVar != null && hVar.kQh != null) {
            this.ftj = hVar;
            setVisibility(0);
            if (this.ftl == null) {
                this.ftl = new com.baidu.tieba.ala.livecard.vc.b(hVar.kQh, this.dKS, this.dKU);
                this.ftl.lS(2);
                this.ftl.lR(6);
                this.ftl.lT(1);
            }
            this.ftl.ak(hVar.kQh);
            this.ftg.setForumName(this.mForumName);
            this.ftg.a(this.ftl.aRg(), this.ftm);
            this.ftf.setCurrentItem(this.ftl.aRf(), false);
            if (hVar.kQh.size() >= 2) {
                this.fth.setVisibility(0);
                if (this.dKN.getCount() != this.ftl.aRe()) {
                    this.dKN.setCount(this.ftl.aRe());
                    this.mCurrentIndex = this.ftl.aRf();
                }
                this.dKN.setPosition(this.ftl.lQ(this.mCurrentIndex));
            } else {
                this.fth.setVisibility(8);
            }
            if (hVar.kQh.size() > 0) {
                this.ftk.e(hVar.kQh.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bqv();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bqv() {
        int lQ;
        if (this.ftj != null && v.isEmpty(this.ftj.kQh) && (lQ = this.ftl.lQ(this.mCurrentIndex)) < this.ftj.kQh.size() && lQ >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.ftj.kQh != null && this.ftj.kQh.get(lQ) != null) {
                this.ftj.kQh.get(lQ).doZ = this.doZ;
            }
            customMessage.setData(this.ftj.kQh.get(lQ));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.ftj.kQh.get(lQ) != null) {
                TiebaStatic.log(new an("c12804").cI("tid", this.ftj.kQh.get(lQ).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bj bjVar) {
        if (bjVar.aKX() != null && bjVar.aKX().user_info != null && bjVar.aKX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").cI("tid", bjVar.getId()));
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
    public void pV(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsL, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.fti, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.ftk.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        if (tbPageContext != null && bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
            if (bjVar.aKX() != null && bjVar.aKX().user_info != null) {
                alaLiveInfoCoreData.userName = bjVar.aKX().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.ftj != null && !v.isEmpty(this.ftj.kQh)) {
                for (bj bjVar2 : this.ftj.kQh) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
        alaLiveInfoCoreData.userName = bjVar.aKE().getUserName();
        return alaLiveInfoCoreData;
    }
}
