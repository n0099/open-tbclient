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
/* loaded from: classes7.dex */
public class c extends a implements d.b {
    private GuardClubRankListView gcN;
    private GuardClubRankHeaderView gcO;
    private GuardClubRankInfoView gcP;
    private int gcQ;
    private int gcR;
    private d gcS;
    private d.a gcT;
    private int gcU;
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
        this.gcT = aVar;
        if (this.gcS != null) {
            this.gcS.a(this.gcT);
        }
    }

    public void tt(int i) {
        this.gcU = i;
        if (this.gcO != null) {
            this.gcO.setAvatarTopMargin(this.gcU);
        }
    }

    public void v(String str, long j) {
        if (this.gcS != null) {
            this.gcS.v(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bKv() {
        this.gcS = new d(getContext());
        this.gcS.a(this);
        this.gcS.a(this.gcT);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gcS.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gcS;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bKw() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gcN = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.gcN.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bKB() {
                if (c.this.mVisible && c.this.gcO != null) {
                    c.this.tu(c.this.gcO.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bKC() {
                if (c.this.gcS != null) {
                    c.this.gcS.bKE();
                }
            }
        });
        this.gcO = new GuardClubRankHeaderView(getContext());
        this.gcO.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gcS != null) {
                    c.this.gcS.f(kVar);
                }
            }
        });
        this.gcN.addHeaderView(this.gcO);
        this.gcQ = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.gcR = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.gcS.getType()) {
            case 1:
                this.gcO.setStyle(1);
                break;
            case 2:
                this.gcO.setStyle(0);
                break;
        }
        if (this.gcO != null) {
            this.gcO.setAvatarTopMargin(this.gcU);
        }
        this.gcP = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.gcP.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bKD() {
                if (c.this.gcS != null) {
                    c.this.gcS.bKy();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gcS != null) {
                this.gcS.bKF();
            }
            if (this.gcO != null) {
                this.gcO.bKM();
                tu(this.gcO.getTop());
                return;
            }
            return;
        }
        if (this.gcN != null) {
            this.gcN.bKN();
        }
        if (this.gcO != null) {
            this.gcO.QC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        if (this.gcS != null) {
            this.gcS.tu(ColorUtils.setAlphaComponent(this.gcR, (int) ((Math.abs(i) < this.gcQ ? (1.0f * Math.abs(i)) / this.gcQ : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gcO != null) {
            this.gcO.release();
        }
        if (this.gcN != null) {
            this.gcN.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gcN != null) {
            this.gcN.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bR(List<k> list) {
        if (this.gcO != null) {
            this.gcO.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void I(boolean z, boolean z2) {
        if (this.gcN != null) {
            if (z2) {
                this.gcN.completePullRefresh();
            }
            this.gcN.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bKA() {
        if (this.gcP != null) {
            this.gcP.setVisibility(8);
        }
        if (this.gcN != null && this.gcN.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gcN.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gcS.bKE();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gcN.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.gcP.setData(str, str2, str3, str4, z);
        this.gcP.setVisibility(0);
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
