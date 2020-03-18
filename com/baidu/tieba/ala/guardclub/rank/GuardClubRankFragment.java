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
    private GuardClubRankListView eHY;
    private GuardClubRankHeaderView eHZ;
    private GuardClubRankInfoView eIa;
    private int eIb;
    private int eIc;
    private b eId;
    private b.a eIe;
    private int eIf;

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
        this.eIe = aVar;
        if (this.eId != null) {
            this.eId.a(this.eIe);
        }
    }

    public void pv(int i) {
        this.eIf = i;
        if (this.eHZ != null) {
            this.eHZ.setAvatarTopMargin(this.eIf);
        }
    }

    public void w(String str, long j) {
        if (this.eId != null) {
            this.eId.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bfH() {
        this.eId = new b(getContext());
        this.eId.a(this);
        this.eId.a(this.eIe);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eId.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eId;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bfI() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eHY = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eHY.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfO() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eHZ != null) {
                    GuardClubRankFragment.this.pw(GuardClubRankFragment.this.eHZ.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfP() {
                if (GuardClubRankFragment.this.eId != null) {
                    GuardClubRankFragment.this.eId.bfR();
                }
            }
        });
        this.eHZ = new GuardClubRankHeaderView(getContext());
        this.eHZ.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.eId != null) {
                    GuardClubRankFragment.this.eId.f(kVar);
                }
            }
        });
        this.eHY.addHeaderView(this.eHZ);
        this.eIb = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eIc = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eId.getType()) {
            case 1:
                this.eHZ.setStyle(1);
                break;
            case 2:
                this.eHZ.setStyle(0);
                break;
        }
        if (this.eHZ != null) {
            this.eHZ.setAvatarTopMargin(this.eIf);
        }
        this.eIa = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eIa.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bfQ() {
                if (GuardClubRankFragment.this.eId != null) {
                    GuardClubRankFragment.this.eId.bfK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eId != null) {
                this.eId.bfS();
            }
            if (this.eHZ != null) {
                this.eHZ.bfZ();
                pw(this.eHZ.getTop());
                return;
            }
            return;
        }
        if (this.eHY != null) {
            this.eHY.bga();
        }
        if (this.eHZ != null) {
            this.eHZ.bfv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw(int i) {
        if (this.eId != null) {
            this.eId.pw(ColorUtils.setAlphaComponent(this.eIc, (int) ((Math.abs(i) < this.eIb ? (1.0f * Math.abs(i)) / this.eIb : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eHZ != null) {
            this.eHZ.release();
        }
        if (this.eHY != null) {
            this.eHY.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void a(BaseAdapter baseAdapter) {
        if (this.eHY != null) {
            this.eHY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bx(List<k> list) {
        if (this.eHZ != null) {
            this.eHZ.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void C(boolean z, boolean z2) {
        if (this.eHY != null) {
            if (z2) {
                this.eHY.completePullRefresh();
            }
            this.eHY.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bfN() {
        if (this.eIa != null) {
            this.eIa.setVisibility(8);
        }
        if (this.eHY != null && this.eHY.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eHY.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eId.bfR();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eHY.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.eIa.setData(str, str2, str3, str4, z);
        this.eIa.setVisibility(0);
    }
}
