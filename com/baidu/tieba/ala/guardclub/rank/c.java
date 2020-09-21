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
    private GuardClubRankListView ggd;
    private GuardClubRankHeaderView gge;
    private GuardClubRankInfoView ggf;
    private int ggg;
    private int ggh;
    private d ggi;
    private d.a ggj;
    private int ggk;
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
        this.ggj = aVar;
        if (this.ggi != null) {
            this.ggi.a(this.ggj);
        }
    }

    public void tM(int i) {
        this.ggk = i;
        if (this.gge != null) {
            this.gge.setAvatarTopMargin(this.ggk);
        }
    }

    public void v(String str, long j) {
        if (this.ggi != null) {
            this.ggi.v(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bLG() {
        this.ggi = new d(getContext());
        this.ggi.a(this);
        this.ggi.a(this.ggj);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ggi.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.ggi;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bLH() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.ggd = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.ggd.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bLM() {
                if (c.this.mVisible && c.this.gge != null) {
                    c.this.tN(c.this.gge.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bLN() {
                if (c.this.ggi != null) {
                    c.this.ggi.bLP();
                }
            }
        });
        this.gge = new GuardClubRankHeaderView(getContext());
        this.gge.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.ggi != null) {
                    c.this.ggi.f(kVar);
                }
            }
        });
        this.ggd.addHeaderView(this.gge);
        this.ggg = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.ggh = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.ggi.getType()) {
            case 1:
                this.gge.setStyle(1);
                break;
            case 2:
                this.gge.setStyle(0);
                break;
        }
        if (this.gge != null) {
            this.gge.setAvatarTopMargin(this.ggk);
        }
        this.ggf = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.ggf.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bLO() {
                if (c.this.ggi != null) {
                    c.this.ggi.bLJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.ggi != null) {
                this.ggi.bLQ();
            }
            if (this.gge != null) {
                this.gge.bLX();
                tN(this.gge.getTop());
                return;
            }
            return;
        }
        if (this.ggd != null) {
            this.ggd.bLY();
        }
        if (this.gge != null) {
            this.gge.Rm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        if (this.ggi != null) {
            this.ggi.tN(ColorUtils.setAlphaComponent(this.ggh, (int) ((Math.abs(i) < this.ggg ? (1.0f * Math.abs(i)) / this.ggg : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gge != null) {
            this.gge.release();
        }
        if (this.ggd != null) {
            this.ggd.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.ggd != null) {
            this.ggd.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bW(List<k> list) {
        if (this.gge != null) {
            this.gge.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void I(boolean z, boolean z2) {
        if (this.ggd != null) {
            if (z2) {
                this.ggd.completePullRefresh();
            }
            this.ggd.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bLL() {
        if (this.ggf != null) {
            this.ggf.setVisibility(8);
        }
        if (this.ggd != null && this.ggd.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.ggd.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.ggi.bLP();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.ggd.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.ggf.setData(str, str2, str3, str4, z);
        this.ggf.setVisibility(0);
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
