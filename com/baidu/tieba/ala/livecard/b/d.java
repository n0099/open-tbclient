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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    public int eAb;
    private IndicatorView eZY;
    private boolean fad;
    private int faf;
    private ForbidParentSwipeBackRelativeLayout gSS;
    private boolean gSV;
    private FrsAlaStageLiveViewPager gTm;
    private FrsAlaStageLiveViewItemAdapter gTn;
    private LinearLayout gTo;
    private View gTp;
    private h gTq;
    private com.baidu.tieba.ala.livecard.vc.a gTr;
    private com.baidu.tieba.ala.livecard.vc.b gTs;
    private com.baidu.tieba.ala.livecard.vc.c gTt;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.fad = false;
        this.faf = 5;
        this.gSV = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gTs != null) {
                    int qT = d.this.gTs.qT(i + 1);
                    d.this.mCurrentIndex = qT;
                    if (d.this.eZY != null) {
                        d.this.eZY.setPosition(d.this.gTs.qU(qT));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gTn.getCount()) >= 2) {
                    int currentItem = d.this.gTm.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gTm.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gTm.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gTt = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bx bxVar) {
                d.this.e(view, bxVar);
                d.this.X(bxVar);
                d.this.a(d.this.mTbPageContext, bxVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bx bxVar) {
                d.this.e(view, bxVar);
            }
        };
        this.gSS = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gTp = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gTm = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gTo = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eZY = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gTr = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gSS);
        this.gTr.setUniqueId(getTag());
        this.gTm.setBackgroundResource(R.drawable.transparent_bg);
        this.gTm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gTn = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gTm.setAdapter(this.gTn);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gSV = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gSV = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gSS.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gTq != null && !y.isEmpty(d.this.gTq.mVC) && d.this.gTq.mVC.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gSV);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gSV);
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
        if (hVar != null && hVar.mVC != null) {
            this.gTq = hVar;
            setVisibility(0);
            if (this.gTs == null) {
                this.gTs = new com.baidu.tieba.ala.livecard.vc.b(hVar.mVC, this.fad, this.faf);
                this.gTs.qW(2);
                this.gTs.qV(6);
                this.gTs.qX(1);
            }
            this.gTs.cr(hVar.mVC);
            this.gTn.setForumName(this.mForumName);
            this.gTn.a(this.gTs.bth(), this.gTt);
            this.gTm.setCurrentItem(this.gTs.btg(), false);
            if (hVar.mVC.size() >= 2) {
                this.gTo.setVisibility(0);
                if (this.eZY.getCount() != this.gTs.btf()) {
                    this.eZY.setCount(this.gTs.btf());
                    this.mCurrentIndex = this.gTs.btg();
                }
                this.eZY.setPosition(this.gTs.qU(this.mCurrentIndex));
            } else {
                this.gTo.setVisibility(8);
            }
            if (hVar.mVC.size() > 0) {
                this.gTr.l(hVar.mVC.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bVq();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bVq() {
        int qU;
        if (this.gTq != null && y.isEmpty(this.gTq.mVC) && (qU = this.gTs.qU(this.mCurrentIndex)) < this.gTq.mVC.size() && qU >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gTq.mVC != null && this.gTq.mVC.get(qU) != null) {
                this.gTq.mVC.get(qU).eAb = this.eAb;
            }
            customMessage.setData(this.gTq.mVC.get(qU));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gTq.mVC.get(qU) != null) {
                TiebaStatic.log(new ar("c12804").dR("tid", this.gTq.mVC.get(qU).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(bx bxVar) {
        if (bxVar.blW() != null && bxVar.blW().user_info != null && bxVar.blW().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12805").dR("tid", bxVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bx bxVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bxVar);
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
    public void vB(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSS, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.gTp, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.gTr.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bx bxVar) {
        if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bxVar.blC().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            if (bxVar.blW() != null && bxVar.blW().user_info != null) {
                alaLiveInfoCoreData.userName = bxVar.blW().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gTq != null && !y.isEmpty(this.gTq.mVC)) {
                for (bx bxVar2 : this.gTq.mVC) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bxVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(bx bxVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
        alaLiveInfoCoreData.userName = bxVar.blC().getUserName();
        return alaLiveInfoCoreData;
    }
}
