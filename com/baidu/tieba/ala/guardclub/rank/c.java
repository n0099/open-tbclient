package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.d;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends a implements d.b {
    private int gCA;
    private d gCB;
    private d.a gCC;
    private int gCD;
    private GuardClubRankListView gCw;
    private GuardClubRankHeaderView gCx;
    private GuardClubRankInfoView gCy;
    private int gCz;
    private Bundle mBundle;
    private Context mContext;

    public c(Context context, int i, String str, boolean z) {
        this.mContext = context;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("anchor_id", str);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        setArguments(bundle);
    }

    public void a(d.a aVar) {
        this.gCC = aVar;
        if (this.gCB != null) {
            this.gCB.a(this.gCC);
        }
    }

    public void uC(int i) {
        this.gCD = i;
        if (this.gCx != null) {
            this.gCx.setAvatarTopMargin(this.gCD);
        }
    }

    public void y(String str, long j) {
        if (this.gCB != null) {
            this.gCB.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bQV() {
        this.gCB = new d(getContext());
        this.gCB.a(this);
        this.gCB.a(this.gCC);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gCB.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gCB;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bQW() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gCw = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.gCw.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bRb() {
                if (c.this.mVisible && c.this.gCx != null) {
                    c.this.uD(c.this.gCx.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bRc() {
                if (c.this.gCB != null) {
                    c.this.gCB.bRe();
                }
            }
        });
        this.gCx = new GuardClubRankHeaderView(getContext());
        this.gCx.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gCB != null) {
                    c.this.gCB.f(kVar);
                }
            }
        });
        this.gCw.addHeaderView(this.gCx);
        this.gCz = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.gCA = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.gCB.getType()) {
            case 1:
                this.gCx.setStyle(1);
                break;
            case 2:
                this.gCx.setStyle(0);
                break;
        }
        if (this.gCx != null) {
            this.gCx.setAvatarTopMargin(this.gCD);
        }
        this.gCy = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.gCy.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bRd() {
                if (c.this.gCB != null) {
                    c.this.gCB.bQY();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gCB != null) {
                this.gCB.bRf();
            }
            if (this.gCx != null) {
                this.gCx.bRm();
                uD(this.gCx.getTop());
                return;
            }
            return;
        }
        if (this.gCw != null) {
            this.gCw.bRn();
        }
        if (this.gCx != null) {
            this.gCx.Ue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(int i) {
        if (this.gCB != null) {
            this.gCB.uD(ColorUtils.setAlphaComponent(this.gCA, (int) ((Math.abs(i) < this.gCz ? (1.0f * Math.abs(i)) / this.gCz : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gCx != null) {
            this.gCx.release();
        }
        if (this.gCw != null) {
            this.gCw.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gCw != null) {
            this.gCw.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cj(List<k> list) {
        if (this.gCx != null) {
            this.gCx.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void K(boolean z, boolean z2) {
        if (this.gCw != null) {
            if (z2) {
                this.gCw.completePullRefresh();
            }
            this.gCw.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bRa() {
        if (this.gCy != null) {
            this.gCy.setVisibility(8);
        }
        if (this.gCw != null && this.gCw.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gCw.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gCB.bRe();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gCw.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void g(String str, String str2, String str3, String str4, boolean z) {
        this.gCy.setData(str, str2, str3, str4, z);
        this.gCy.setVisibility(0);
    }

    public Context getContext() {
        return this.mContext;
    }

    public Bundle getArguments() {
        return this.mBundle;
    }

    private void setArguments(Bundle bundle) {
        this.mBundle = bundle;
    }
}
