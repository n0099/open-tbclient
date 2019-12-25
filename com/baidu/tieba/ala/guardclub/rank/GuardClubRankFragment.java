package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes2.dex */
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0422b {
    private int eCA;
    private GuardClubRankListView eCt;
    private GuardClubRankHeaderView eCu;
    private GuardClubRankInfoView eCv;
    private int eCw;
    private int eCx;
    private b eCy;
    private b.a eCz;

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
        this.eCz = aVar;
        if (this.eCy != null) {
            this.eCy.a(this.eCz);
        }
    }

    public void pg(int i) {
        this.eCA = i;
        if (this.eCu != null) {
            this.eCu.setAvatarTopMargin(this.eCA);
        }
    }

    public void w(String str, long j) {
        if (this.eCy != null) {
            this.eCy.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bcW() {
        this.eCy = new b(getContext());
        this.eCy.a(this);
        this.eCy.a(this.eCz);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eCy.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eCy;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bcX() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eCt = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eCt.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bdd() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eCu != null) {
                    GuardClubRankFragment.this.ph(GuardClubRankFragment.this.eCu.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bde() {
                if (GuardClubRankFragment.this.eCy != null) {
                    GuardClubRankFragment.this.eCy.bdg();
                }
            }
        });
        this.eCu = new GuardClubRankHeaderView(getContext());
        this.eCu.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(p pVar) {
                if (GuardClubRankFragment.this.eCy != null) {
                    GuardClubRankFragment.this.eCy.f(pVar);
                }
            }
        });
        this.eCt.addHeaderView(this.eCu);
        this.eCw = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eCx = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eCy.getType()) {
            case 1:
                this.eCu.setStyle(1);
                break;
            case 2:
                this.eCu.setStyle(0);
                break;
        }
        if (this.eCu != null) {
            this.eCu.setAvatarTopMargin(this.eCA);
        }
        this.eCv = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eCv.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bdf() {
                if (GuardClubRankFragment.this.eCy != null) {
                    GuardClubRankFragment.this.eCy.bcZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eCy != null) {
                this.eCy.bdh();
            }
            if (this.eCu != null) {
                this.eCu.bdm();
                ph(this.eCu.getTop());
                return;
            }
            return;
        }
        if (this.eCt != null) {
            this.eCt.bdn();
        }
        if (this.eCu != null) {
            this.eCu.bcD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(int i) {
        if (this.eCy != null) {
            this.eCy.ph(ColorUtils.setAlphaComponent(this.eCx, (int) ((Math.abs(i) < this.eCw ? (1.0f * Math.abs(i)) / this.eCw : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eCu != null) {
            this.eCu.release();
        }
        if (this.eCt != null) {
            this.eCt.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0422b
    public void a(BaseAdapter baseAdapter) {
        if (this.eCt != null) {
            this.eCt.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0422b
    public void bx(List<p> list) {
        if (this.eCu != null) {
            this.eCu.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0422b
    public void z(boolean z, boolean z2) {
        if (this.eCt != null) {
            if (z2) {
                this.eCt.completePullRefresh();
            }
            this.eCt.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0422b
    public void bdc() {
        if (this.eCv != null) {
            this.eCv.setVisibility(8);
        }
        if (this.eCt != null && this.eCt.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eCt.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eCy.bdg();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eCt.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0422b
    public void f(String str, String str2, String str3, String str4, boolean z) {
        this.eCv.setData(str, str2, str3, str4, z);
        this.eCv.setVisibility(0);
    }
}
