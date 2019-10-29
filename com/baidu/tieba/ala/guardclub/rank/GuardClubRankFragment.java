package com.baidu.tieba.ala.guardclub.rank;

import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.model.p;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes6.dex */
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0348b {
    private GuardClubRankListView dPe;
    private GuardClubRankHeaderView dPf;
    private GuardClubRankInfoView dPg;
    private int dPh;
    private int dPi;
    private b dPj;
    private b.a dPk;
    private int dPl;

    public static GuardClubRankFragment f(int i, String str, boolean z) {
        GuardClubRankFragment guardClubRankFragment = new GuardClubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("anchor_id", str);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        guardClubRankFragment.setArguments(bundle);
        return guardClubRankFragment;
    }

    public void a(b.a aVar) {
        this.dPk = aVar;
        if (this.dPj != null) {
            this.dPj.a(this.dPk);
        }
    }

    public void mR(int i) {
        this.dPl = i;
        if (this.dPf != null) {
            this.dPf.setAvatarTopMargin(this.dPl);
        }
    }

    public void u(String str, long j) {
        if (this.dPj != null) {
            this.dPj.u(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c aLP() {
        this.dPj = new b(getContext());
        this.dPj.a(this);
        this.dPj.a(this.dPk);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dPj.g(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.dPj;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int aLQ() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.dPe = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.dPe.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void aLW() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.dPf != null) {
                    GuardClubRankFragment.this.mS(GuardClubRankFragment.this.dPf.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void aLX() {
                if (GuardClubRankFragment.this.dPj != null) {
                    GuardClubRankFragment.this.dPj.aLZ();
                }
            }
        });
        this.dPf = new GuardClubRankHeaderView(getContext());
        this.dPf.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(p pVar) {
                if (GuardClubRankFragment.this.dPj != null) {
                    GuardClubRankFragment.this.dPj.f(pVar);
                }
            }
        });
        this.dPe.addHeaderView(this.dPf);
        this.dPh = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.dPi = getResources().getColor(a.d.live_gcb_primary);
        switch (this.dPj.getType()) {
            case 1:
                this.dPf.setStyle(1);
                break;
            case 2:
                this.dPf.setStyle(0);
                break;
        }
        if (this.dPf != null) {
            this.dPf.setAvatarTopMargin(this.dPl);
        }
        this.dPg = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.dPg.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void aLY() {
                if (GuardClubRankFragment.this.dPj != null) {
                    GuardClubRankFragment.this.dPj.aLS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.dPj != null) {
                this.dPj.aMa();
            }
            if (this.dPf != null) {
                this.dPf.aMf();
                mS(this.dPf.getTop());
                return;
            }
            return;
        }
        if (this.dPe != null) {
            this.dPe.aMg();
        }
        if (this.dPf != null) {
            this.dPf.aLw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(int i) {
        if (this.dPj != null) {
            this.dPj.mS(ColorUtils.setAlphaComponent(this.dPi, (int) ((Math.abs(i) < this.dPh ? (1.0f * Math.abs(i)) / this.dPh : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.dPf != null) {
            this.dPf.release();
        }
        if (this.dPe != null) {
            this.dPe.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0348b
    public void a(BaseAdapter baseAdapter) {
        if (this.dPe != null) {
            this.dPe.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0348b
    public void by(List<p> list) {
        if (this.dPf != null) {
            this.dPf.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0348b
    public void z(boolean z, boolean z2) {
        if (this.dPe != null) {
            if (z2) {
                this.dPe.completePullRefresh();
            }
            this.dPe.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0348b
    public void aLV() {
        if (this.dPg != null) {
            this.dPg.setVisibility(8);
        }
        if (this.dPe != null && this.dPe.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.dPe.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.dPj.aLZ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.dPe.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0348b
    public void f(String str, String str2, String str3, String str4, boolean z) {
        this.dPg.setData(str, str2, str3, str4, z);
        this.dPg.setVisibility(0);
    }
}
