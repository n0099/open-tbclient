package com.baidu.tieba.ala.guardclub;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.g;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends BdBaseView<GuardClubMemberListActivity> {
    private boolean WF;
    private BaseActivity aBW;
    private CommonEmptyView ayG;
    private HeadImageView eBA;
    private TbImageView eBB;
    private TextView eBC;
    private TextView eBD;
    private TextView eBE;
    private View eBF;
    private View eBG;
    private g eBH;
    private boolean eBI;
    private boolean eBJ;
    private View.OnClickListener eBK;
    private final boolean eBg;
    private com.baidu.tieba.ala.guardclub.model.l eBv;
    private BdListView eBw;
    private LoadMoreFooter eBx;
    private LinearLayout eBy;
    private TextView eBz;
    CustomMessageListener erA;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;

    public View getView() {
        return this.mRootView;
    }

    public void a(boolean z, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        boolean z2 = true;
        if (this.eBH != null) {
            this.eBH.a(kVar);
        }
        if (z && !this.WF && kVar != null && !this.eBg) {
            this.eBy.setVisibility(0);
            this.eBz.setText(kVar.rank);
            if (dP(kVar.rank)) {
                this.eBz.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eBz.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eBC.setText(kVar.userName);
            if (kVar.eCF > 0) {
                this.eBD.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score + "/" + kVar.eCF));
            } else {
                this.eBD.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score));
            }
            this.eBA.startLoad(kVar.bXf, 12, false);
            String pc = l.bcZ().pc(kVar.eCE);
            if (!TextUtils.isEmpty(pc)) {
                this.eBB.startLoad(pc, 10, false);
                this.eBB.setVisibility(0);
            } else {
                this.eBB.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eBJ) {
                z2 = false;
            }
            this.eBE.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBF.getLayoutParams();
                layoutParams.rightMargin = this.eBF.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eBF.setLayoutParams(layoutParams);
            }
            this.eBG.setVisibility(0);
            this.eBG.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) i.this.eBG.getParent()).getWidth();
                    double parseLong = (Long.parseLong(kVar.score) * 1.0d) / kVar.eCF;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (kVar.eCF <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = i.this.eBG.getLayoutParams();
                    layoutParams2.width = i;
                    i.this.eBG.setLayoutParams(layoutParams2);
                }
            });
            this.eBE.setOnClickListener(this.eBK);
            return;
        }
        this.eBy.setVisibility(8);
    }

    private boolean dP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public i(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.eBK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aBW != null) {
                    if (!i.this.isFullScreen) {
                        i.this.aBW.getActivity().setResult(-1);
                        i.this.aBW.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.s.a.wR().asq.YD) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(i.this.aBW.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(i.this.liveId, String.valueOf(i.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(i.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    i.this.otherParams = str;
                    if (i.this.eBH != null) {
                        i.this.eBH.setOtherParams(i.this.otherParams);
                    }
                }
            }
        };
        this.aBW = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.eBg = z3;
        this.isFullScreen = z4;
        this.eBI = z2;
        this.WF = z;
        this.mRootView = LayoutInflater.from(this.aBW).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eBw = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.ayG = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eBy = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        rP();
        this.eBz = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eBA = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eBB = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eBC = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eBD = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eBE = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eBF = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eBG = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eBA.setIsRound(true);
        this.eBA.setAutoChangeStyle(false);
        this.eBH = new g(baseActivity, bdUniqueId, z, z3);
        this.eBH.a(new g.b() { // from class: com.baidu.tieba.ala.guardclub.i.2
            @Override // com.baidu.tieba.ala.guardclub.g.b
            public void d(com.baidu.tieba.ala.guardclub.model.k kVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(i.this.aBW, i.this.aBW.getString(a.i.sdk_neterror));
                } else if (kVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(i.this.aBW.getActivity(), String.valueOf(kVar.userId), kVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, kVar.evd ? 1 : 0, "", "", false, null, null, kVar.userName, i.this.otherParams, true)));
                }
            }
        });
        this.eBw.setAdapter((ListAdapter) this.eBH);
        if (z3) {
            this.eBx = new LoadMoreFooter(this.aBW);
            this.eBx.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eBx.createView();
            this.eBw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!i.this.eBx.isLoading() && i.this.eBv.bdg() && i + i2 > i3 - 2 && i.this.eBv.bdg()) {
                        i.this.eBv.bdi();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.erA);
    }

    public final void rP() {
        if (this.eBy != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aBW.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eBy.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eBy.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aBW.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eBy.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void iv(boolean z) {
        this.eBJ = z;
    }

    public void completePullRefresh() {
        if (this.eBw != null) {
            this.eBw.completePullRefresh();
        }
    }

    public void bcU() {
        if (this.eBx != null) {
            this.eBx.endLoadData();
            this.eBw.setNextPage(null);
        }
    }

    public void iw(boolean z) {
        if (z) {
            if (this.eBx != null) {
                this.eBw.setNextPage(null);
            }
        } else if (this.eBx != null) {
            if (this.eBx.getView().getParent() == null) {
                this.eBw.setNextPage(this.eBx);
            }
            this.eBx.showNoMoreData();
        }
    }

    public void bac() {
        if (this.eBx != null) {
            if (this.eBx.getView().getParent() == null) {
                this.eBw.setNextPage(this.eBx);
            }
            this.eBx.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eBH != null) {
            this.eBH.setOtherParams(str);
        }
    }

    private void age() {
        bh(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.l lVar) {
        this.eBv = lVar;
        this.eBv.bdh();
    }

    public void bu(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eBH != null && list != null && !list.isEmpty()) {
            bh(0, 8);
            this.eBH.bu(list);
            return;
        }
        age();
    }

    public void bcV() {
        aZk();
    }

    public void aZk() {
        this.ayG.reset();
        this.ayG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ayG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.eBv != null) {
                    i.this.eBv.bdh();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.ayG.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.ayG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.ayG.setVisibility(0);
        this.eBw.setVisibility(8);
        this.eBy.setVisibility(8);
    }

    private void bh(int i, int i2) {
        this.eBw.setVisibility(i);
        if (i2 == 0) {
            this.ayG.reset();
            if (this.WF) {
                this.ayG.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.ayG.setTitle(a.i.guard_member_list_empty);
            }
            this.ayG.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.ayG.setVisibility(0);
            return;
        }
        this.ayG.setVisibility(8);
    }

    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eBH != null && this.eBg) {
            this.eBH.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcS() {
        if (this.eBH != null) {
            this.eBH.bcS();
        }
        MessageManager.getInstance().unRegisterListener(this.erA);
    }
}
