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
    private View dividerLine;
    private IndicatorView eMF;
    private boolean eMK;
    private int eMM;
    public int ens;
    private ForbidParentSwipeBackRelativeLayout gAY;
    private boolean gBb;
    private FrsAlaStageLiveViewPager gBs;
    private FrsAlaStageLiveViewItemAdapter gBt;
    private LinearLayout gBu;
    private View gBv;
    private h gBw;
    private com.baidu.tieba.ala.livecard.vc.a gBx;
    private com.baidu.tieba.ala.livecard.vc.b gBy;
    private com.baidu.tieba.ala.livecard.vc.c gBz;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eMK = false;
        this.eMM = 5;
        this.gBb = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gBy != null) {
                    int qa = d.this.gBy.qa(i + 1);
                    d.this.mCurrentIndex = qa;
                    if (d.this.eMF != null) {
                        d.this.eMF.setPosition(d.this.gBy.qb(qa));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gBt.getCount()) >= 2) {
                    int currentItem = d.this.gBs.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gBs.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gBs.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gBz = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
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
        this.gAY = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gBv = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gBs = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gBu = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eMF = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gBx = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gAY);
        this.gBx.setUniqueId(getTag());
        this.gBs.setBackgroundResource(R.drawable.transparent_bg);
        this.gBs.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gBt = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gBs.setAdapter(this.gBt);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gBb = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gBb = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gAY.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gBw != null && !com.baidu.tbadk.core.util.y.isEmpty(d.this.gBw.mBW) && d.this.gBw.mBW.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gBb);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gBb);
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
        if (hVar != null && hVar.mBW != null) {
            this.gBw = hVar;
            setVisibility(0);
            if (this.gBy == null) {
                this.gBy = new com.baidu.tieba.ala.livecard.vc.b(hVar.mBW, this.eMK, this.eMM);
                this.gBy.qd(2);
                this.gBy.qc(6);
                this.gBy.qe(1);
            }
            this.gBy.ca(hVar.mBW);
            this.gBt.setForumName(this.mForumName);
            this.gBt.a(this.gBy.bpy(), this.gBz);
            this.gBs.setCurrentItem(this.gBy.bpx(), false);
            if (hVar.mBW.size() >= 2) {
                this.gBu.setVisibility(0);
                if (this.eMF.getCount() != this.gBy.bpw()) {
                    this.eMF.setCount(this.gBy.bpw());
                    this.mCurrentIndex = this.gBy.bpx();
                }
                this.eMF.setPosition(this.gBy.qb(this.mCurrentIndex));
            } else {
                this.gBu.setVisibility(8);
            }
            if (hVar.mBW.size() > 0) {
                this.gBx.l(hVar.mBW.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bQs();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bQs() {
        int qb;
        if (this.gBw != null && com.baidu.tbadk.core.util.y.isEmpty(this.gBw.mBW) && (qb = this.gBy.qb(this.mCurrentIndex)) < this.gBw.mBW.size() && qb >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gBw.mBW != null && this.gBw.mBW.get(qb) != null) {
                this.gBw.mBW.get(qb).ens = this.ens;
            }
            customMessage.setData(this.gBw.mBW.get(qb));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gBw.mBW.get(qb) != null) {
                TiebaStatic.log(new aq("c12804").dK("tid", this.gBw.mBW.get(qb).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bw bwVar) {
        if (bwVar.biB() != null && bwVar.biB().user_info != null && bwVar.biB().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dK("tid", bwVar.getId()));
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
    public void ux(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAY, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gBv, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gBx.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bih().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
            if (bwVar.biB() != null && bwVar.biB().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.biB().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gBw != null && !com.baidu.tbadk.core.util.y.isEmpty(this.gBw.mBW)) {
                for (bw bwVar2 : this.gBw.mBW) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
        alaLiveInfoCoreData.userName = bwVar.bih().getUserName();
        return alaLiveInfoCoreData;
    }
}
