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
    private GuardClubRankListView fAm;
    private GuardClubRankHeaderView fAn;
    private GuardClubRankInfoView fAo;
    private int fAp;
    private int fAq;
    private d fAr;
    private d.a fAs;
    private int fAt;
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
        this.fAs = aVar;
        if (this.fAr != null) {
            this.fAr.a(this.fAs);
        }
    }

    public void qs(int i) {
        this.fAt = i;
        if (this.fAn != null) {
            this.fAn.setAvatarTopMargin(this.fAt);
        }
    }

    public void w(String str, long j) {
        if (this.fAr != null) {
            this.fAr.w(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e buQ() {
        this.fAr = new d(getContext());
        this.fAr.a(this);
        this.fAr.a(this.fAs);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fAr.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fAr;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int buR() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.fAm = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fAm.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void buW() {
                if (c.this.mVisible && c.this.fAn != null) {
                    c.this.qt(c.this.fAn.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void buX() {
                if (c.this.fAr != null) {
                    c.this.fAr.buZ();
                }
            }
        });
        this.fAn = new GuardClubRankHeaderView(getContext());
        this.fAn.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.fAr != null) {
                    c.this.fAr.f(kVar);
                }
            }
        });
        this.fAm.addHeaderView(this.fAn);
        this.fAp = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fAq = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.fAr.getType()) {
            case 1:
                this.fAn.setStyle(1);
                break;
            case 2:
                this.fAn.setStyle(0);
                break;
        }
        if (this.fAn != null) {
            this.fAn.setAvatarTopMargin(this.fAt);
        }
        this.fAo = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fAo.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void buY() {
                if (c.this.fAr != null) {
                    c.this.fAr.buT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fAr != null) {
                this.fAr.bva();
            }
            if (this.fAn != null) {
                this.fAn.bvh();
                qt(this.fAn.getTop());
                return;
            }
            return;
        }
        if (this.fAm != null) {
            this.fAm.bvi();
        }
        if (this.fAn != null) {
            this.fAn.buE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt(int i) {
        if (this.fAr != null) {
            this.fAr.qt(ColorUtils.setAlphaComponent(this.fAq, (int) ((Math.abs(i) < this.fAp ? (1.0f * Math.abs(i)) / this.fAp : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fAn != null) {
            this.fAn.release();
        }
        if (this.fAm != null) {
            this.fAm.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.fAm != null) {
            this.fAm.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bD(List<k> list) {
        if (this.fAn != null) {
            this.fAn.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void E(boolean z, boolean z2) {
        if (this.fAm != null) {
            if (z2) {
                this.fAm.completePullRefresh();
            }
            this.fAm.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void buV() {
        if (this.fAo != null) {
            this.fAo.setVisibility(8);
        }
        if (this.fAm != null && this.fAm.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fAm.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.fAr.buZ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fAm.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fAo.setData(str, str2, str3, str4, z);
        this.fAo.setVisibility(0);
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
