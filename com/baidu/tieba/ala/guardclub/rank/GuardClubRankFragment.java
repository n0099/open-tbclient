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
    private GuardClubRankListView eHo;
    private GuardClubRankHeaderView eHp;
    private GuardClubRankInfoView eHq;
    private int eHr;
    private int eHs;
    private b eHt;
    private b.a eHu;
    private int eHv;

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
        this.eHu = aVar;
        if (this.eHt != null) {
            this.eHt.a(this.eHu);
        }
    }

    public void pt(int i) {
        this.eHv = i;
        if (this.eHp != null) {
            this.eHp.setAvatarTopMargin(this.eHv);
        }
    }

    public void w(String str, long j) {
        if (this.eHt != null) {
            this.eHt.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c bfz() {
        this.eHt = new b(getContext());
        this.eHt.a(this);
        this.eHt.a(this.eHu);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eHt.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.eHt;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int bfA() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.eHo = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.eHo.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfG() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.eHp != null) {
                    GuardClubRankFragment.this.pu(GuardClubRankFragment.this.eHp.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bfH() {
                if (GuardClubRankFragment.this.eHt != null) {
                    GuardClubRankFragment.this.eHt.bfJ();
                }
            }
        });
        this.eHp = new GuardClubRankHeaderView(getContext());
        this.eHp.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (GuardClubRankFragment.this.eHt != null) {
                    GuardClubRankFragment.this.eHt.f(kVar);
                }
            }
        });
        this.eHo.addHeaderView(this.eHp);
        this.eHr = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.eHs = getResources().getColor(a.d.live_gcb_primary);
        switch (this.eHt.getType()) {
            case 1:
                this.eHp.setStyle(1);
                break;
            case 2:
                this.eHp.setStyle(0);
                break;
        }
        if (this.eHp != null) {
            this.eHp.setAvatarTopMargin(this.eHv);
        }
        this.eHq = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.eHq.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bfI() {
                if (GuardClubRankFragment.this.eHt != null) {
                    GuardClubRankFragment.this.eHt.bfC();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.eHt != null) {
                this.eHt.bfK();
            }
            if (this.eHp != null) {
                this.eHp.bfR();
                pu(this.eHp.getTop());
                return;
            }
            return;
        }
        if (this.eHo != null) {
            this.eHo.bfS();
        }
        if (this.eHp != null) {
            this.eHp.bfn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (this.eHt != null) {
            this.eHt.pu(ColorUtils.setAlphaComponent(this.eHs, (int) ((Math.abs(i) < this.eHr ? (1.0f * Math.abs(i)) / this.eHr : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.eHp != null) {
            this.eHp.release();
        }
        if (this.eHo != null) {
            this.eHo.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void a(BaseAdapter baseAdapter) {
        if (this.eHo != null) {
            this.eHo.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bx(List<k> list) {
        if (this.eHp != null) {
            this.eHp.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void B(boolean z, boolean z2) {
        if (this.eHo != null) {
            if (z2) {
                this.eHo.completePullRefresh();
            }
            this.eHo.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void bfF() {
        if (this.eHq != null) {
            this.eHq.setVisibility(8);
        }
        if (this.eHo != null && this.eHo.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.eHo.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.eHt.bfJ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.eHo.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0436b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.eHq.setData(str, str2, str3, str4, z);
        this.eHq.setVisibility(0);
    }
}
