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
    public int dZb;
    private View dividerLine;
    private IndicatorView eyq;
    private boolean eyv;
    private int eyx;
    private FrsAlaStageLiveViewPager gjO;
    private FrsAlaStageLiveViewItemAdapter gjP;
    private LinearLayout gjQ;
    private View gjR;
    private h gjS;
    private com.baidu.tieba.ala.livecard.vc.a gjT;
    private com.baidu.tieba.ala.livecard.vc.b gjU;
    private com.baidu.tieba.ala.livecard.vc.c gjV;
    private ForbidParentSwipeBackRelativeLayout gju;
    private boolean gjx;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eyv = false;
        this.eyx = 5;
        this.gjx = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gjU != null) {
                    int pp = d.this.gjU.pp(i + 1);
                    d.this.mCurrentIndex = pp;
                    if (d.this.eyq != null) {
                        d.this.eyq.setPosition(d.this.gjU.pq(pp));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gjP.getCount()) >= 2) {
                    int currentItem = d.this.gjO.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gjO.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gjO.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gjV = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
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
        this.gju = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gjR = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gjO = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gjQ = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eyq = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gjT = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gju);
        this.gjT.setUniqueId(getTag());
        this.gjO.setBackgroundResource(R.drawable.transparent_bg);
        this.gjO.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gjP = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gjO.setAdapter(this.gjP);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gjx = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gjx = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gju.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gjS != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.gjS.mcF) && d.this.gjS.mcF.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gjx);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gjx);
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
        if (hVar != null && hVar.mcF != null) {
            this.gjS = hVar;
            setVisibility(0);
            if (this.gjU == null) {
                this.gjU = new com.baidu.tieba.ala.livecard.vc.b(hVar.mcF, this.eyv, this.eyx);
                this.gjU.ps(2);
                this.gjU.pr(6);
                this.gjU.pt(1);
            }
            this.gjU.bS(hVar.mcF);
            this.gjP.setForumName(this.mForumName);
            this.gjP.a(this.gjU.blU(), this.gjV);
            this.gjO.setCurrentItem(this.gjU.blT(), false);
            if (hVar.mcF.size() >= 2) {
                this.gjQ.setVisibility(0);
                if (this.eyq.getCount() != this.gjU.blS()) {
                    this.eyq.setCount(this.gjU.blS());
                    this.mCurrentIndex = this.gjU.blT();
                }
                this.eyq.setPosition(this.gjU.pq(this.mCurrentIndex));
            } else {
                this.gjQ.setVisibility(8);
            }
            if (hVar.mcF.size() > 0) {
                this.gjT.l(hVar.mcF.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bLQ();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bLQ() {
        int pq;
        if (this.gjS != null && com.baidu.tbadk.core.util.y.isEmpty(this.gjS.mcF) && (pq = this.gjU.pq(this.mCurrentIndex)) < this.gjS.mcF.size() && pq >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gjS.mcF != null && this.gjS.mcF.get(pq) != null) {
                this.gjS.mcF.get(pq).dZb = this.dZb;
            }
            customMessage.setData(this.gjS.mcF.get(pq));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gjS.mcF.get(pq) != null) {
                TiebaStatic.log(new aq("c12804").dD("tid", this.gjS.mcF.get(pq).getId()));
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
            ap.setBackgroundResource(this.gju, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gjR, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gjT.onChangeSkinType();
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
            if (this.gjS != null && !com.baidu.tbadk.core.util.y.isEmpty(this.gjS.mcF)) {
                for (bw bwVar2 : this.gjS.mcF) {
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
