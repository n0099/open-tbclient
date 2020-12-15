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
    private GuardClubRankListView gRa;
    private GuardClubRankHeaderView gRb;
    private GuardClubRankInfoView gRc;
    private int gRd;
    private int gRe;
    private d gRf;
    private d.a gRg;
    private int gRh;
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
        this.gRg = aVar;
        if (this.gRf != null) {
            this.gRf.a(this.gRg);
        }
    }

    public void vR(int i) {
        this.gRh = i;
        if (this.gRb != null) {
            this.gRb.setAvatarTopMargin(this.gRh);
        }
    }

    public void y(String str, long j) {
        if (this.gRf != null) {
            this.gRf.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bWy() {
        this.gRf = new d(getContext());
        this.gRf.a(this);
        this.gRf.a(this.gRg);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gRf.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gRf;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bWz() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gRa = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.gRa.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWE() {
                if (c.this.mVisible && c.this.gRb != null) {
                    c.this.vS(c.this.gRb.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWF() {
                if (c.this.gRf != null) {
                    c.this.gRf.bWH();
                }
            }
        });
        this.gRb = new GuardClubRankHeaderView(getContext());
        this.gRb.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gRf != null) {
                    c.this.gRf.f(kVar);
                }
            }
        });
        this.gRa.addHeaderView(this.gRb);
        this.gRd = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.gRe = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.gRf.getType()) {
            case 1:
                this.gRb.setStyle(1);
                break;
            case 2:
                this.gRb.setStyle(0);
                break;
        }
        if (this.gRb != null) {
            this.gRb.setAvatarTopMargin(this.gRh);
        }
        this.gRc = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.gRc.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bWG() {
                if (c.this.gRf != null) {
                    c.this.gRf.bWB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gRf != null) {
                this.gRf.bWI();
            }
            if (this.gRb != null) {
                this.gRb.bWP();
                vS(this.gRb.getTop());
                return;
            }
            return;
        }
        if (this.gRa != null) {
            this.gRa.bWQ();
        }
        if (this.gRb != null) {
            this.gRb.Yv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        if (this.gRf != null) {
            this.gRf.vS(ColorUtils.setAlphaComponent(this.gRe, (int) ((Math.abs(i) < this.gRd ? (1.0f * Math.abs(i)) / this.gRd : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gRb != null) {
            this.gRb.release();
        }
        if (this.gRa != null) {
            this.gRa.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gRa != null) {
            this.gRa.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cu(List<k> list) {
        if (this.gRb != null) {
            this.gRb.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void K(boolean z, boolean z2) {
        if (this.gRa != null) {
            if (z2) {
                this.gRa.completePullRefresh();
            }
            this.gRa.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bWD() {
        if (this.gRc != null) {
            this.gRc.setVisibility(8);
        }
        if (this.gRa != null && this.gRa.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gRa.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gRf.bWH();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gRa.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void g(String str, String str2, String str3, String str4, boolean z) {
        this.gRc.setData(str, str2, str3, str4, z);
        this.gRc.setVisibility(0);
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
