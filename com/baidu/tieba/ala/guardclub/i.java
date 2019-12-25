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
import com.baidu.live.q.a;
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
    private boolean Wm;
    private BaseActivity aBe;
    private CommonEmptyView axX;
    private com.baidu.tieba.ala.guardclub.model.l eAk;
    private BdListView eAl;
    private LoadMoreFooter eAm;
    private LinearLayout eAn;
    private TextView eAo;
    private HeadImageView eAp;
    private TbImageView eAq;
    private TextView eAr;
    private TextView eAs;
    private TextView eAt;
    private View eAu;
    private View eAv;
    private g eAw;
    private boolean eAx;
    private boolean eAy;
    private View.OnClickListener eAz;
    CustomMessageListener eqn;
    private final boolean ezV;
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
        if (this.eAw != null) {
            this.eAw.a(kVar);
        }
        if (z && !this.Wm && kVar != null && !this.ezV) {
            this.eAn.setVisibility(0);
            this.eAo.setText(kVar.rank);
            if (dN(kVar.rank)) {
                this.eAo.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eAo.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eAr.setText(kVar.userName);
            if (kVar.eBu > 0) {
                this.eAs.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score + "/" + kVar.eBu));
            } else {
                this.eAs.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score));
            }
            this.eAp.startLoad(kVar.bWT, 12, false);
            String pb = l.bcE().pb(kVar.eBt);
            if (!TextUtils.isEmpty(pb)) {
                this.eAq.startLoad(pb, 10, false);
                this.eAq.setVisibility(0);
            } else {
                this.eAq.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eAy) {
                z2 = false;
            }
            this.eAt.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAu.getLayoutParams();
                layoutParams.rightMargin = this.eAu.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eAu.setLayoutParams(layoutParams);
            }
            this.eAv.setVisibility(0);
            this.eAv.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) i.this.eAv.getParent()).getWidth();
                    double parseLong = (Long.parseLong(kVar.score) * 1.0d) / kVar.eBu;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (kVar.eBu <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = i.this.eAv.getLayoutParams();
                    layoutParams2.width = i;
                    i.this.eAv.setLayoutParams(layoutParams2);
                }
            });
            this.eAt.setOnClickListener(this.eAz);
            return;
        }
        this.eAn.setVisibility(8);
    }

    private boolean dN(String str) {
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
        this.eAz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aBe != null) {
                    if (!i.this.isFullScreen) {
                        i.this.aBe.getActivity().setResult(-1);
                        i.this.aBe.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.r.a.wA().arE.Yr) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(i.this.aBe.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(i.this.liveId, String.valueOf(i.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(i.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    i.this.otherParams = str;
                    if (i.this.eAw != null) {
                        i.this.eAw.setOtherParams(i.this.otherParams);
                    }
                }
            }
        };
        this.aBe = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.ezV = z3;
        this.isFullScreen = z4;
        this.eAx = z2;
        this.Wm = z;
        this.mRootView = LayoutInflater.from(this.aBe).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eAl = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.axX = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eAn = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        rC();
        this.eAo = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eAp = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eAq = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eAr = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eAs = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eAt = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eAu = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eAv = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eAp.setIsRound(true);
        this.eAp.setAutoChangeStyle(false);
        this.eAw = new g(baseActivity, bdUniqueId, z, z3);
        this.eAw.a(new g.b() { // from class: com.baidu.tieba.ala.guardclub.i.2
            @Override // com.baidu.tieba.ala.guardclub.g.b
            public void d(com.baidu.tieba.ala.guardclub.model.k kVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(i.this.aBe, i.this.aBe.getString(a.i.sdk_neterror));
                } else if (kVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(i.this.aBe.getActivity(), String.valueOf(kVar.userId), kVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, kVar.etS ? 1 : 0, "", "", false, null, null, kVar.userName, i.this.otherParams, true)));
                }
            }
        });
        this.eAl.setAdapter((ListAdapter) this.eAw);
        if (z3) {
            this.eAm = new LoadMoreFooter(this.aBe);
            this.eAm.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eAm.createView();
            this.eAl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!i.this.eAm.isLoading() && i.this.eAk.bcL() && i + i2 > i3 - 2 && i.this.eAk.bcL()) {
                        i.this.eAk.bcN();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eqn);
    }

    public final void rC() {
        if (this.eAn != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aBe.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eAn.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eAn.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aBe.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eAn.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void il(boolean z) {
        this.eAy = z;
    }

    public void completePullRefresh() {
        if (this.eAl != null) {
            this.eAl.completePullRefresh();
        }
    }

    public void bcz() {
        if (this.eAm != null) {
            this.eAm.endLoadData();
            this.eAl.setNextPage(null);
        }
    }

    public void im(boolean z) {
        if (z) {
            if (this.eAm != null) {
                this.eAl.setNextPage(null);
            }
        } else if (this.eAm != null) {
            if (this.eAm.getView().getParent() == null) {
                this.eAl.setNextPage(this.eAm);
            }
            this.eAm.showNoMoreData();
        }
    }

    public void aZH() {
        if (this.eAm != null) {
            if (this.eAm.getView().getParent() == null) {
                this.eAl.setNextPage(this.eAm);
            }
            this.eAm.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eAw != null) {
            this.eAw.setOtherParams(str);
        }
    }

    private void afL() {
        bd(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.l lVar) {
        this.eAk = lVar;
        this.eAk.bcM();
    }

    public void bu(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eAw != null && list != null && !list.isEmpty()) {
            bd(0, 8);
            this.eAw.bu(list);
            return;
        }
        afL();
    }

    public void bcA() {
        aYQ();
    }

    public void aYQ() {
        this.axX.reset();
        this.axX.setTitle(a.i.sdk_net_fail_tip_rank);
        this.axX.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.eAk != null) {
                    i.this.eAk.bcM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.axX.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.axX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.axX.setVisibility(0);
        this.eAl.setVisibility(8);
        this.eAn.setVisibility(8);
    }

    private void bd(int i, int i2) {
        this.eAl.setVisibility(i);
        if (i2 == 0) {
            this.axX.reset();
            if (this.Wm) {
                this.axX.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.axX.setTitle(a.i.guard_member_list_empty);
            }
            this.axX.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.axX.setVisibility(0);
            return;
        }
        this.axX.setVisibility(8);
    }

    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eAw != null && this.ezV) {
            this.eAw.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcx() {
        if (this.eAw != null) {
            this.eAw.bcx();
        }
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }
}
