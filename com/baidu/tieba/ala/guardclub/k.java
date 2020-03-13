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
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.i;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private boolean Yr;
    private CommonEmptyView aCY;
    private BaseActivity aGf;
    private final boolean eFI;
    private com.baidu.tieba.ala.guardclub.model.g eFX;
    private BdListView eFY;
    private LoadMoreFooter eFZ;
    private LinearLayout eGa;
    private TextView eGb;
    private HeadImageView eGc;
    private TbImageView eGd;
    private TextView eGe;
    private TextView eGf;
    private TextView eGg;
    private View eGh;
    private View eGi;
    private i eGj;
    private boolean eGk;
    private boolean eGl;
    private View.OnClickListener eGm;
    CustomMessageListener evY;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;

    public View getView() {
        return this.mRootView;
    }

    public void a(boolean z, final com.baidu.live.guardclub.f fVar) {
        boolean z2 = true;
        if (this.eGj != null) {
            this.eGj.a(fVar);
        }
        if (z && !this.Yr && fVar != null && !this.eFI) {
            this.eGa.setVisibility(0);
            this.eGb.setText(fVar.rank);
            if (ee(fVar.rank)) {
                this.eGb.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eGb.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eGe.setText(fVar.userName);
            if (fVar.apS > 0) {
                this.eGf.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.apS));
            } else {
                this.eGf.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.eGc.startLoad(fVar.aqp, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apR);
            if (!TextUtils.isEmpty(bR)) {
                this.eGd.startLoad(bR, 10, false);
                this.eGd.setVisibility(0);
            } else {
                this.eGd.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eGl) {
                z2 = false;
            }
            this.eGg.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGh.getLayoutParams();
                layoutParams.rightMargin = this.eGh.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eGh.setLayoutParams(layoutParams);
            }
            this.eGi.setVisibility(0);
            this.eGi.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.eGi.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.apS;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.apS <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.eGi.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.eGi.setLayoutParams(layoutParams2);
                }
            });
            this.eGg.setOnClickListener(this.eGm);
            return;
        }
        this.eGa.setVisibility(8);
    }

    private boolean ee(String str) {
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

    public k(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.eGm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aGf != null) {
                    if (!k.this.isFullScreen) {
                        k.this.aGf.getActivity().setResult(-1);
                        k.this.aGf.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awC.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.aGf.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.eGj != null) {
                        k.this.eGj.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.aGf = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.eFI = z3;
        this.isFullScreen = z4;
        this.eGk = z2;
        this.Yr = z;
        this.mRootView = LayoutInflater.from(this.aGf).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eFY = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aCY = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eGa = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        ta();
        this.eGb = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eGc = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eGd = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eGe = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eGf = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eGg = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eGh = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eGi = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eGc.setIsRound(true);
        this.eGc.setAutoChangeStyle(false);
        this.eGj = new i(baseActivity, bdUniqueId, z, z3);
        this.eGj.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.aGf, k.this.aGf.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.aGf.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aqn ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.eFY.setAdapter((ListAdapter) this.eGj);
        if (z3) {
            this.eFZ = new LoadMoreFooter(this.aGf);
            this.eFZ.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eFZ.createView();
            this.eFY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.eFZ.isLoading() && k.this.eFX.bfr() && i + i2 > i3 - 2 && k.this.eFX.bfr()) {
                        k.this.eFX.bft();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.evY);
    }

    public final void ta() {
        if (this.eGa != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aGf.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eGa.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eGa.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aGf.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eGa.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void iC(boolean z) {
        this.eGl = z;
    }

    public void completePullRefresh() {
        if (this.eFY != null) {
            this.eFY.completePullRefresh();
        }
    }

    public void bfm() {
        if (this.eFZ != null) {
            this.eFZ.endLoadData();
            this.eFY.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFZ != null) {
                this.eFY.setNextPage(null);
            }
        } else if (this.eFZ != null) {
            if (this.eFZ.getView().getParent() == null) {
                this.eFY.setNextPage(this.eFZ);
            }
            this.eFZ.showNoMoreData();
        }
    }

    public void bcv() {
        if (this.eFZ != null) {
            if (this.eFZ.getView().getParent() == null) {
                this.eFY.setNextPage(this.eFZ);
            }
            this.eFZ.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eGj != null) {
            this.eGj.setOtherParams(str);
        }
    }

    private void aiu() {
        bh(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.eFX = gVar;
        this.eFX.bfs();
    }

    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (this.eGj != null && list != null && !list.isEmpty()) {
            bh(0, 8);
            this.eGj.bu(list);
            return;
        }
        aiu();
    }

    public void bfn() {
        bbC();
    }

    public void bbC() {
        this.aCY.reset();
        this.aCY.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCY.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eFX != null) {
                    k.this.eFX.bfs();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aCY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aCY.setVisibility(0);
        this.eFY.setVisibility(8);
        this.eGa.setVisibility(8);
    }

    private void bh(int i, int i2) {
        this.eFY.setVisibility(i);
        if (i2 == 0) {
            this.aCY.reset();
            if (this.Yr) {
                this.aCY.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aCY.setTitle(a.i.guard_member_list_empty);
            }
            this.aCY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aCY.setVisibility(0);
            return;
        }
        this.aCY.setVisibility(8);
    }

    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (this.eGj != null && this.eFI) {
            this.eGj.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfk() {
        if (this.eGj != null) {
            this.eGj.bfk();
        }
        MessageManager.getInstance().unRegisterListener(this.evY);
    }
}
