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
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.rank.d;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends a implements d.b {
    private GuardClubRankListView fAb;
    private GuardClubRankHeaderView fAc;
    private GuardClubRankInfoView fAd;
    private int fAe;
    private int fAf;
    private d fAg;
    private d.a fAh;
    private int fAi;
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
        this.fAh = aVar;
        if (this.fAg != null) {
            this.fAg.a(this.fAh);
        }
    }

    public void qq(int i) {
        this.fAi = i;
        if (this.fAc != null) {
            this.fAc.setAvatarTopMargin(this.fAi);
        }
    }

    public void w(String str, long j) {
        if (this.fAg != null) {
            this.fAg.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e buO() {
        this.fAg = new d(getContext());
        this.fAg.a(this);
        this.fAg.a(this.fAh);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fAg.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fAg;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int buP() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.fAb = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fAb.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void buU() {
                if (c.this.mVisible && c.this.fAc != null) {
                    c.this.qr(c.this.fAc.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void buV() {
                if (c.this.fAg != null) {
                    c.this.fAg.buX();
                }
            }
        });
        this.fAc = new GuardClubRankHeaderView(getContext());
        this.fAc.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.fAg != null) {
                    c.this.fAg.f(kVar);
                }
            }
        });
        this.fAb.addHeaderView(this.fAc);
        this.fAe = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fAf = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.fAg.getType()) {
            case 1:
                this.fAc.setStyle(1);
                break;
            case 2:
                this.fAc.setStyle(0);
                break;
        }
        if (this.fAc != null) {
            this.fAc.setAvatarTopMargin(this.fAi);
        }
        this.fAd = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fAd.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void buW() {
                if (c.this.fAg != null) {
                    c.this.fAg.buR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fAg != null) {
                this.fAg.buY();
            }
            if (this.fAc != null) {
                this.fAc.bvf();
                qr(this.fAc.getTop());
                return;
            }
            return;
        }
        if (this.fAb != null) {
            this.fAb.bvg();
        }
        if (this.fAc != null) {
            this.fAc.buC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        if (this.fAg != null) {
            this.fAg.qr(ColorUtils.setAlphaComponent(this.fAf, (int) ((Math.abs(i) < this.fAe ? (1.0f * Math.abs(i)) / this.fAe : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fAc != null) {
            this.fAc.release();
        }
        if (this.fAb != null) {
            this.fAb.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.fAb != null) {
            this.fAb.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bD(List<k> list) {
        if (this.fAc != null) {
            this.fAc.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void E(boolean z, boolean z2) {
        if (this.fAb != null) {
            if (z2) {
                this.fAb.completePullRefresh();
            }
            this.fAb.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void buT() {
        if (this.fAd != null) {
            this.fAd.setVisibility(8);
        }
        if (this.fAb != null && this.fAb.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fAb.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.fAg.buX();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fAb.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fAd.setData(str, str2, str3, str4, z);
        this.fAd.setVisibility(0);
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
