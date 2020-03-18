package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.TbConfig;
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
public class GuardClubRankActivity extends BaseFragmentActivity implements a.InterfaceC0435a {
    private static final String[] eGP = {"真爱团周榜", "真爱团总榜"};
    private ScrollEnableViewPager ajD;
    private View eGQ;
    private GuardClubRankTabView eGR;
    private RelativeLayout eGS;
    private BdAlertDialog eGT;
    private com.baidu.tieba.ala.guardclub.rank.a eGU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        initView();
        tv();
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
        if (this.eGU != null) {
            this.eGU.release();
        }
        if (this.eGT != null) {
            this.eGT.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public void b(Fragment... fragmentArr) {
        final GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = new GuardClubRankFragmentPageAdapter(getSupportFragmentManager());
        guardClubRankFragmentPageAdapter.a(fragmentArr);
        this.ajD = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.ajD.setScrollEnabled(false);
        this.ajD.setAdapter(guardClubRankFragmentPageAdapter);
        this.ajD.setOffscreenPageLimit(guardClubRankFragmentPageAdapter.getCount() - 1);
        this.eGR.setSelect(0);
        this.eGQ.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = GuardClubRankActivity.this.eGQ.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                        if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                            ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).pv(bottom);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public void pt(int i) {
        if (this.eGQ != null) {
            this.eGQ.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public void am(final String str, final int i) {
        this.eGT = new BdAlertDialog(getPageContext().getPageActivity());
        this.eGT.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.eGT.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.eGU != null) {
                    GuardClubRankActivity.this.eGU.an(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.eGT.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eGT.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.eGT.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.eGT.setPositiveButtonTextColor(-57754);
            this.eGT.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.eGT.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public void w(String str, long j) {
        if (this.ajD != null && (this.ajD.getAdapter() instanceof GuardClubRankFragmentPageAdapter)) {
            GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = (GuardClubRankFragmentPageAdapter) this.ajD.getAdapter();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                    if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                        ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).w(str, j);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public ViewGroup bft() {
        return this.eGS;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0435a
    public void ab(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.eGS = (RelativeLayout) findViewById(a.g.layout_join_suc);
        bfu();
    }

    private void tv() {
        this.eGU = new com.baidu.tieba.ala.guardclub.rank.a(getPageContext());
        this.eGU.a(getIntent(), this);
        this.eGU.bfJ();
    }

    private void initTitle() {
        this.eGQ = findViewById(a.g.layout_title);
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
        this.eGR = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.eGR.setNames(eGP);
        this.eGR.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bP(int i) {
                if (GuardClubRankActivity.this.ajD != null) {
                    GuardClubRankActivity.this.ajD.setCurrentItem(i, false);
                }
            }
        });
    }

    private void bfu() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eGQ.setPadding(this.eGQ.getPaddingLeft(), this.eGQ.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.eGQ.getPaddingRight(), this.eGQ.getPaddingBottom());
        }
    }
}
