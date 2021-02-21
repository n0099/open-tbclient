package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.BackBar;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes11.dex */
public class GuardClubRankActivity extends BaseActivity implements b.a {
    private static final String[] had = {"真爱团周榜", "真爱团总榜"};
    private View hae;
    private GuardClubRankTabView haf;
    private RelativeLayout hag;
    private BdAlertDialog hah;
    private com.baidu.tieba.ala.guardclub.rank.b hai;
    private SupportXFragment[] haj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            Gd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.haj != null) {
            for (SupportXFragment supportXFragment : this.haj) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.haj != null) {
            for (SupportXFragment supportXFragment : this.haj) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.haj != null) {
            for (SupportXFragment supportXFragment : this.haj) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.hai != null) {
            this.hai.release();
        }
        if (this.hah != null) {
            this.hah.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.haj = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.f.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.haf.setSelect(0);
        this.hae.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.hae.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                if (GuardClubRankActivity.this.haj != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.haj) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).uC(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void uA(int i) {
        if (this.hae != null) {
            this.hae.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aH(final String str, final int i) {
        this.hah = new BdAlertDialog(getPageContext().getPageActivity());
        this.hah.setMessage(String.format(getString(a.h.guard_club_join_alert_title), Integer.valueOf(i)));
        this.hah.setPositiveButton(a.h.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.hai != null) {
                    GuardClubRankActivity.this.hai.aI(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.hah.setNegativeButton(a.h.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hah.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            this.hah.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            this.hah.setPositiveButtonTextColor(-57754);
            this.hah.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.hah.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void x(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.haj != null) {
            for (SupportXFragment supportXFragment : this.haj) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).x(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bVM() {
        return this.hag;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void O(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.g.live_guard_club_activity_rank);
        initTitle();
        this.hag = (RelativeLayout) findViewById(a.f.layout_join_suc);
        bVN();
    }

    private void Gd() {
        this.hai = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.hai.a(getIntent(), this);
        this.hai.bWa();
    }

    private void initTitle() {
        this.hae = findViewById(a.f.layout_title);
        View findViewById = findViewById(a.f.iv_back);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuardClubRankActivity.this.finish();
            }
        });
        BackBar backBar = (BackBar) findViewById(a.f.backbar);
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
        this.haf = (GuardClubRankTabView) findViewById(a.f.gcb_rank_tab);
        this.haf.setNames(had);
        this.haf.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void dB(int i) {
                if (GuardClubRankActivity.this.haj != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.haj.length) {
                        GuardClubRankActivity.this.haj[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.haj[i2].getView() != null) {
                            GuardClubRankActivity.this.haj[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bVN() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hae.setPadding(this.hae.getPaddingLeft(), this.hae.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.hae.getPaddingRight(), this.hae.getPaddingBottom());
        }
    }
}
