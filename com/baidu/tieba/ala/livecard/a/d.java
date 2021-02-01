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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<h> implements z {
    private int bLv;
    private View dividerLine;
    public int eOs;
    private IndicatorView foO;
    private boolean foT;
    private int foV;
    private ForbidParentSwipeBackRelativeLayout hnA;
    private boolean hnD;
    private FrsAlaStageLiveViewPager hnU;
    private FrsAlaStageLiveViewItemAdapter hnV;
    private LinearLayout hnW;
    private View hnX;
    private h hnY;
    private com.baidu.tieba.ala.livecard.vc.a hnZ;
    private com.baidu.tieba.ala.livecard.vc.b hoa;
    private com.baidu.tieba.ala.livecard.vc.c hob;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLv = 1;
        this.foT = false;
        this.foV = 5;
        this.hnD = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.d.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.bLv = i;
                if (d.this.hoa != null) {
                    int qf = d.this.hoa.qf(i + 1);
                    d.this.bLv = qf;
                    if (d.this.foO != null) {
                        d.this.foO.setPosition(d.this.hoa.qg(qf));
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.hnV.getCount()) >= 2) {
                    int currentItem = d.this.hnU.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.hnU.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.hnU.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.hob = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.a.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, cb cbVar) {
                d.this.e(view, cbVar);
                d.this.Y(cbVar);
                d.this.a(d.this.mTbPageContext, cbVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, cb cbVar) {
                d.this.e(view, cbVar);
            }
        };
        this.hnA = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hnX = getView().findViewById(R.id.divider_pager_and_indicator);
        this.hnU = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.hnW = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.foO = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.hnZ = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.hnA);
        this.hnZ.setUniqueId(getTag());
        this.hnU.setBackgroundResource(R.drawable.transparent_bg);
        this.hnU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hnV = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.hnU.setAdapter(this.hnV);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hnD = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hnD = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hnA.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.a.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.hnY != null && !y.isEmpty(d.this.hnY.nuk) && d.this.hnY.nuk.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hnD);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hnD);
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
        if (hVar != null && hVar.nuk != null) {
            this.hnY = hVar;
            setVisibility(0);
            if (this.hoa == null) {
                this.hoa = new com.baidu.tieba.ala.livecard.vc.b(hVar.nuk, this.foT, this.foV);
                this.hoa.qi(2);
                this.hoa.qh(6);
                this.hoa.qj(1);
            }
            this.hoa.cx(hVar.nuk);
            this.hnV.setForumName(this.mForumName);
            this.hnV.a(this.hoa.bvB(), this.hob);
            this.hnU.setCurrentItem(this.hoa.bvA(), false);
            if (hVar.nuk.size() >= 2) {
                this.hnW.setVisibility(0);
                if (this.foO.getCount() != this.hoa.bvz()) {
                    this.foO.setCount(this.hoa.bvz());
                    this.bLv = this.hoa.bvA();
                }
                this.foO.setPosition(this.hoa.qg(this.bLv));
            } else {
                this.hnW.setVisibility(8);
            }
            if (hVar.nuk.size() > 0) {
                this.hnZ.l(hVar.nuk.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bYP();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bYP() {
        int qg;
        if (this.hnY != null && y.isEmpty(this.hnY.nuk) && (qg = this.hoa.qg(this.bLv)) < this.hnY.nuk.size() && qg >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.hnY.nuk != null && this.hnY.nuk.get(qg) != null) {
                this.hnY.nuk.get(qg).eOs = this.eOs;
            }
            customMessage.setData(this.hnY.nuk.get(qg));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.hnY.nuk.get(qg) != null) {
                TiebaStatic.log(new ar("c12804").dR("tid", this.hnY.nuk.get(qg).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(cb cbVar) {
        if (cbVar.boj() != null && cbVar.boj().user_info != null && cbVar.boj().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12805").dR("tid", cbVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, cb cbVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(cbVar);
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
    public void uX(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hnA, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hnX, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.hnZ.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            if (cbVar.boj() != null && cbVar.boj().user_info != null) {
                alaLiveInfoCoreData.userName = cbVar.boj().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hnY != null && !y.isEmpty(this.hnY.nuk)) {
                for (cb cbVar2 : this.hnY.nuk) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
        alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
        return alaLiveInfoCoreData;
    }
}
