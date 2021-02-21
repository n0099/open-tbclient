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
    private GuardClubRankListView hbf;
    private GuardClubRankHeaderView hbg;
    private GuardClubRankInfoView hbh;
    private int hbi;
    private int hbj;
    private d hbk;
    private d.a hbl;
    private int hbm;
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
        this.hbl = aVar;
        if (this.hbk != null) {
            this.hbk.a(this.hbl);
        }
    }

    public void uC(int i) {
        this.hbm = i;
        if (this.hbg != null) {
            this.hbg.setAvatarTopMargin(this.hbm);
        }
    }

    public void x(String str, long j) {
        if (this.hbk != null) {
            this.hbk.x(str, j);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected e bVY() {
        this.hbk = new d(getContext());
        this.hbk.a(this);
        this.hbk.a(this.hbl);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hbk.j(arguments.getInt("type"), arguments.getString("anchor_id"), arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST));
        }
        return this.hbk;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected int bVZ() {
        return a.g.live_guard_club_fragment_rank;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a
    protected void onInflate(View view, Bundle bundle) {
        this.hbf = (GuardClubRankListView) view.findViewById(a.f.lv);
        this.hbf.setCallback(new GuardClubRankListView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.1
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void onScroll() {
                if (c.this.mVisible && c.this.hbg != null) {
                    c.this.uD(c.this.hbg.getTop());
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.a
            public void bWe() {
                if (c.this.hbk != null) {
                    c.this.hbk.bWg();
                }
            }
        });
        this.hbg = new GuardClubRankHeaderView(getContext());
        this.hbg.setCallback(new GuardClubRankHeaderView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.2
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankHeaderView.a
            public void a(k kVar) {
                if (c.this.hbk != null) {
                    c.this.hbk.f(kVar);
                }
            }
        });
        this.hbf.addHeaderView(this.hbg);
        this.hbi = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
        this.hbj = getContext().getResources().getColor(a.c.live_gcb_primary);
        switch (this.hbk.getType()) {
            case 1:
                this.hbg.setStyle(1);
                break;
            case 2:
                this.hbg.setStyle(0);
                break;
        }
        if (this.hbg != null) {
            this.hbg.setAvatarTopMargin(this.hbm);
        }
        this.hbh = (GuardClubRankInfoView) view.findViewById(a.f.guard_club_rank_info);
        this.hbh.setCallback(new GuardClubRankInfoView.a() { // from class: com.baidu.tieba.ala.guardclub.rank.c.3
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.a
            public void bWf() {
                if (c.this.hbk != null) {
                    c.this.hbk.bWb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.guardclub.rank.a
    public void onVisibilityChanged(boolean z) {
        super.onVisibilityChanged(z);
        if (z) {
            if (this.hbk != null) {
                this.hbk.bWh();
            }
            if (this.hbg != null) {
                this.hbg.bWo();
                uD(this.hbg.getTop());
                return;
            }
            return;
        }
        if (this.hbf != null) {
            this.hbf.bWp();
        }
        if (this.hbg != null) {
            this.hbg.Xw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(int i) {
        if (this.hbk != null) {
            this.hbk.uD(ColorUtils.setAlphaComponent(this.hbj, (int) ((Math.abs(i) < this.hbi ? (1.0f * Math.abs(i)) / this.hbi : 1.0f) * 216.75f)));
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.hbg != null) {
            this.hbg.release();
        }
        if (this.hbf != null) {
            this.hbf.release();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void a(BaseAdapter baseAdapter) {
        if (this.hbf != null) {
            this.hbf.setAdapter((ListAdapter) baseAdapter);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void cw(List<k> list) {
        if (this.hbg != null) {
            this.hbg.setData(list);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void M(boolean z, boolean z2) {
        if (this.hbf != null) {
            if (z2) {
                this.hbf.completePullRefresh();
            }
            this.hbf.setLoadMoreEnabled(z, z2);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void bWd() {
        if (this.hbh != null) {
            this.hbh.setVisibility(8);
        }
        if (this.hbf != null && this.hbf.getEmptyView() == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.hbf.getParent();
            CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
            commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
            commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.rank.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hbk.bWg();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            commonEmptyView.addToParent(relativeLayout);
            this.hbf.setEmptyView(commonEmptyView);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.d.b
    public void d(String str, String str2, String str3, String str4, boolean z) {
        this.hbh.setData(str, str2, str3, str4, z);
        this.hbh.setVisibility(0);
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
