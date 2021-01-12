package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
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
/* loaded from: classes10.dex */
public class c extends a implements d.b {
    private GuardClubRankListView gYh;
    private GuardClubRankHeaderView gYi;
    private GuardClubRankInfoView gYj;
    private int gYk;
    private int gYl;
    private d gYm;
    private d.a gYn;
    private int gYo;
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
        this.gYn = aVar;
        if (this.gYm != null) {
            this.gYm.a(this.gYn);
        }
    }

    public void uw(int i) {
        this.gYo = i;
        if (this.gYi != null) {
            this.gYi.setAvatarTopMargin(this.gYo);
        }
    }

    public void y(String str, long j) {
        if (this.gYm != null) {
            this.gYm.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bVm() {
        this.gYm = new d(getContext());
        this.gYm.a(this);
        this.gYm.a(this.gYn);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gYm.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gYm;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bVn() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gYh = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.gYh.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bVs() {
                if (c.this.mVisible && c.this.gYi != null) {
                    c.this.ux(c.this.gYi.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bVt() {
                if (c.this.gYm != null) {
                    c.this.gYm.bVv();
                }
            }
        });
        this.gYi = new GuardClubRankHeaderView(getContext());
        this.gYi.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gYm != null) {
                    c.this.gYm.f(kVar);
                }
            }
        });
        this.gYh.addHeaderView(this.gYi);
        this.gYk = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.gYl = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.gYm.getType()) {
            case 1:
                this.gYi.setStyle(1);
                break;
            case 2:
                this.gYi.setStyle(0);
                break;
        }
        if (this.gYi != null) {
            this.gYi.setAvatarTopMargin(this.gYo);
        }
        this.gYj = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.gYj.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bVu() {
                if (c.this.gYm != null) {
                    c.this.gYm.bVp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gYm != null) {
                this.gYm.bVw();
            }
            if (this.gYi != null) {
                this.gYi.bVD();
                ux(this.gYi.getTop());
                return;
            }
            return;
        }
        if (this.gYh != null) {
            this.gYh.bVE();
        }
        if (this.gYi != null) {
            this.gYi.VN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.gYm != null) {
            this.gYm.ux(ColorUtils.setAlphaComponent(this.gYl, (int) ((Math.abs(i) < this.gYk ? (1.0f * Math.abs(i)) / this.gYk : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gYi != null) {
            this.gYi.release();
        }
        if (this.gYh != null) {
            this.gYh.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gYh != null) {
            this.gYh.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cB(List<k> list) {
        if (this.gYi != null) {
            this.gYi.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void M(boolean z, boolean z2) {
        if (this.gYh != null) {
            if (z2) {
                this.gYh.completePullRefresh();
            }
            this.gYh.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bVr() {
        if (this.gYj != null) {
            this.gYj.setVisibility(8);
        }
        if (this.gYh != null && this.gYh.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gYh.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gYm.bVv();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gYh.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void h(String str, String str2, String str3, String str4, boolean z) {
        this.gYj.setData(str, str2, str3, str4, z);
        this.gYj.setVisibility(0);
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
