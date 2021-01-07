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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.y;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<h> implements y {
    private int bMx;
    private View dividerLine;
    public int eQR;
    private IndicatorView frg;
    private boolean frl;
    private int frn;
    private ForbidParentSwipeBackRelativeLayout hnT;
    private boolean hnW;
    private FrsAlaStageLiveViewPager hon;
    private FrsAlaStageLiveViewItemAdapter hoo;
    private LinearLayout hop;
    private View hoq;
    private h hor;
    private com.baidu.tieba.ala.livecard.vc.a hos;
    private com.baidu.tieba.ala.livecard.vc.b hou;
    private com.baidu.tieba.ala.livecard.vc.c hov;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMx = 1;
        this.frl = false;
        this.frn = 5;
        this.hnW = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.d.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.bMx = i;
                if (d.this.hou != null) {
                    int rG = d.this.hou.rG(i + 1);
                    d.this.bMx = rG;
                    if (d.this.frg != null) {
                        d.this.frg.setPosition(d.this.hou.rH(rG));
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.hoo.getCount()) >= 2) {
                    int currentItem = d.this.hon.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.hon.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.hon.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.hov = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.a.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bz bzVar) {
                d.this.e(view, bzVar);
                d.this.X(bzVar);
                d.this.a(d.this.mTbPageContext, bzVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void d(View view, bz bzVar) {
                d.this.e(view, bzVar);
            }
        };
        this.hnT = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.hoq = getView().findViewById(R.id.divider_pager_and_indicator);
        this.hon = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.hop = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.frg = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.hos = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.hnT);
        this.hos.setUniqueId(getTag());
        this.hon.setBackgroundResource(R.drawable.transparent_bg);
        this.hon.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hoo = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.hon.setAdapter(this.hoo);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.hnW = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.hnW = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.hnT.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.a.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.hor != null && !x.isEmpty(d.this.hor.npi) && d.this.hor.npi.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hnW);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.hnW);
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
        if (hVar != null && hVar.npi != null) {
            this.hor = hVar;
            setVisibility(0);
            if (this.hou == null) {
                this.hou = new com.baidu.tieba.ala.livecard.vc.b(hVar.npi, this.frl, this.frn);
                this.hou.rJ(2);
                this.hou.rI(6);
                this.hou.rK(1);
            }
            this.hou.cC(hVar.npi);
            this.hoo.setForumName(this.mForumName);
            this.hoo.a(this.hou.bzb(), this.hov);
            this.hon.setCurrentItem(this.hou.bza(), false);
            if (hVar.npi.size() >= 2) {
                this.hop.setVisibility(0);
                if (this.frg.getCount() != this.hou.byZ()) {
                    this.frg.setCount(this.hou.byZ());
                    this.bMx = this.hou.bza();
                }
                this.frg.setPosition(this.hou.rH(this.bMx));
            } else {
                this.hop.setVisibility(8);
            }
            if (hVar.npi.size() > 0) {
                this.hos.l(hVar.npi.get(0), "ala_frs_stage_live_feed_back_type");
            }
            cbJ();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cbJ() {
        int rH;
        if (this.hor != null && x.isEmpty(this.hor.npi) && (rH = this.hou.rH(this.bMx)) < this.hor.npi.size() && rH >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.hor.npi != null && this.hor.npi.get(rH) != null) {
                this.hor.npi.get(rH).eQR = this.eQR;
            }
            customMessage.setData(this.hor.npi.get(rH));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.hor.npi.get(rH) != null) {
                TiebaStatic.log(new aq("c12804").dX("tid", this.hor.npi.get(rH).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(bz bzVar) {
        if (bzVar.brK() != null && bzVar.brK().user_info != null && bzVar.brK().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12805").dX("tid", bzVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bz bzVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bzVar);
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
    public void wt(int i) {
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hnT, R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.dividerLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.hoq, R.color.CAM_X0204);
            this.mSkinType = i;
        }
        this.hos.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        if (tbPageContext != null && bzVar != null && bzVar.brr() != null && bzVar.brK() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brr().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brK());
            if (bzVar.brK() != null && bzVar.brK().user_info != null) {
                alaLiveInfoCoreData.userName = bzVar.brK().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.hor != null && !x.isEmpty(this.hor.npi)) {
                for (bz bzVar2 : this.hor.npi) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.brK());
        alaLiveInfoCoreData.userName = bzVar.brr().getUserName();
        return alaLiveInfoCoreData;
    }
}
