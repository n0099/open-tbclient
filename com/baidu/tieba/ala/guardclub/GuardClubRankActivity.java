package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.live.view.d;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragmentPageAdapter;
import com.baidu.tieba.ala.guardclub.rank.a;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes6.dex */
public class GuardClubRankActivity extends BaseFragmentActivity implements a.InterfaceC0347a {
    private static final String[] dNp = {"真爱团周榜", "真爱团总榜"};
    private ScrollEnableViewPager YU;
    private View dNq;
    private GuardClubRankTabView dNr;
    private RelativeLayout dNs;
    private com.baidu.live.view.d dNt;
    private com.baidu.tieba.ala.guardclub.rank.a dNu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initView();
        qg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.dNu != null) {
            this.dNu.release();
        }
        if (this.dNt != null) {
            this.dNt.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public void b(Fragment... fragmentArr) {
        final GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = new GuardClubRankFragmentPageAdapter(getSupportFragmentManager());
        guardClubRankFragmentPageAdapter.a(fragmentArr);
        this.YU = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.YU.setScrollEnabled(false);
        this.YU.setAdapter(guardClubRankFragmentPageAdapter);
        this.YU.setOffscreenPageLimit(guardClubRankFragmentPageAdapter.getCount() - 1);
        this.dNr.setSelect(0);
        this.dNq.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = GuardClubRankActivity.this.dNq.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                        if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                            ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).mR(bottom);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public void mK(int i) {
        if (this.dNq != null) {
            this.dNq.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public void ae(final String str, final int i) {
        this.dNt = new com.baidu.live.view.d(getPageContext().getPageActivity());
        this.dNt.aU(false);
        this.dNt.setTitleVisible(false);
        this.dNt.cp(-10066330);
        this.dNt.co(getResources().getDimensionPixelOffset(a.e.sdk_ds60));
        this.dNt.k("", String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)), "立即加入", "让我想想");
        this.dNt.cp(-10066330);
        this.dNt.cq(ViewCompat.MEASURED_STATE_MASK);
        this.dNt.a(new d.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.view.d.a
            public void qx() {
                if (GuardClubRankActivity.this.dNu != null) {
                    GuardClubRankActivity.this.dNu.af(str, i);
                }
            }

            @Override // com.baidu.live.view.d.a
            public void qy() {
            }
        });
        this.dNt.show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public void u(String str, long j) {
        if (this.YU != null && (this.YU.getAdapter() instanceof GuardClubRankFragmentPageAdapter)) {
            GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = (GuardClubRankFragmentPageAdapter) this.YU.getAdapter();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                    if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                        ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).u(str, j);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public ViewGroup aLu() {
        return this.dNs;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0347a
    public void aj(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.dNs = (RelativeLayout) findViewById(a.g.layout_join_suc);
        aLv();
    }

    private void qg() {
        this.dNu = new com.baidu.tieba.ala.guardclub.rank.a(getPageContext());
        this.dNu.a(getIntent(), this);
        this.dNu.aLR();
    }

    private void initTitle() {
        this.dNq = findViewById(a.g.layout_title);
        findViewById(a.g.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuardClubRankActivity.this.finish();
            }
        });
        this.dNr = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.dNr.setNames(dNp);
        this.dNr.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.4
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bu(int i) {
                if (GuardClubRankActivity.this.YU != null) {
                    GuardClubRankActivity.this.YU.setCurrentItem(i, false);
                }
            }
        });
    }

    private void aLv() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dNq.setPadding(this.dNq.getPaddingLeft(), this.dNq.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.dNq.getPaddingRight(), this.dNq.getPaddingBottom());
        }
    }
}
