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
    private boolean YB;
    private CommonEmptyView aDm;
    private BaseActivity aGt;
    private TextView eGA;
    private TextView eGB;
    private TextView eGC;
    private View eGD;
    private View eGE;
    private i eGF;
    private boolean eGG;
    private boolean eGH;
    private View.OnClickListener eGI;
    private final boolean eGe;
    private com.baidu.tieba.ala.guardclub.model.g eGt;
    private BdListView eGu;
    private LoadMoreFooter eGv;
    private LinearLayout eGw;
    private TextView eGx;
    private HeadImageView eGy;
    private TbImageView eGz;
    CustomMessageListener ewu;
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
        if (this.eGF != null) {
            this.eGF.a(fVar);
        }
        if (z && !this.YB && fVar != null && !this.eGe) {
            this.eGw.setVisibility(0);
            this.eGx.setText(fVar.rank);
            if (ed(fVar.rank)) {
                this.eGx.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eGx.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eGA.setText(fVar.userName);
            if (fVar.aqc > 0) {
                this.eGB.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aqc));
            } else {
                this.eGB.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.eGy.startLoad(fVar.aqz, 12, false);
            String bR = com.baidu.live.guardclub.g.vM().bR(fVar.aqb);
            if (!TextUtils.isEmpty(bR)) {
                this.eGz.startLoad(bR, 10, false);
                this.eGz.setVisibility(0);
            } else {
                this.eGz.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eGH) {
                z2 = false;
            }
            this.eGC.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGD.getLayoutParams();
                layoutParams.rightMargin = this.eGD.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eGD.setLayoutParams(layoutParams);
            }
            this.eGE.setVisibility(0);
            this.eGE.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.eGE.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aqc;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aqc <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.eGE.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.eGE.setLayoutParams(layoutParams2);
                }
            });
            this.eGC.setOnClickListener(this.eGI);
            return;
        }
        this.eGw.setVisibility(8);
    }

    private boolean ed(String str) {
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
        this.eGI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aGt != null) {
                    if (!k.this.isFullScreen) {
                        k.this.aGt.getActivity().setResult(-1);
                        k.this.aGt.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zs().awM.aaF) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.aGt.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.eGF != null) {
                        k.this.eGF.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.aGt = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.eGe = z3;
        this.isFullScreen = z4;
        this.eGG = z2;
        this.YB = z;
        this.mRootView = LayoutInflater.from(this.aGt).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eGu = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aDm = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eGw = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        tf();
        this.eGx = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eGy = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eGz = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eGA = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eGB = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eGC = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eGD = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eGE = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eGy.setIsRound(true);
        this.eGy.setAutoChangeStyle(false);
        this.eGF = new i(baseActivity, bdUniqueId, z, z3);
        this.eGF.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.aGt, k.this.aGt.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.aGt.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aqx ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.eGu.setAdapter((ListAdapter) this.eGF);
        if (z3) {
            this.eGv = new LoadMoreFooter(this.aGt);
            this.eGv.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eGv.createView();
            this.eGu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.eGv.isLoading() && k.this.eGt.bfw() && i + i2 > i3 - 2 && k.this.eGt.bfw()) {
                        k.this.eGt.bfy();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.ewu);
    }

    public final void tf() {
        if (this.eGw != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aGt.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eGw.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eGw.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aGt.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eGw.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void iE(boolean z) {
        this.eGH = z;
    }

    public void completePullRefresh() {
        if (this.eGu != null) {
            this.eGu.completePullRefresh();
        }
    }

    public void bfr() {
        if (this.eGv != null) {
            this.eGv.endLoadData();
            this.eGu.setNextPage(null);
        }
    }

    public void iF(boolean z) {
        if (z) {
            if (this.eGv != null) {
                this.eGu.setNextPage(null);
            }
        } else if (this.eGv != null) {
            if (this.eGv.getView().getParent() == null) {
                this.eGu.setNextPage(this.eGv);
            }
            this.eGv.showNoMoreData();
        }
    }

    public void bcz() {
        if (this.eGv != null) {
            if (this.eGv.getView().getParent() == null) {
                this.eGu.setNextPage(this.eGv);
            }
            this.eGv.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eGF != null) {
            this.eGF.setOtherParams(str);
        }
    }

    private void aix() {
        bi(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.eGt = gVar;
        this.eGt.bfx();
    }

    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (this.eGF != null && list != null && !list.isEmpty()) {
            bi(0, 8);
            this.eGF.bu(list);
            return;
        }
        aix();
    }

    public void bfs() {
        bbG();
    }

    public void bbG() {
        this.aDm.reset();
        this.aDm.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aDm.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eGt != null) {
                    k.this.eGt.bfx();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aDm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aDm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aDm.setVisibility(0);
        this.eGu.setVisibility(8);
        this.eGw.setVisibility(8);
    }

    private void bi(int i, int i2) {
        this.eGu.setVisibility(i);
        if (i2 == 0) {
            this.aDm.reset();
            if (this.YB) {
                this.aDm.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aDm.setTitle(a.i.guard_member_list_empty);
            }
            this.aDm.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aDm.setVisibility(0);
            return;
        }
        this.aDm.setVisibility(8);
    }

    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (this.eGF != null && this.eGe) {
            this.eGF.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfp() {
        if (this.eGF != null) {
            this.eGF.bfp();
        }
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }
}
