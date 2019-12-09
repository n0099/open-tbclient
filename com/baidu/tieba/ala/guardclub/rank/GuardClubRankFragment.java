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
public class GuardClubRankFragment extends GuardClubRankBaseFragment implements b.InterfaceC0343b {
    private GuardClubRankListView dOn;
    private GuardClubRankHeaderView dOo;
    private GuardClubRankInfoView dOp;
    private int dOq;
    private int dOr;
    private b dOs;
    private b.a dOt;
    private int dOu;

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
        this.dOt = aVar;
        if (this.dOs != null) {
            this.dOs.a(this.dOt);
        }
    }

    public void mQ(int i) {
        this.dOu = i;
        if (this.dOo != null) {
            this.dOo.setAvatarTopMargin(this.dOu);
        }
    }

    public void u(String str, long j) {
        if (this.dOs != null) {
            this.dOs.u(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected c aLN() {
        this.dOs = new b(getContext());
        this.dOs.a(this);
        this.dOs.a(this.dOt);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dOs.g(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.dOs;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected int aLO() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    protected void onInflate(View view, Bundle bundle) {
        this.dOn = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.dOn.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void aLU() {
                if (GuardClubRankFragment.this.getUserVisibleHint() && GuardClubRankFragment.this.dOo != null) {
                    GuardClubRankFragment.this.mR(GuardClubRankFragment.this.dOo.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void aLV() {
                if (GuardClubRankFragment.this.dOs != null) {
                    GuardClubRankFragment.this.dOs.aLX();
                }
            }
        });
        this.dOo = new GuardClubRankHeaderView(getContext());
        this.dOo.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(p pVar) {
                if (GuardClubRankFragment.this.dOs != null) {
                    GuardClubRankFragment.this.dOs.f(pVar);
                }
            }
        });
        this.dOn.addHeaderView(this.dOo);
        this.dOq = getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.dOr = getResources().getColor(a.d.live_gcb_primary);
        switch (this.dOs.getType()) {
            case 1:
                this.dOo.setStyle(1);
                break;
            case 2:
                this.dOo.setStyle(0);
                break;
        }
        if (this.dOo != null) {
            this.dOo.setAvatarTopMargin(this.dOu);
        }
        this.dOp = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.dOp.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void aLW() {
                if (GuardClubRankFragment.this.dOs != null) {
                    GuardClubRankFragment.this.dOs.aLQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.dOs != null) {
                this.dOs.aLY();
            }
            if (this.dOo != null) {
                this.dOo.aMd();
                mR(this.dOo.getTop());
                return;
            }
            return;
        }
        if (this.dOn != null) {
            this.dOn.aMe();
        }
        if (this.dOo != null) {
            this.dOo.aLu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        if (this.dOs != null) {
            this.dOs.mR(ColorUtils.setAlphaComponent(this.dOr, (int) ((Math.abs(i) < this.dOq ? (1.0f * Math.abs(i)) / this.dOq : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.GuardClubRankBaseFragment, com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.dOo != null) {
            this.dOo.release();
        }
        if (this.dOn != null) {
            this.dOn.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0343b
    public void a(BaseAdapter baseAdapter) {
        if (this.dOn != null) {
            this.dOn.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0343b
    public void by(List<p> list) {
        if (this.dOo != null) {
            this.dOo.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0343b
    public void z(boolean z, boolean z2) {
        if (this.dOn != null) {
            if (z2) {
                this.dOn.completePullRefresh();
            }
            this.dOn.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0343b
    public void aLT() {
        if (this.dOp != null) {
            this.dOp.setVisibility(8);
        }
        if (this.dOn != null && this.dOn.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.dOn.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubRankFragment.this.dOs.aLX();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.dOn.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.InterfaceC0343b
    public void f(String str, String str2, String str3, String str4, boolean z) {
        this.dOp.setData(str, str2, str3, str4, z);
        this.dOp.setVisibility(0);
    }
}
