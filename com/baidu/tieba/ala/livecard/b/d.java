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
    private IndicatorView eVb;
    private boolean eVg;
    private int eVi;
    public int evR;
    private ForbidParentSwipeBackRelativeLayout gMM;
    private boolean gMP;
    private FrsAlaStageLiveViewPager gNg;
    private FrsAlaStageLiveViewItemAdapter gNh;
    private LinearLayout gNi;
    private View gNj;
    private h gNk;
    private com.baidu.tieba.ala.livecard.vc.a gNl;
    private com.baidu.tieba.ala.livecard.vc.b gNm;
    private com.baidu.tieba.ala.livecard.vc.c gNn;
    private int mCurrentIndex;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mCurrentIndex = 1;
        this.eVg = false;
        this.eVi = 5;
        this.gMP = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.mCurrentIndex = i;
                if (d.this.gNm != null) {
                    int ql = d.this.gNm.ql(i + 1);
                    d.this.mCurrentIndex = ql;
                    if (d.this.eVb != null) {
                        d.this.eVb.setPosition(d.this.gNm.qm(ql));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.gNh.getCount()) >= 2) {
                    int currentItem = d.this.gNg.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.gNg.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.gNg.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.gNn = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
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
        this.gMM = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.gNj = getView().findViewById(R.id.divider_pager_and_indicator);
        this.gNg = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.gNi = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.eVb = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.gNl = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.gMM);
        this.gNl.setUniqueId(getTag());
        this.gNg.setBackgroundResource(R.drawable.transparent_bg);
        this.gNg.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gNh = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.gNg.setAdapter(this.gNh);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.gMP = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.gMP = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.gMM.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.gNk != null && !y.isEmpty(d.this.gNk.mOF) && d.this.gNk.mOF.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gMP);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.gMP);
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
        if (hVar != null && hVar.mOF != null) {
            this.gNk = hVar;
            setVisibility(0);
            if (this.gNm == null) {
                this.gNm = new com.baidu.tieba.ala.livecard.vc.b(hVar.mOF, this.eVg, this.eVi);
                this.gNm.qo(2);
                this.gNm.qn(6);
                this.gNm.qp(1);
            }
            this.gNm.ck(hVar.mOF);
            this.gNh.setForumName(this.mForumName);
            this.gNh.a(this.gNm.brr(), this.gNn);
            this.gNg.setCurrentItem(this.gNm.brq(), false);
            if (hVar.mOF.size() >= 2) {
                this.gNi.setVisibility(0);
                if (this.eVb.getCount() != this.gNm.brp()) {
                    this.eVb.setCount(this.gNm.brp());
                    this.mCurrentIndex = this.gNm.brq();
                }
                this.eVb.setPosition(this.gNm.qm(this.mCurrentIndex));
            } else {
                this.gNi.setVisibility(8);
            }
            if (hVar.mOF.size() > 0) {
                this.gNl.l(hVar.mOF.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bTp();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bTp() {
        int qm;
        if (this.gNk != null && y.isEmpty(this.gNk.mOF) && (qm = this.gNm.qm(this.mCurrentIndex)) < this.gNk.mOF.size() && qm >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.gNk.mOF != null && this.gNk.mOF.get(qm) != null) {
                this.gNk.mOF.get(qm).evR = this.evR;
            }
            customMessage.setData(this.gNk.mOF.get(qm));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.gNk.mOF.get(qm) != null) {
                TiebaStatic.log(new aq("c12804").dR("tid", this.gNk.mOF.get(qm).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(bw bwVar) {
        if (bwVar.bku() != null && bwVar.bku().user_info != null && bwVar.bku().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dR("tid", bwVar.getId()));
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

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMM, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.gNj, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.gNl.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bka().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
            if (bwVar.bku() != null && bwVar.bku().user_info != null) {
                alaLiveInfoCoreData.userName = bwVar.bku().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.gNk != null && !y.isEmpty(this.gNk.mOF)) {
                for (bw bwVar2 : this.gNk.mOF) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
        alaLiveInfoCoreData.userName = bwVar.bka().getUserName();
        return alaLiveInfoCoreData;
    }
}
