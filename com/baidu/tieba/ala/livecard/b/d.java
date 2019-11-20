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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<g> implements z {
    private int apz;
    public int cdI;
    private IndicatorView csm;
    private boolean csr;
    private int cst;
    private ForbidParentSwipeBackRelativeLayout dSV;
    private boolean dSY;
    private FrsAlaStageLiveViewPager dTq;
    private FrsAlaStageLiveViewItemAdapter dTr;
    private LinearLayout dTs;
    private View dTt;
    private g dTu;
    private com.baidu.tieba.ala.livecard.vc.a dTv;
    private com.baidu.tieba.ala.livecard.vc.b dTw;
    private com.baidu.tieba.ala.livecard.vc.c dTx;
    private View dividerLine;
    private String mForumName;
    ViewPager.OnPageChangeListener mOnPageChangeListener;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.apz = 1;
        this.csr = false;
        this.cst = 5;
        this.dSY = true;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.d.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                d.this.apz = i;
                if (d.this.dTw != null) {
                    int iX = d.this.dTw.iX(i + 1);
                    d.this.apz = iX;
                    if (d.this.csm != null) {
                        d.this.csm.setPosition(d.this.dTw.iY(iX));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (i != 1 && i == 0 && (count = d.this.dTr.getCount()) >= 2) {
                    int currentItem = d.this.dTq.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        d.this.dTq.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        d.this.dTq.setCurrentItem(1, false);
                    }
                }
            }
        };
        this.dTx = new com.baidu.tieba.ala.livecard.vc.c() { // from class: com.baidu.tieba.ala.livecard.b.d.3
            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void b(View view, bh bhVar) {
                d.this.d(view, bhVar);
                d.this.O(bhVar);
                d.this.a(d.this.mTbPageContext, bhVar);
            }

            @Override // com.baidu.tieba.ala.livecard.vc.c
            public void c(View view, bh bhVar) {
                d.this.d(view, bhVar);
            }
        };
        this.dSV = (ForbidParentSwipeBackRelativeLayout) getView().findViewById(R.id.layout_root);
        this.dividerLine = getView().findViewById(R.id.divider_line);
        this.dTt = getView().findViewById(R.id.divider_pager_and_indicator);
        this.dTq = (FrsAlaStageLiveViewPager) getView().findViewById(R.id.frs_stage_live_listview);
        this.dTs = (LinearLayout) getView().findViewById(R.id.frs_stage_indicator_parent);
        this.csm = (IndicatorView) getView().findViewById(R.id.frs_stage_indicator);
        this.dTv = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.dSV);
        this.dTv.setUniqueId(getTag());
        this.dTq.setBackgroundResource(R.drawable.transparent_bg);
        this.dTq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.dTr = new FrsAlaStageLiveViewItemAdapter(this.mTbPageContext, getTag());
        this.dTq.setAdapter(this.dTr);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseActivity) {
            this.dSY = ((BaseActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
            this.dSY = ((BaseFragmentActivity) this.mTbPageContext.getOrignalPage()).isSwipeBackEnabled();
        }
        this.dSV.setSwipeControlInterface(new SwipeBackLayout.c() { // from class: com.baidu.tieba.ala.livecard.b.d.1
            @Override // com.baidu.adp.widget.SwipeBackLayout.c
            public void disableSwipeBack() {
                if (d.this.dTu != null && !v.isEmpty(d.this.dTu.jfr) && d.this.dTu.jfr.size() > 1) {
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
                    ((BaseActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.dSY);
                } else if (d.this.mTbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) d.this.mTbPageContext.getOrignalPage()).setSwipeBackEnabled(d.this.dSY);
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
        if (gVar != null && gVar.jfr != null) {
            this.dTu = gVar;
            setVisibility(0);
            if (this.dTw == null) {
                this.dTw = new com.baidu.tieba.ala.livecard.vc.b(gVar.jfr, this.csr, this.cst);
                this.dTw.ja(2);
                this.dTw.iZ(6);
                this.dTw.jb(1);
            }
            this.dTw.aY(gVar.jfr);
            this.dTr.setForumName(this.mForumName);
            this.dTr.a(this.dTw.aos(), this.dTx);
            this.dTq.setCurrentItem(this.dTw.aor(), false);
            if (gVar.jfr.size() >= 2) {
                this.dTs.setVisibility(0);
                if (this.csm.getCount() != this.dTw.aoq()) {
                    this.csm.setCount(this.dTw.aoq());
                    this.apz = this.dTw.aor();
                }
                this.csm.setPosition(this.dTw.iY(this.apz));
            } else {
                this.dTs.setVisibility(8);
            }
            if (gVar.jfr.size() > 0) {
                this.dTv.c(gVar.jfr.get(0), "ala_frs_stage_live_feed_back_type");
            }
            aMM();
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aMM() {
        int iY;
        if (this.dTu != null && v.isEmpty(this.dTu.jfr) && (iY = this.dTw.iY(this.apz)) < this.dTu.jfr.size() && iY >= 0) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
            if (this.dTu.jfr != null && this.dTu.jfr.get(iY) != null) {
                this.dTu.jfr.get(iY).cdI = this.cdI;
            }
            customMessage.setData(this.dTu.jfr.get(iY));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.dTu.jfr.get(iY) != null) {
                TiebaStatic.log(new an("c12804").bS("tid", this.dTu.jfr.get(iY).getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(bh bhVar) {
        if (bhVar.aiX() != null && bhVar.aiX().user_info != null && bhVar.aiX().user_info.is_official == 2) {
            TiebaStatic.log(new an("c12805").bS("tid", bhVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, bh bhVar) {
        CustomMessage customMessage = null;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
        } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
        } else if (view.getId() == R.id.video_container) {
            customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
        }
        if (customMessage != null && this.mTbPageContext != null) {
            customMessage.setData(bhVar);
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
    public void mW(int i) {
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSV, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dTt, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
        this.dTv.onChangeSkinType();
    }

    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            if (bhVar.aiX() != null && bhVar.aiX().user_info != null) {
                alaLiveInfoCoreData.userName = bhVar.aiX().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            if (this.dTu != null && !v.isEmpty(this.dTu.jfr)) {
                for (bh bhVar2 : this.dTu.jfr) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_five_floor_recommend", str, z, null, null, this.mForumName)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
        alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
        return alaLiveInfoCoreData;
    }
}
