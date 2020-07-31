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
    private GuardClubRankListView fQP;
    private GuardClubRankHeaderView fQQ;
    private GuardClubRankInfoView fQR;
    private int fQS;
    private int fQT;
    private d fQU;
    private d.a fQV;
    private int fQW;
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
        this.fQV = aVar;
        if (this.fQU != null) {
            this.fQU.a(this.fQV);
        }
    }

    public void rh(int i) {
        this.fQW = i;
        if (this.fQQ != null) {
            this.fQQ.setAvatarTopMargin(this.fQW);
        }
    }

    public void u(String str, long j) {
        if (this.fQU != null) {
            this.fQU.u(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bBb() {
        this.fQU = new d(getContext());
        this.fQU.a(this);
        this.fQU.a(this.fQV);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fQU.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.fQU;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bBc() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.fQP = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.fQP.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bBh() {
                if (c.this.mVisible && c.this.fQQ != null) {
                    c.this.ri(c.this.fQQ.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bBi() {
                if (c.this.fQU != null) {
                    c.this.fQU.bBk();
                }
            }
        });
        this.fQQ = new GuardClubRankHeaderView(getContext());
        this.fQQ.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.fQU != null) {
                    c.this.fQU.f(kVar);
                }
            }
        });
        this.fQP.addHeaderView(this.fQQ);
        this.fQS = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.fQT = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.fQU.getType()) {
            case 1:
                this.fQQ.setStyle(1);
                break;
            case 2:
                this.fQQ.setStyle(0);
                break;
        }
        if (this.fQQ != null) {
            this.fQQ.setAvatarTopMargin(this.fQW);
        }
        this.fQR = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.fQR.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bBj() {
                if (c.this.fQU != null) {
                    c.this.fQU.bBe();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.fQU != null) {
                this.fQU.bBl();
            }
            if (this.fQQ != null) {
                this.fQQ.bBs();
                ri(this.fQQ.getTop());
                return;
            }
            return;
        }
        if (this.fQP != null) {
            this.fQP.bBt();
        }
        if (this.fQQ != null) {
            this.fQQ.bAQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(int i) {
        if (this.fQU != null) {
            this.fQU.ri(ColorUtils.setAlphaComponent(this.fQT, (int) ((Math.abs(i) < this.fQS ? (1.0f * Math.abs(i)) / this.fQS : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.fQQ != null) {
            this.fQQ.release();
        }
        if (this.fQP != null) {
            this.fQP.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.fQP != null) {
            this.fQP.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bQ(List<k> list) {
        if (this.fQQ != null) {
            this.fQQ.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void F(boolean z, boolean z2) {
        if (this.fQP != null) {
            if (z2) {
                this.fQP.completePullRefresh();
            }
            this.fQP.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bBg() {
        if (this.fQR != null) {
            this.fQR.setVisibility(8);
        }
        if (this.fQP != null && this.fQP.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.fQP.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.fQU.bBk();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.fQP.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void c(String str, String str2, String str3, String str4, boolean z) {
        this.fQR.setData(str, str2, str3, str4, z);
        this.fQR.setVisibility(0);
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
