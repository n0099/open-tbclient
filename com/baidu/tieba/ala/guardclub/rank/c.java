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
    private GuardClubRankListView gHR;
    private GuardClubRankHeaderView gHS;
    private GuardClubRankInfoView gHT;
    private int gHU;
    private int gHV;
    private d gHW;
    private d.a gHX;
    private int gHY;
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
        this.gHX = aVar;
        if (this.gHW != null) {
            this.gHW.a(this.gHX);
        }
    }

    public void vk(int i) {
        this.gHY = i;
        if (this.gHS != null) {
            this.gHS.setAvatarTopMargin(this.gHY);
        }
    }

    public void y(String str, long j) {
        if (this.gHW != null) {
            this.gHW.y(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bSN() {
        this.gHW = new d(getContext());
        this.gHW.a(this);
        this.gHW.a(this.gHX);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gHW.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gHW;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bSO() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gHR = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.gHR.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bST() {
                if (c.this.mVisible && c.this.gHS != null) {
                    c.this.vl(c.this.gHS.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bSU() {
                if (c.this.gHW != null) {
                    c.this.gHW.bSW();
                }
            }
        });
        this.gHS = new GuardClubRankHeaderView(getContext());
        this.gHS.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gHW != null) {
                    c.this.gHW.f(kVar);
                }
            }
        });
        this.gHR.addHeaderView(this.gHS);
        this.gHU = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.gHV = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.gHW.getType()) {
            case 1:
                this.gHS.setStyle(1);
                break;
            case 2:
                this.gHS.setStyle(0);
                break;
        }
        if (this.gHS != null) {
            this.gHS.setAvatarTopMargin(this.gHY);
        }
        this.gHT = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.gHT.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bSV() {
                if (c.this.gHW != null) {
                    c.this.gHW.bSQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gHW != null) {
                this.gHW.bSX();
            }
            if (this.gHS != null) {
                this.gHS.bTe();
                vl(this.gHS.getTop());
                return;
            }
            return;
        }
        if (this.gHR != null) {
            this.gHR.bTf();
        }
        if (this.gHS != null) {
            this.gHS.VV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(int i) {
        if (this.gHW != null) {
            this.gHW.vl(ColorUtils.setAlphaComponent(this.gHV, (int) ((Math.abs(i) < this.gHU ? (1.0f * Math.abs(i)) / this.gHU : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gHS != null) {
            this.gHS.release();
        }
        if (this.gHR != null) {
            this.gHR.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gHR != null) {
            this.gHR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cq(List<k> list) {
        if (this.gHS != null) {
            this.gHS.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void K(boolean z, boolean z2) {
        if (this.gHR != null) {
            if (z2) {
                this.gHR.completePullRefresh();
            }
            this.gHR.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bSS() {
        if (this.gHT != null) {
            this.gHT.setVisibility(8);
        }
        if (this.gHR != null && this.gHR.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gHR.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gHW.bSW();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gHR.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void g(String str, String str2, String str3, String str4, boolean z) {
        this.gHT.setData(str, str2, str3, str4, z);
        this.gHT.setVisibility(0);
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
