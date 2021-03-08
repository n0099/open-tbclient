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
    private GuardClubRankListView hcO;
    private GuardClubRankHeaderView hcP;
    private GuardClubRankInfoView hcQ;
    private int hcR;
    private int hcS;
    private d hcT;
    private d.a hcU;
    private int hcV;
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
        this.hcU = aVar;
        if (this.hcT != null) {
            this.hcT.a(this.hcU);
        }
    }

    public void uE(int i) {
        this.hcV = i;
        if (this.hcP != null) {
            this.hcP.setAvatarTopMargin(this.hcV);
        }
    }

    public void x(String str, long j) {
        if (this.hcT != null) {
            this.hcT.x(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bWe() {
        this.hcT = new d(getContext());
        this.hcT.a(this);
        this.hcT.a(this.hcU);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hcT.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.hcT;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bWf() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.hcO = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.hcO.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void onScroll() {
                if (c.this.mVisible && c.this.hcP != null) {
                    c.this.uF(c.this.hcP.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWk() {
                if (c.this.hcT != null) {
                    c.this.hcT.bWm();
                }
            }
        });
        this.hcP = new GuardClubRankHeaderView(getContext());
        this.hcP.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.hcT != null) {
                    c.this.hcT.f(kVar);
                }
            }
        });
        this.hcO.addHeaderView(this.hcP);
        this.hcR = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.hcS = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.hcT.getType()) {
            case 1:
                this.hcP.setStyle(1);
                break;
            case 2:
                this.hcP.setStyle(0);
                break;
        }
        if (this.hcP != null) {
            this.hcP.setAvatarTopMargin(this.hcV);
        }
        this.hcQ = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.hcQ.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bWl() {
                if (c.this.hcT != null) {
                    c.this.hcT.bWh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.hcT != null) {
                this.hcT.bWn();
            }
            if (this.hcP != null) {
                this.hcP.bWu();
                uF(this.hcP.getTop());
                return;
            }
            return;
        }
        if (this.hcO != null) {
            this.hcO.bWv();
        }
        if (this.hcP != null) {
            this.hcP.Xz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        if (this.hcT != null) {
            this.hcT.uF(ColorUtils.setAlphaComponent(this.hcS, (int) ((Math.abs(i) < this.hcR ? (1.0f * Math.abs(i)) / this.hcR : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.hcP != null) {
            this.hcP.release();
        }
        if (this.hcO != null) {
            this.hcO.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.hcO != null) {
            this.hcO.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cw(List<k> list) {
        if (this.hcP != null) {
            this.hcP.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void M(boolean z, boolean z2) {
        if (this.hcO != null) {
            if (z2) {
                this.hcO.completePullRefresh();
            }
            this.hcO.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bWj() {
        if (this.hcQ != null) {
            this.hcQ.setVisibility(8);
        }
        if (this.hcO != null && this.hcO.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.hcO.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hcT.bWm();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.hcO.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void d(String str, String str2, String str3, String str4, boolean z) {
        this.hcQ.setData(str, str2, str3, str4, z);
        this.hcQ.setVisibility(0);
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
