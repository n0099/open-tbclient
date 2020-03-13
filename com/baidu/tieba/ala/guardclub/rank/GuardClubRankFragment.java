package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes3.dex */
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0436b {
    private GuardClubRankListView eHC;
    private GuardClubRankHeaderView eHD;
    private GuardClubRankInfoView eHE;
    private int eHF;
    private int eHG;
    private b eHH;
    private b.a eHI;
    private int eHJ;

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
        this.eHI = aVar;
        if (this.eHH != null) {
            this.eHH.a(this.eHI);
        }
    }

    public void pt(int i) {
        this.eHJ = i;
        if (this.eHD != null) {
            this.eHD.setAvatarTopMargin(this.eHJ);
        }
    }

    public void w(String str, long j) {
        if (this.eHH != null) {
            this.eHH.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bfC() {
        this.eHH = new b(getContext());
        this.eHH.a(this);
        this.eHH.a(this.eHI);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eHH.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eHH;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bfD() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eHC = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eHC.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfJ() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eHD != null) {
                    GuardClubRankFragment.this.pu(GuardClubRankFragment.this.eHD.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfK() {
                if (GuardClubRankFragment.this.eHH != null) {
                    GuardClubRankFragment.this.eHH.bfM();
                }
            }
        });
        this.eHD = new GuardClubRankHeaderView(getContext());
        this.eHD.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.eHH != null) {
                    GuardClubRankFragment.this.eHH.f(kVar);
                }
            }
        });
        this.eHC.addHeaderView(this.eHD);
        this.eHF = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eHG = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eHH.getType()) {
            case 1:
                this.eHD.setStyle(1);
                break;
            case 2:
                this.eHD.setStyle(0);
                break;
        }
        if (this.eHD != null) {
            this.eHD.setAvatarTopMargin(this.eHJ);
        }
        this.eHE = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eHE.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bfL() {
                if (GuardClubRankFragment.this.eHH != null) {
                    GuardClubRankFragment.this.eHH.bfF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eHH != null) {
                this.eHH.bfN();
            }
            if (this.eHD != null) {
                this.eHD.bfU();
                pu(this.eHD.getTop());
                return;
            }
            return;
        }
        if (this.eHC != null) {
            this.eHC.bfV();
        }
        if (this.eHD != null) {
            this.eHD.bfq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (this.eHH != null) {
            this.eHH.pu(ColorUtils.setAlphaComponent(this.eHG, (int) ((Math.abs(i) < this.eHF ? (1.0f * Math.abs(i)) / this.eHF : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eHD != null) {
            this.eHD.release();
        }
        if (this.eHC != null) {
            this.eHC.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void a(BaseAdapter baseAdapter) {
        if (this.eHC != null) {
            this.eHC.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bx(List<k> list) {
        if (this.eHD != null) {
            this.eHD.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void C(boolean z, boolean z2) {
        if (this.eHC != null) {
            if (z2) {
                this.eHC.completePullRefresh();
            }
            this.eHC.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bfI() {
        if (this.eHE != null) {
            this.eHE.setVisibility(8);
        }
        if (this.eHC != null && this.eHC.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eHC.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eHH.bfM();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eHC.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.eHE.setData(str, str2, str3, str4, z);
        this.eHE.setVisibility(0);
    }
}
