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
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0471b {
    private GuardClubRankListView fmp;
    private GuardClubRankHeaderView fmq;
    private GuardClubRankInfoView fmr;
    private int fms;
    private int fmt;
    private b fmu;
    private b.a fmv;
    private int fmw;

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
        this.fmv = aVar;
        if (this.fmu != null) {
            this.fmu.a(this.fmv);
        }
    }

    public void pP(int i) {
        this.fmw = i;
        if (this.fmq != null) {
            this.fmq.setAvatarTopMargin(this.fmw);
        }
    }

    public void x(String str, long j) {
        if (this.fmu != null) {
            this.fmu.x(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c boY() {
        this.fmu = new b(getContext());
        this.fmu.a(this);
        this.fmu.a(this.fmv);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fmu.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fmu;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int boZ() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.fmp = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fmp.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bpf() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.fmq != null) {
                    GuardClubRankFragment.this.pQ(GuardClubRankFragment.this.fmq.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bpg() {
                if (GuardClubRankFragment.this.fmu != null) {
                    GuardClubRankFragment.this.fmu.bpi();
                }
            }
        });
        this.fmq = new GuardClubRankHeaderView(getContext());
        this.fmq.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.fmu != null) {
                    GuardClubRankFragment.this.fmu.f(kVar);
                }
            }
        });
        this.fmp.addHeaderView(this.fmq);
        this.fms = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fmt = getResources().getColor(a.d.live_gcb_primary);
        switch (this.fmu.getType()) {
            case 1:
                this.fmq.setStyle(1);
                break;
            case 2:
                this.fmq.setStyle(0);
                break;
        }
        if (this.fmq != null) {
            this.fmq.setAvatarTopMargin(this.fmw);
        }
        this.fmr = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fmr.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bph() {
                if (GuardClubRankFragment.this.fmu != null) {
                    GuardClubRankFragment.this.fmu.bpb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fmu != null) {
                this.fmu.bpj();
            }
            if (this.fmq != null) {
                this.fmq.bpq();
                pQ(this.fmq.getTop());
                return;
            }
            return;
        }
        if (this.fmp != null) {
            this.fmp.bpr();
        }
        if (this.fmq != null) {
            this.fmq.boM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(int i) {
        if (this.fmu != null) {
            this.fmu.pQ(ColorUtils.setAlphaComponent(this.fmt, (int) ((Math.abs(i) < this.fms ? (1.0f * Math.abs(i)) / this.fms : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fmq != null) {
            this.fmq.release();
        }
        if (this.fmp != null) {
            this.fmp.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0471b
    public void a(BaseAdapter baseAdapter) {
        if (this.fmp != null) {
            this.fmp.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0471b
    public void bG(List<k> list) {
        if (this.fmq != null) {
            this.fmq.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0471b
    public void B(boolean z, boolean z2) {
        if (this.fmp != null) {
            if (z2) {
                this.fmp.completePullRefresh();
            }
            this.fmp.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0471b
    public void bpe() {
        if (this.fmr != null) {
            this.fmr.setVisibility(8);
        }
        if (this.fmp != null && this.fmp.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fmp.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.fmu.bpi();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fmp.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0471b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fmr.setData(str, str2, str3, str4, z);
        this.fmr.setVisibility(0);
    }
}
