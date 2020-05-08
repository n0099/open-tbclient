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
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0492b {
    private b.a fmA;
    private int fmB;
    private GuardClubRankListView fmu;
    private GuardClubRankHeaderView fmv;
    private GuardClubRankInfoView fmw;
    private int fmx;
    private int fmy;
    private b fmz;

    public static GuardClubRankFragment i(int i, String str, boolean z) {
        GuardClubRankFragment guardClubRankFragment = new GuardClubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("anchor_id", str);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        guardClubRankFragment.setArguments(bundle);
        return guardClubRankFragment;
    }

    public void a(b.a aVar) {
        this.fmA = aVar;
        if (this.fmz != null) {
            this.fmz.a(this.fmA);
        }
    }

    public void pP(int i) {
        this.fmB = i;
        if (this.fmv != null) {
            this.fmv.setAvatarTopMargin(this.fmB);
        }
    }

    public void x(String str, long j) {
        if (this.fmz != null) {
            this.fmz.x(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c boW() {
        this.fmz = new b(getContext());
        this.fmz.a(this);
        this.fmz.a(this.fmA);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fmz.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fmz;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int boX() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.fmu = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fmu.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bpd() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.fmv != null) {
                    GuardClubRankFragment.this.pQ(GuardClubRankFragment.this.fmv.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bpe() {
                if (GuardClubRankFragment.this.fmz != null) {
                    GuardClubRankFragment.this.fmz.bpg();
                }
            }
        });
        this.fmv = new GuardClubRankHeaderView(getContext());
        this.fmv.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.fmz != null) {
                    GuardClubRankFragment.this.fmz.f(kVar);
                }
            }
        });
        this.fmu.addHeaderView(this.fmv);
        this.fmx = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fmy = getResources().getColor(a.d.live_gcb_primary);
        switch (this.fmz.getType()) {
            case 1:
                this.fmv.setStyle(1);
                break;
            case 2:
                this.fmv.setStyle(0);
                break;
        }
        if (this.fmv != null) {
            this.fmv.setAvatarTopMargin(this.fmB);
        }
        this.fmw = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fmw.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bpf() {
                if (GuardClubRankFragment.this.fmz != null) {
                    GuardClubRankFragment.this.fmz.boZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fmz != null) {
                this.fmz.bph();
            }
            if (this.fmv != null) {
                this.fmv.bpo();
                pQ(this.fmv.getTop());
                return;
            }
            return;
        }
        if (this.fmu != null) {
            this.fmu.bpp();
        }
        if (this.fmv != null) {
            this.fmv.boK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(int i) {
        if (this.fmz != null) {
            this.fmz.pQ(ColorUtils.setAlphaComponent(this.fmy, (int) ((Math.abs(i) < this.fmx ? (1.0f * Math.abs(i)) / this.fmx : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fmv != null) {
            this.fmv.release();
        }
        if (this.fmu != null) {
            this.fmu.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0492b
    public void a(BaseAdapter baseAdapter) {
        if (this.fmu != null) {
            this.fmu.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0492b
    public void bG(List<k> list) {
        if (this.fmv != null) {
            this.fmv.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0492b
    public void B(boolean z, boolean z2) {
        if (this.fmu != null) {
            if (z2) {
                this.fmu.completePullRefresh();
            }
            this.fmu.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0492b
    public void bpc() {
        if (this.fmw != null) {
            this.fmw.setVisibility(8);
        }
        if (this.fmu != null && this.fmu.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fmu.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.fmz.bpg();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fmu.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0492b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fmw.setData(str, str2, str3, str4, z);
        this.fmw.setVisibility(0);
    }
}
