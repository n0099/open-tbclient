package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.BackBar;
import com.baidu.live.view.ScrollEnableViewPager;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragment;
import com.baidu.tieba.ala.guardclub.rank.GuardClubRankFragmentPageAdapter;
import com.baidu.tieba.ala.guardclub.rank.a;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes2.dex */
public class GuardClubRankActivity extends BaseFragmentActivity implements a.InterfaceC0424a {
    private static final String[] eBR = {"真爱团周榜", "真爱团总榜"};
    private ScrollEnableViewPager ahk;
    private View eBS;
    private GuardClubRankTabView eBT;
    private RelativeLayout eBU;
    private BdAlertDialog eBV;
    private com.baidu.tieba.ala.guardclub.rank.a eBW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initView();
        se();
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
        if (this.eBW != null) {
            this.eBW.release();
        }
        if (this.eBV != null) {
            this.eBV.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
    public void b(Fragment... fragmentArr) {
        final GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = new GuardClubRankFragmentPageAdapter(getSupportFragmentManager());
        guardClubRankFragmentPageAdapter.a(fragmentArr);
        this.ahk = (ScrollEnableViewPager) findViewById(a.g.vp);
        this.ahk.setScrollEnabled(false);
        this.ahk.setAdapter(guardClubRankFragmentPageAdapter);
        this.ahk.setOffscreenPageLimit(guardClubRankFragmentPageAdapter.getCount() - 1);
        this.eBT.setSelect(0);
        this.eBS.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = GuardClubRankActivity.this.eBS.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < guardClubRankFragmentPageAdapter.getCount()) {
                        if (guardClubRankFragmentPageAdapter.getItem(i2) instanceof GuardClubRankFragment) {
                            ((GuardClubRankFragment) guardClubRankFragmentPageAdapter.getItem(i2)).ph(bottom);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
    public void pa(int i) {
        if (this.eBS != null) {
            this.eBS.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
    public void ao(final String str, final int i) {
        this.eBV = new BdAlertDialog(getPageContext().getPageActivity());
        this.eBV.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.eBV.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.eBW != null) {
                    GuardClubRankActivity.this.eBW.ap(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.eBV.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBV.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.eBV.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.eBV.setPositiveButtonTextColor(-57754);
            this.eBV.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.eBV.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
    public void w(String str, long j) {
        if (this.ahk != null && (this.ahk.getAdapter() instanceof GuardClubRankFragmentPageAdapter)) {
            GuardClubRankFragmentPageAdapter guardClubRankFragmentPageAdapter = (GuardClubRankFragmentPageAdapter) this.ahk.getAdapter();
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

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
    public ViewGroup bcW() {
        return this.eBU;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.a.InterfaceC0424a
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
        this.eBU = (RelativeLayout) findViewById(a.g.layout_join_suc);
        bcX();
    }

    private void se() {
        this.eBW = new com.baidu.tieba.ala.guardclub.rank.a(getPageContext());
        this.eBW.a(getIntent(), this);
        this.eBW.bdt();
    }

    private void initTitle() {
        this.eBS = findViewById(a.g.layout_title);
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
        this.eBT = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.eBT.setNames(eBR);
        this.eBT.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bI(int i) {
                if (GuardClubRankActivity.this.ahk != null) {
                    GuardClubRankActivity.this.ahk.setCurrentItem(i, false);
                }
            }
        });
    }

    private void bcX() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eBS.setPadding(this.eBS.getPaddingLeft(), this.eBS.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.eBS.getPaddingRight(), this.eBS.getPaddingBottom());
        }
    }
}
