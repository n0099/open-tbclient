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
    private GuardClubRankListView gcR;
    private GuardClubRankHeaderView gcS;
    private GuardClubRankInfoView gcT;
    private int gcU;
    private int gcV;
    private d gcW;
    private d.a gcX;
    private int gcY;
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
        this.gcX = aVar;
        if (this.gcW != null) {
            this.gcW.a(this.gcX);
        }
    }

    public void tt(int i) {
        this.gcY = i;
        if (this.gcS != null) {
            this.gcS.setAvatarTopMargin(this.gcY);
        }
    }

    public void v(String str, long j) {
        if (this.gcW != null) {
            this.gcW.v(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bKw() {
        this.gcW = new d(getContext());
        this.gcW.a(this);
        this.gcW.a(this.gcX);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gcW.i(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gcW;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bKx() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gcR = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.gcR.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bKC() {
                if (c.this.mVisible && c.this.gcS != null) {
                    c.this.tu(c.this.gcS.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bKD() {
                if (c.this.gcW != null) {
                    c.this.gcW.bKF();
                }
            }
        });
        this.gcS = new GuardClubRankHeaderView(getContext());
        this.gcS.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gcW != null) {
                    c.this.gcW.f(kVar);
                }
            }
        });
        this.gcR.addHeaderView(this.gcS);
        this.gcU = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.gcV = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.gcW.getType()) {
            case 1:
                this.gcS.setStyle(1);
                break;
            case 2:
                this.gcS.setStyle(0);
                break;
        }
        if (this.gcS != null) {
            this.gcS.setAvatarTopMargin(this.gcY);
        }
        this.gcT = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.gcT.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bKE() {
                if (c.this.gcW != null) {
                    c.this.gcW.bKz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gcW != null) {
                this.gcW.bKG();
            }
            if (this.gcS != null) {
                this.gcS.bKN();
                tu(this.gcS.getTop());
                return;
            }
            return;
        }
        if (this.gcR != null) {
            this.gcR.bKO();
        }
        if (this.gcS != null) {
            this.gcS.QC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        if (this.gcW != null) {
            this.gcW.tu(ColorUtils.setAlphaComponent(this.gcV, (int) ((Math.abs(i) < this.gcU ? (1.0f * Math.abs(i)) / this.gcU : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gcS != null) {
            this.gcS.release();
        }
        if (this.gcR != null) {
            this.gcR.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gcR != null) {
            this.gcR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bR(List<k> list) {
        if (this.gcS != null) {
            this.gcS.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void I(boolean z, boolean z2) {
        if (this.gcR != null) {
            if (z2) {
                this.gcR.completePullRefresh();
            }
            this.gcR.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bKB() {
        if (this.gcT != null) {
            this.gcT.setVisibility(8);
        }
        if (this.gcR != null && this.gcR.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gcR.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gcW.bKF();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gcR.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.gcT.setData(str, str2, str3, str4, z);
        this.gcT.setVisibility(0);
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
