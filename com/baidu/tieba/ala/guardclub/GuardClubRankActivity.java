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
public class GuardClubRankActivity extends BaseFragmentActivity implements a.InterfaceC0342a {
    private static final String[] dMy = {"真爱团周榜", "真爱团总榜"};
    private ScrollEnableViewPager YC;
    private GuardClubRankTabView dMA;
    private RelativeLayout dMB;
    private com.baidu.live.view.d dMC;
    private com.baidu.tieba.ala.guardclub.rank.a dMD;
    private View dMz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initView();
        qh();
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
        if (this.dMD != null) {
            this.dMD.release();
        }
        if (this.dMC != null) {
            this.dMC.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
    public void b(Fragment... fragmentArr) {
        final GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = new GuardClubRankFragmentPageAdapter(getSupportFragmentManager());
        guardClubRankFragmentPageAdapter.a(fragmentArr);
        this.YC = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.YC.setScrollEnabled(false);
        this.YC.setAdapter(guardClubRankFragmentPageAdapter);
        this.YC.setOffscreenPageLimit(guardClubRankFragmentPageAdapter.getCount() - 1);
        this.dMA.setSelect(0);
        this.dMz.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = GuardClubRankActivity.this.dMz.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                        if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                            ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).mQ(bottom);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
    public void mJ(int i) {
        if (this.dMz != null) {
            this.dMz.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
    public void ae(final String str, final int i) {
        this.dMC = new com.baidu.live.view.d(getPageContext().getPageActivity());
        this.dMC.aU(false);
        this.dMC.setTitleVisible(false);
        this.dMC.cp(-10066330);
        this.dMC.co(getResources().getDimensionPixelOffset(a.e.sdk_ds60));
        this.dMC.k("", String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)), "立即加入", "让我想想");
        this.dMC.cp(-10066330);
        this.dMC.cq(ViewCompat.MEASURED_STATE_MASK);
        this.dMC.a(new d.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.view.d.a
            public void qy() {
                if (GuardClubRankActivity.this.dMD != null) {
                    GuardClubRankActivity.this.dMD.af(str, i);
                }
            }

            @Override // com.baidu.live.view.d.a
            public void qz() {
            }
        });
        this.dMC.show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
    public void u(String str, long j) {
        if (this.YC != null && (this.YC.getAdapter() instanceof GuardClubRankFragmentPageAdapter)) {
            GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = (GuardClubRankFragmentPageAdapter) this.YC.getAdapter();
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

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
    public ViewGroup aLs() {
        return this.dMB;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0342a
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
        this.dMB = (RelativeLayout) findViewById(a.g.layout_join_suc);
        aLt();
    }

    private void qh() {
        this.dMD = new com.baidu.tieba.ala.guardclub.rank.a(getPageContext());
        this.dMD.a(getIntent(), this);
        this.dMD.aLP();
    }

    private void initTitle() {
        this.dMz = findViewById(a.g.layout_title);
        findViewById(a.g.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuardClubRankActivity.this.finish();
            }
        });
        this.dMA = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.dMA.setNames(dMy);
        this.dMA.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.4
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bu(int i) {
                if (GuardClubRankActivity.this.YC != null) {
                    GuardClubRankActivity.this.YC.setCurrentItem(i, false);
                }
            }
        });
    }

    private void aLt() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dMz.setPadding(this.dMz.getPaddingLeft(), this.dMz.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.dMz.getPaddingRight(), this.dMz.getPaddingBottom());
        }
    }
}
