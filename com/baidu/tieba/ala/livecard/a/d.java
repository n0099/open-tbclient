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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<h> implements z {
    private int bMV;
    private View dividerLine;
    public int ePT;
    private IndicatorView fqo;
    private boolean fqt;
    private int fqv;
    private boolean hpB;
    private FrsAlaStageLiveViewPager hpS;
    private FrsAlaStageLiveViewItemAdapter hpT;
    private LinearLayout hpU;
    private View hpV;
    private h hpW;
    private com.baidu.tieba.ala.livecard.vc.a hpX;
    private com.baidu.tieba.ala.livecard.vc.b hpY;
    private com.baidu.tieba.ala.livecard.vc.c hpZ;
    private ForbidParentSwipeBackRelativeLayout hpy;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMV = 1;
        this.fqt = false;
        this.fqv = 5;
        this.hpB = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.d.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.bMV = i;
                if (d.this.hpY != null) {
                    int qg = d.this.hpY.qg(i + 1);
                    d.this.bMV = qg;
                    if (d.this.fqo != null) {
                        d.this.fqo.setPosition(d.this.hpY.qh(qg));
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.hpT.getCount()) >= 2) {
                    int currentItem = d.this.hpS.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.hpS.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.hpS.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.hpZ = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.a.d.3
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
        this.hpy = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hpV = getView().findViewById(R.id.divider_pager_and_indicator);
        this.hpS = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.hpU = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.fqo = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.hpX = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.hpy);
        this.hpX.setUniqueId(getTag());
        this.hpS.setBackgroundResource(R.drawable.transparent_bg);
        this.hpS.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hpT = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.hpS.setAdapter(this.hpT);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hpB = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hpB = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hpy.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.a.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.hpW != null && !y.isEmpty(d.this.hpW.nwP) && d.this.hpW.nwP.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hpB);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hpB);
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
        if (hVar != null && hVar.nwP != null) {
            this.hpW = hVar;
            setVisibility(0);
            if (this.hpY == null) {
                this.hpY = new com.baidu.tieba.ala.livecard.vc.b(hVar.nwP, this.fqt, this.fqv);
                this.hpY.qj(2);
                this.hpY.qi(6);
                this.hpY.qk(1);
            }
            this.hpY.cx(hVar.nwP);
            this.hpT.setForumName(this.mForumName);
            this.hpT.a(this.hpY.bvE(), this.hpZ);
            this.hpS.setCurrentItem(this.hpY.bvD(), false);
            if (hVar.nwP.size() >= 2) {
                this.hpU.setVisibility(0);
                if (this.fqo.getCount() != this.hpY.bvC()) {
                    this.fqo.setCount(this.hpY.bvC());
                    this.bMV = this.hpY.bvD();
                }
                this.fqo.setPosition(this.hpY.qh(this.bMV));
            } else {
                this.hpU.setVisibility(8);
            }
            if (hVar.nwP.size() > 0) {
                this.hpX.l(hVar.nwP.get(0), "ala_frs_stage_live_feed_back_type");
            }
            bZc();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bZc() {
        int qh;
        if (this.hpW != null && y.isEmpty(this.hpW.nwP) && (qh = this.hpY.qh(this.bMV)) < this.hpW.nwP.size() && qh >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.hpW.nwP != null && this.hpW.nwP.get(qh) != null) {
                this.hpW.nwP.get(qh).ePT = this.ePT;
            }
            customMessage.setData(this.hpW.nwP.get(qh));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.hpW.nwP.get(qh) != null) {
                TiebaStatic.log(new ar("c12804").dR("tid", this.hpW.nwP.get(qh).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(cb cbVar) {
        if (cbVar.bol() != null && cbVar.bol().user_info != null && cbVar.bol().user_info.is_official == 2) {
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
    public void uZ(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hpy, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.hpV, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.hpX.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        if (tbPageContext != null && cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnS().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
            if (cbVar.bol() != null && cbVar.bol().user_info != null) {
                alaLiveInfoCoreData.userName = cbVar.bol().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hpW != null && !y.isEmpty(this.hpW.nwP)) {
                for (cb cbVar2 : this.hpW.nwP) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
        alaLiveInfoCoreData.userName = cbVar.bnS().getUserName();
        return alaLiveInfoCoreData;
    }
}
