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
    private GuardClubRankListView gQY;
    private GuardClubRankHeaderView gQZ;
    private GuardClubRankInfoView gRa;
    private int gRb;
    private int gRc;
    private d gRd;
    private d.a gRe;
    private int gRf;
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
        this.gRe = aVar;
        if (this.gRd != null) {
            this.gRd.a(this.gRe);
        }
    }

    public void vR(int i) {
        this.gRf = i;
        if (this.gQZ != null) {
            this.gQZ.setAvatarTopMargin(this.gRf);
        }
    }

    public void y(String str, long j) {
        if (this.gRd != null) {
            this.gRd.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bWx() {
        this.gRd = new d(getContext());
        this.gRd.a(this);
        this.gRd.a(this.gRe);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gRd.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gRd;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bWy() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gQY = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.gQY.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWD() {
                if (c.this.mVisible && c.this.gQZ != null) {
                    c.this.vS(c.this.gQZ.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWE() {
                if (c.this.gRd != null) {
                    c.this.gRd.bWG();
                }
            }
        });
        this.gQZ = new GuardClubRankHeaderView(getContext());
        this.gQZ.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gRd != null) {
                    c.this.gRd.f(kVar);
                }
            }
        });
        this.gQY.addHeaderView(this.gQZ);
        this.gRb = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.gRc = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.gRd.getType()) {
            case 1:
                this.gQZ.setStyle(1);
                break;
            case 2:
                this.gQZ.setStyle(0);
                break;
        }
        if (this.gQZ != null) {
            this.gQZ.setAvatarTopMargin(this.gRf);
        }
        this.gRa = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.gRa.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bWF() {
                if (c.this.gRd != null) {
                    c.this.gRd.bWA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gRd != null) {
                this.gRd.bWH();
            }
            if (this.gQZ != null) {
                this.gQZ.bWO();
                vS(this.gQZ.getTop());
                return;
            }
            return;
        }
        if (this.gQY != null) {
            this.gQY.bWP();
        }
        if (this.gQZ != null) {
            this.gQZ.Yv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        if (this.gRd != null) {
            this.gRd.vS(ColorUtils.setAlphaComponent(this.gRc, (int) ((Math.abs(i) < this.gRb ? (1.0f * Math.abs(i)) / this.gRb : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gQZ != null) {
            this.gQZ.release();
        }
        if (this.gQY != null) {
            this.gQY.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gQY != null) {
            this.gQY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cu(List<k> list) {
        if (this.gQZ != null) {
            this.gQZ.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void K(boolean z, boolean z2) {
        if (this.gQY != null) {
            if (z2) {
                this.gQY.completePullRefresh();
            }
            this.gQY.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bWC() {
        if (this.gRa != null) {
            this.gRa.setVisibility(8);
        }
        if (this.gQY != null && this.gQY.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gQY.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gRd.bWG();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gQY.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void g(String str, String str2, String str3, String str4, boolean z) {
        this.gRa.setData(str, str2, str3, str4, z);
        this.gRa.setVisibility(0);
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
