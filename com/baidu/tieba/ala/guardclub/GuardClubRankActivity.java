package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.BackBar;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragmentPageAdapter;
import com.baidu.tieba.ala.guardclub.rank.a;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes3.dex */
public class GuardClubRankActivity extends BaseFragmentActivity implements a.InterfaceC0470a {
    private static final String[] flk = {"真爱团周榜", "真爱团总榜"};
    private ScrollEnableViewPager aBY;
    private View fll;
    private GuardClubRankTabView flm;
    private RelativeLayout fln;
    private BdAlertDialog flo;
    private com.baidu.tieba.ala.guardclub.rank.a flp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            xR();
        }
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
        if (this.flp != null) {
            this.flp.release();
        }
        if (this.flo != null) {
            this.flo.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public void b(Fragment... fragmentArr) {
        final GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = new GuardClubRankFragmentPageAdapter(getSupportFragmentManager());
        guardClubRankFragmentPageAdapter.a(fragmentArr);
        this.aBY = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.aBY.setScrollEnabled(false);
        this.aBY.setAdapter(guardClubRankFragmentPageAdapter);
        this.aBY.setOffscreenPageLimit(guardClubRankFragmentPageAdapter.getCount() - 1);
        this.flm.setSelect(0);
        this.fll.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = GuardClubRankActivity.this.fll.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                        if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                            ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).pP(bottom);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public void pN(int i) {
        if (this.fll != null) {
            this.fll.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public void aw(final String str, final int i) {
        this.flo = new BdAlertDialog(getPageContext().getPageActivity());
        this.flo.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.flo.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.flp != null) {
                    GuardClubRankActivity.this.flp.ax(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.flo.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.flo.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.flo.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.flo.setPositiveButtonTextColor(-57754);
            this.flo.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.flo.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public void x(String str, long j) {
        if (this.aBY != null && (this.aBY.getAdapter() instanceof GuardClubRankFragmentPageAdapter)) {
            GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = (GuardClubRankFragmentPageAdapter) this.aBY.getAdapter();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                    if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                        ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).x(str, j);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public ViewGroup boK() {
        return this.fln;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0470a
    public void aa(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.fln = (RelativeLayout) findViewById(a.g.layout_join_suc);
        boL();
    }

    private void xR() {
        this.flp = new com.baidu.tieba.ala.guardclub.rank.a(getPageContext());
        this.flp.a(getIntent(), this);
        this.flp.bpa();
    }

    private void initTitle() {
        this.fll = findViewById(a.g.layout_title);
        View findViewById = findViewById(a.g.iv_back);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuardClubRankActivity.this.finish();
            }
        });
        BackBar backBar = (BackBar) findViewById(a.g.backbar);
        backBar.setCallback(new BackBar.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.5
            @Override // com.baidu.live.view.BackBar.a
            public void onBack() {
                GuardClubRankActivity.this.finish();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            findViewById.setVisibility(8);
            backBar.setVisibility(0);
        } else {
            findViewById.setVisibility(0);
            backBar.setVisibility(8);
        }
        this.flm = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.flm.setNames(flk);
        this.flm.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bO(int i) {
                if (GuardClubRankActivity.this.aBY != null) {
                    GuardClubRankActivity.this.aBY.setCurrentItem(i, false);
                }
            }
        });
    }

    private void boL() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fll.setPadding(this.fll.getPaddingLeft(), this.fll.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.fll.getPaddingRight(), this.fll.getPaddingBottom());
        }
    }
}
