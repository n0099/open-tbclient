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
    private GuardClubRankListView eHp;
    private GuardClubRankHeaderView eHq;
    private GuardClubRankInfoView eHr;
    private int eHs;
    private int eHt;
    private b eHu;
    private b.a eHv;
    private int eHw;

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
        this.eHv = aVar;
        if (this.eHu != null) {
            this.eHu.a(this.eHv);
        }
    }

    public void pt(int i) {
        this.eHw = i;
        if (this.eHq != null) {
            this.eHq.setAvatarTopMargin(this.eHw);
        }
    }

    public void w(String str, long j) {
        if (this.eHu != null) {
            this.eHu.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bfB() {
        this.eHu = new b(getContext());
        this.eHu.a(this);
        this.eHu.a(this.eHv);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eHu.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eHu;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bfC() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eHp = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eHp.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfI() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eHq != null) {
                    GuardClubRankFragment.this.pu(GuardClubRankFragment.this.eHq.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfJ() {
                if (GuardClubRankFragment.this.eHu != null) {
                    GuardClubRankFragment.this.eHu.bfL();
                }
            }
        });
        this.eHq = new GuardClubRankHeaderView(getContext());
        this.eHq.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.eHu != null) {
                    GuardClubRankFragment.this.eHu.f(kVar);
                }
            }
        });
        this.eHp.addHeaderView(this.eHq);
        this.eHs = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eHt = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eHu.getType()) {
            case 1:
                this.eHq.setStyle(1);
                break;
            case 2:
                this.eHq.setStyle(0);
                break;
        }
        if (this.eHq != null) {
            this.eHq.setAvatarTopMargin(this.eHw);
        }
        this.eHr = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eHr.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bfK() {
                if (GuardClubRankFragment.this.eHu != null) {
                    GuardClubRankFragment.this.eHu.bfE();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eHu != null) {
                this.eHu.bfM();
            }
            if (this.eHq != null) {
                this.eHq.bfT();
                pu(this.eHq.getTop());
                return;
            }
            return;
        }
        if (this.eHp != null) {
            this.eHp.bfU();
        }
        if (this.eHq != null) {
            this.eHq.bfp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (this.eHu != null) {
            this.eHu.pu(ColorUtils.setAlphaComponent(this.eHt, (int) ((Math.abs(i) < this.eHs ? (1.0f * Math.abs(i)) / this.eHs : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eHq != null) {
            this.eHq.release();
        }
        if (this.eHp != null) {
            this.eHp.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void a(BaseAdapter baseAdapter) {
        if (this.eHp != null) {
            this.eHp.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bx(List<k> list) {
        if (this.eHq != null) {
            this.eHq.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void B(boolean z, boolean z2) {
        if (this.eHp != null) {
            if (z2) {
                this.eHp.completePullRefresh();
            }
            this.eHp.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bfH() {
        if (this.eHr != null) {
            this.eHr.setVisibility(8);
        }
        if (this.eHp != null && this.eHp.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eHp.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eHu.bfL();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eHp.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.eHr.setData(str, str2, str3, str4, z);
        this.eHr.setVisibility(0);
    }
}
