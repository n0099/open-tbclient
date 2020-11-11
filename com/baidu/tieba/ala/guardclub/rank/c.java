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
    private GuardClubRankListView gIk;
    private GuardClubRankHeaderView gIl;
    private GuardClubRankInfoView gIm;
    private int gIn;
    private int gIo;
    private d gIp;
    private d.a gIq;
    private int gIr;
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
        this.gIq = aVar;
        if (this.gIp != null) {
            this.gIp.a(this.gIq);
        }
    }

    public void uM(int i) {
        this.gIr = i;
        if (this.gIl != null) {
            this.gIl.setAvatarTopMargin(this.gIr);
        }
    }

    public void y(String str, long j) {
        if (this.gIp != null) {
            this.gIp.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bTu() {
        this.gIp = new d(getContext());
        this.gIp.a(this);
        this.gIp.a(this.gIq);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gIp.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gIp;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bTv() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gIk = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.gIk.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bTA() {
                if (c.this.mVisible && c.this.gIl != null) {
                    c.this.uN(c.this.gIl.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bTB() {
                if (c.this.gIp != null) {
                    c.this.gIp.bTD();
                }
            }
        });
        this.gIl = new GuardClubRankHeaderView(getContext());
        this.gIl.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gIp != null) {
                    c.this.gIp.f(kVar);
                }
            }
        });
        this.gIk.addHeaderView(this.gIl);
        this.gIn = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.gIo = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.gIp.getType()) {
            case 1:
                this.gIl.setStyle(1);
                break;
            case 2:
                this.gIl.setStyle(0);
                break;
        }
        if (this.gIl != null) {
            this.gIl.setAvatarTopMargin(this.gIr);
        }
        this.gIm = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.gIm.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bTC() {
                if (c.this.gIp != null) {
                    c.this.gIp.bTx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gIp != null) {
                this.gIp.bTE();
            }
            if (this.gIl != null) {
                this.gIl.bTL();
                uN(this.gIl.getTop());
                return;
            }
            return;
        }
        if (this.gIk != null) {
            this.gIk.bTM();
        }
        if (this.gIl != null) {
            this.gIl.WE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(int i) {
        if (this.gIp != null) {
            this.gIp.uN(ColorUtils.setAlphaComponent(this.gIo, (int) ((Math.abs(i) < this.gIn ? (1.0f * Math.abs(i)) / this.gIn : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gIl != null) {
            this.gIl.release();
        }
        if (this.gIk != null) {
            this.gIk.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gIk != null) {
            this.gIk.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cq(List<k> list) {
        if (this.gIl != null) {
            this.gIl.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void K(boolean z, boolean z2) {
        if (this.gIk != null) {
            if (z2) {
                this.gIk.completePullRefresh();
            }
            this.gIk.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bTz() {
        if (this.gIm != null) {
            this.gIm.setVisibility(8);
        }
        if (this.gIk != null && this.gIk.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gIk.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gIp.bTD();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gIk.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void g(String str, String str2, String str3, String str4, boolean z) {
        this.gIm.setData(str, str2, str3, str4, z);
        this.gIm.setVisibility(0);
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
