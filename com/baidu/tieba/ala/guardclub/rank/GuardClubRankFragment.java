package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes2.dex */
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0425b {
    private GuardClubRankListView eDE;
    private GuardClubRankHeaderView eDF;
    private GuardClubRankInfoView eDG;
    private int eDH;
    private int eDI;
    private b eDJ;
    private b.a eDK;
    private int eDL;

    public static GuardClubRankFragment h(int i, String str, boolean z) {
        GuardClubRankFragment guardClubRankFragment = new GuardClubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("anchor_id", str);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        guardClubRankFragment.setArguments(bundle);
        return guardClubRankFragment;
    }

    public void a(b.a aVar) {
        this.eDK = aVar;
        if (this.eDJ != null) {
            this.eDJ.a(this.eDK);
        }
    }

    public void ph(int i) {
        this.eDL = i;
        if (this.eDF != null) {
            this.eDF.setAvatarTopMargin(this.eDL);
        }
    }

    public void w(String str, long j) {
        if (this.eDJ != null) {
            this.eDJ.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bdr() {
        this.eDJ = new b(getContext());
        this.eDJ.a(this);
        this.eDJ.a(this.eDK);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eDJ.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eDJ;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bds() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eDE = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eDE.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bdy() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eDF != null) {
                    GuardClubRankFragment.this.pi(GuardClubRankFragment.this.eDF.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bdz() {
                if (GuardClubRankFragment.this.eDJ != null) {
                    GuardClubRankFragment.this.eDJ.bdB();
                }
            }
        });
        this.eDF = new GuardClubRankHeaderView(getContext());
        this.eDF.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(p pVar) {
                if (GuardClubRankFragment.this.eDJ != null) {
                    GuardClubRankFragment.this.eDJ.f(pVar);
                }
            }
        });
        this.eDE.addHeaderView(this.eDF);
        this.eDH = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eDI = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eDJ.getType()) {
            case 1:
                this.eDF.setStyle(1);
                break;
            case 2:
                this.eDF.setStyle(0);
                break;
        }
        if (this.eDF != null) {
            this.eDF.setAvatarTopMargin(this.eDL);
        }
        this.eDG = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eDG.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bdA() {
                if (GuardClubRankFragment.this.eDJ != null) {
                    GuardClubRankFragment.this.eDJ.bdu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eDJ != null) {
                this.eDJ.bdC();
            }
            if (this.eDF != null) {
                this.eDF.bdH();
                pi(this.eDF.getTop());
                return;
            }
            return;
        }
        if (this.eDE != null) {
            this.eDE.bdI();
        }
        if (this.eDF != null) {
            this.eDF.bcY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        if (this.eDJ != null) {
            this.eDJ.pi(ColorUtils.setAlphaComponent(this.eDI, (int) ((Math.abs(i) < this.eDH ? (1.0f * Math.abs(i)) / this.eDH : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eDF != null) {
            this.eDF.release();
        }
        if (this.eDE != null) {
            this.eDE.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0425b
    public void a(BaseAdapter baseAdapter) {
        if (this.eDE != null) {
            this.eDE.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0425b
    public void bx(List<p> list) {
        if (this.eDF != null) {
            this.eDF.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0425b
    public void y(boolean z, boolean z2) {
        if (this.eDE != null) {
            if (z2) {
                this.eDE.completePullRefresh();
            }
            this.eDE.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0425b
    public void bdx() {
        if (this.eDG != null) {
            this.eDG.setVisibility(8);
        }
        if (this.eDE != null && this.eDE.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eDE.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eDJ.bdB();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eDE.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0425b
    public void f(String str, String str2, String str3, String str4, boolean z) {
        this.eDG.setData(str, str2, str3, str4, z);
        this.eDG.setVisibility(0);
    }
}
