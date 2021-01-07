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
    private GuardClubRankListView hcN;
    private GuardClubRankHeaderView hcO;
    private GuardClubRankInfoView hcP;
    private int hcQ;
    private int hcR;
    private d hcS;
    private d.a hcT;
    private int hcU;
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
        this.hcT = aVar;
        if (this.hcS != null) {
            this.hcS.a(this.hcT);
        }
    }

    public void wc(int i) {
        this.hcU = i;
        if (this.hcO != null) {
            this.hcO.setAvatarTopMargin(this.hcU);
        }
    }

    public void y(String str, long j) {
        if (this.hcS != null) {
            this.hcS.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bZe() {
        this.hcS = new d(getContext());
        this.hcS.a(this);
        this.hcS.a(this.hcT);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hcS.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.hcS;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bZf() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.hcN = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.hcN.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bZk() {
                if (c.this.mVisible && c.this.hcO != null) {
                    c.this.wd(c.this.hcO.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bZl() {
                if (c.this.hcS != null) {
                    c.this.hcS.bZn();
                }
            }
        });
        this.hcO = new GuardClubRankHeaderView(getContext());
        this.hcO.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.hcS != null) {
                    c.this.hcS.f(kVar);
                }
            }
        });
        this.hcN.addHeaderView(this.hcO);
        this.hcQ = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.hcR = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.hcS.getType()) {
            case 1:
                this.hcO.setStyle(1);
                break;
            case 2:
                this.hcO.setStyle(0);
                break;
        }
        if (this.hcO != null) {
            this.hcO.setAvatarTopMargin(this.hcU);
        }
        this.hcP = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.hcP.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bZm() {
                if (c.this.hcS != null) {
                    c.this.hcS.bZh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.hcS != null) {
                this.hcS.bZo();
            }
            if (this.hcO != null) {
                this.hcO.bZv();
                wd(this.hcO.getTop());
                return;
            }
            return;
        }
        if (this.hcN != null) {
            this.hcN.bZw();
        }
        if (this.hcO != null) {
            this.hcO.ZG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd(int i) {
        if (this.hcS != null) {
            this.hcS.wd(ColorUtils.setAlphaComponent(this.hcR, (int) ((Math.abs(i) < this.hcQ ? (1.0f * Math.abs(i)) / this.hcQ : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.hcO != null) {
            this.hcO.release();
        }
        if (this.hcN != null) {
            this.hcN.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.hcN != null) {
            this.hcN.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cB(List<k> list) {
        if (this.hcO != null) {
            this.hcO.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void M(boolean z, boolean z2) {
        if (this.hcN != null) {
            if (z2) {
                this.hcN.completePullRefresh();
            }
            this.hcN.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bZj() {
        if (this.hcP != null) {
            this.hcP.setVisibility(8);
        }
        if (this.hcN != null && this.hcN.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.hcN.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hcS.bZn();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.hcN.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void h(String str, String str2, String str3, String str4, boolean z) {
        this.hcP.setData(str, str2, str3, str4, z);
        this.hcP.setVisibility(0);
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
