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
/* loaded from: classes3.dex */
public class c extends a implements d.b {
    private d fLA;
    private d.a fLB;
    private int fLC;
    private GuardClubRankListView fLv;
    private GuardClubRankHeaderView fLw;
    private GuardClubRankInfoView fLx;
    private int fLy;
    private int fLz;
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
        this.fLB = aVar;
        if (this.fLA != null) {
            this.fLA.a(this.fLB);
        }
    }

    public void qR(int i) {
        this.fLC = i;
        if (this.fLw != null) {
            this.fLw.setAvatarTopMargin(this.fLC);
        }
    }

    public void w(String str, long j) {
        if (this.fLA != null) {
            this.fLA.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bxM() {
        this.fLA = new d(getContext());
        this.fLA.a(this);
        this.fLA.a(this.fLB);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fLA.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fLA;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bxN() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.fLv = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fLv.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bxS() {
                if (c.this.mVisible && c.this.fLw != null) {
                    c.this.qS(c.this.fLw.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bxT() {
                if (c.this.fLA != null) {
                    c.this.fLA.bxV();
                }
            }
        });
        this.fLw = new GuardClubRankHeaderView(getContext());
        this.fLw.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.fLA != null) {
                    c.this.fLA.f(kVar);
                }
            }
        });
        this.fLv.addHeaderView(this.fLw);
        this.fLy = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fLz = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.fLA.getType()) {
            case 1:
                this.fLw.setStyle(1);
                break;
            case 2:
                this.fLw.setStyle(0);
                break;
        }
        if (this.fLw != null) {
            this.fLw.setAvatarTopMargin(this.fLC);
        }
        this.fLx = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fLx.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bxU() {
                if (c.this.fLA != null) {
                    c.this.fLA.bxP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fLA != null) {
                this.fLA.bxW();
            }
            if (this.fLw != null) {
                this.fLw.byd();
                qS(this.fLw.getTop());
                return;
            }
            return;
        }
        if (this.fLv != null) {
            this.fLv.bye();
        }
        if (this.fLw != null) {
            this.fLw.bxA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        if (this.fLA != null) {
            this.fLA.qS(ColorUtils.setAlphaComponent(this.fLz, (int) ((Math.abs(i) < this.fLy ? (1.0f * Math.abs(i)) / this.fLy : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fLw != null) {
            this.fLw.release();
        }
        if (this.fLv != null) {
            this.fLv.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.fLv != null) {
            this.fLv.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bM(List<k> list) {
        if (this.fLw != null) {
            this.fLw.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void E(boolean z, boolean z2) {
        if (this.fLv != null) {
            if (z2) {
                this.fLv.completePullRefresh();
            }
            this.fLv.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bxR() {
        if (this.fLx != null) {
            this.fLx.setVisibility(8);
        }
        if (this.fLv != null && this.fLv.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fLv.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.fLA.bxV();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fLv.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fLx.setData(str, str2, str3, str4, z);
        this.fLx.setVisibility(0);
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
