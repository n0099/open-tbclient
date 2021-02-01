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
/* loaded from: classes11.dex */
public class c extends a implements d.b {
    private GuardClubRankListView haR;
    private GuardClubRankHeaderView haS;
    private GuardClubRankInfoView haT;
    private int haU;
    private int haV;
    private d haW;
    private d.a haX;
    private int haY;
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
        this.haX = aVar;
        if (this.haW != null) {
            this.haW.a(this.haX);
        }
    }

    public void uC(int i) {
        this.haY = i;
        if (this.haS != null) {
            this.haS.setAvatarTopMargin(this.haY);
        }
    }

    public void x(String str, long j) {
        if (this.haW != null) {
            this.haW.x(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bVR() {
        this.haW = new d(getContext());
        this.haW.a(this);
        this.haW.a(this.haX);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.haW.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.haW;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bVS() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.haR = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.haR.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void onScroll() {
                if (c.this.mVisible && c.this.haS != null) {
                    c.this.uD(c.this.haS.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bVX() {
                if (c.this.haW != null) {
                    c.this.haW.bVZ();
                }
            }
        });
        this.haS = new GuardClubRankHeaderView(getContext());
        this.haS.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.haW != null) {
                    c.this.haW.f(kVar);
                }
            }
        });
        this.haR.addHeaderView(this.haS);
        this.haU = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.haV = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.haW.getType()) {
            case 1:
                this.haS.setStyle(1);
                break;
            case 2:
                this.haS.setStyle(0);
                break;
        }
        if (this.haS != null) {
            this.haS.setAvatarTopMargin(this.haY);
        }
        this.haT = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.haT.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bVY() {
                if (c.this.haW != null) {
                    c.this.haW.bVU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.haW != null) {
                this.haW.bWa();
            }
            if (this.haS != null) {
                this.haS.bWh();
                uD(this.haS.getTop());
                return;
            }
            return;
        }
        if (this.haR != null) {
            this.haR.bWi();
        }
        if (this.haS != null) {
            this.haS.Xw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(int i) {
        if (this.haW != null) {
            this.haW.uD(ColorUtils.setAlphaComponent(this.haV, (int) ((Math.abs(i) < this.haU ? (1.0f * Math.abs(i)) / this.haU : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.haS != null) {
            this.haS.release();
        }
        if (this.haR != null) {
            this.haR.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.haR != null) {
            this.haR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cw(List<k> list) {
        if (this.haS != null) {
            this.haS.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void M(boolean z, boolean z2) {
        if (this.haR != null) {
            if (z2) {
                this.haR.completePullRefresh();
            }
            this.haR.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bVW() {
        if (this.haT != null) {
            this.haT.setVisibility(8);
        }
        if (this.haR != null && this.haR.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.haR.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.haW.bVZ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.haR.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void d(String str, String str2, String str3, String str4, boolean z) {
        this.haT.setData(str, str2, str3, str4, z);
        this.haT.setVisibility(0);
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
