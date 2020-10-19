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
    private GuardClubRankListView gss;
    private GuardClubRankHeaderView gst;
    private GuardClubRankInfoView gsu;
    private int gsv;
    private int gsw;
    private d gsx;
    private d.a gsy;
    private int gsz;
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
        this.gsy = aVar;
        if (this.gsx != null) {
            this.gsx.a(this.gsy);
        }
    }

    public void uk(int i) {
        this.gsz = i;
        if (this.gst != null) {
            this.gst.setAvatarTopMargin(this.gsz);
        }
    }

    public void v(String str, long j) {
        if (this.gsx != null) {
            this.gsx.v(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bOq() {
        this.gsx = new d(getContext());
        this.gsx.a(this);
        this.gsx.a(this.gsy);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gsx.k(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.gsx;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bOr() {
        return a.h.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.gss = (GuardClubRankListView) view.findViewById(a.g.lv);
        this.gss.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bOw() {
                if (c.this.mVisible && c.this.gst != null) {
                    c.this.ul(c.this.gst.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bOx() {
                if (c.this.gsx != null) {
                    c.this.gsx.bOz();
                }
            }
        });
        this.gst = new GuardClubRankHeaderView(getContext());
        this.gst.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.gsx != null) {
                    c.this.gsx.f(kVar);
                }
            }
        });
        this.gss.addHeaderView(this.gst);
        this.gsv = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
        this.gsw = getContext().getResources().getColor(a.d.live_gcb_primary);
        switch (this.gsx.getType()) {
            case 1:
                this.gst.setStyle(1);
                break;
            case 2:
                this.gst.setStyle(0);
                break;
        }
        if (this.gst != null) {
            this.gst.setAvatarTopMargin(this.gsz);
        }
        this.gsu = (GuardClubRankInfoView) view.findViewById(a.g.guard_club_rank_info);
        this.gsu.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bOy() {
                if (c.this.gsx != null) {
                    c.this.gsx.bOt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.gsx != null) {
                this.gsx.bOA();
            }
            if (this.gst != null) {
                this.gst.bOH();
                ul(this.gst.getTop());
                return;
            }
            return;
        }
        if (this.gss != null) {
            this.gss.bOI();
        }
        if (this.gst != null) {
            this.gst.Tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        if (this.gsx != null) {
            this.gsx.ul(ColorUtils.setAlphaComponent(this.gsw, (int) ((Math.abs(i) < this.gsv ? (1.0f * Math.abs(i)) / this.gsv : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.gst != null) {
            this.gst.release();
        }
        if (this.gss != null) {
            this.gss.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.gss != null) {
            this.gss.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bZ(List<k> list) {
        if (this.gst != null) {
            this.gst.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void I(boolean z, boolean z2) {
        if (this.gss != null) {
            if (z2) {
                this.gss.completePullRefresh();
            }
            this.gss.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bOv() {
        if (this.gsu != null) {
            this.gsu.setVisibility(8);
        }
        if (this.gss != null && this.gss.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.gss.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.gsx.bOz();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.gss.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void d(String str, String str2, String str3, String str4, boolean z) {
        this.gsu.setData(str, str2, str3, str4, z);
        this.gsu.setVisibility(0);
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
