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
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    public int dZf;
    private View dividerLine;
    private int eyB;
    private IndicatorView eyu;
    private boolean eyz;
    private boolean gjB;
    private FrsAlaStageLiveViewPager gjS;
    private FrsAlaStageLiveViewItemAdapter gjT;
    private LinearLayout gjU;
    private View gjV;
    private h gjW;
    private com.baidu.tieba.ala.livecard.vc.a gjX;
    private com.baidu.tieba.ala.livecard.vc.b gjY;
    private com.baidu.tieba.ala.livecard.vc.c gjZ;
    private ForbidParentSwipeBackRelativeLayout gjy;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eyz = false;
        this.eyB = 5;
        this.gjB = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gjY != null) {
                    int pp = d.this.gjY.pp(i + 1);
                    d.this.mCurrentIndex = pp;
                    if (d.this.eyu != null) {
                        d.this.eyu.setPosition(d.this.gjY.pq(pp));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gjT.getCount()) >= 2) {
                    int currentItem = d.this.gjS.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gjS.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gjS.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gjZ = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bw bwVar) {
                d.this.e(view, bwVar);
                d.this.U(bwVar);
                d.this.a(d.this.mTbPageContext, bwVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bw bwVar) {
                d.this.e(view, bwVar);
            }
        };
        this.gjy = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gjV = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gjS = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gjU = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eyu = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gjX = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gjy);
        this.gjX.setUniqueId(getTag());
        this.gjS.setBackgroundResource(R.drawable.transparent_bg);
        this.gjS.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gjT = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gjS.setAdapter(this.gjT);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gjB = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gjB = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gjy.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gjW != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.gjW.mcU) && d.this.gjW.mcU.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gjB);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gjB);
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
        if (hVar != null && hVar.mcU != null) {
            this.gjW = hVar;
            setVisibility(0);
            if (this.gjY == null) {
                this.gjY = new com.baidu.tieba.ala.livecard.vc.b(hVar.mcU, this.eyz, this.eyB);
                this.gjY.ps(2);
                this.gjY.pr(6);
                this.gjY.pt(1);
            }
            this.gjY.bS(hVar.mcU);
            this.gjT.setForumName(this.mForumName);
            this.gjT.a(this.gjY.blU(), this.gjZ);
            this.gjS.setCurrentItem(this.gjY.blT(), false);
            if (hVar.mcU.size() >= 2) {
                this.gjU.setVisibility(0);
                if (this.eyu.getCount() != this.gjY.blS()) {
                    this.eyu.setCount(this.gjY.blS());
                    this.mCurrentIndex = this.gjY.blT();
                }
                this.eyu.setPosition(this.gjY.pq(this.mCurrentIndex));
            } else {
                this.gjU.setVisibility(8);
            }
            if (hVar.mcU.size() > 0) {
                this.gjX.l(hVar.mcU.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bLR();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bLR() {
        int pq;
        if (this.gjW != null && com.baidu.tbadk.core.util.y.isEmpty(this.gjW.mcU) && (pq = this.gjY.pq(this.mCurrentIndex)) < this.gjW.mcU.size() && pq >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gjW.mcU != null && this.gjW.mcU.get(pq) != null) {
                this.gjW.mcU.get(pq).dZf = this.dZf;
            }
            customMessage.setData(this.gjW.mcU.get(pq));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gjW.mcU.get(pq) != null) {
                TiebaStatic.log(new aq("c12804").dD("tid", this.gjW.mcU.get(pq).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(bw bwVar) {
        if (bwVar.beY() != null && bwVar.beY().user_info != null && bwVar.beY().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dD("tid", bwVar.getId()));
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

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjy, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gjV, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gjX.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            if (bwVar.beY() != null && bwVar.beY().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.beY().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gjW != null && !com.baidu.tbadk.core.util.y.isEmpty(this.gjW.mcU)) {
                for (bw bwVar2 : this.gjW.mcU) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }
}
