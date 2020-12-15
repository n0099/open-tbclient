package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.BackBar;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes4.dex */
public class GuardClubRankActivity extends BaseActivity implements b.a {
    private static final String[] gPY = {"真爱团周榜", "真爱团总榜"};
    private View gPZ;
    private GuardClubRankTabView gQa;
    private RelativeLayout gQb;
    private BdAlertDialog gQc;
    private com.baidu.tieba.ala.guardclub.rank.b gQd;
    private SupportXFragment[] gQe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            Jg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gQe != null) {
            for (SupportXFragment supportXFragment : this.gQe) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.gQe != null) {
            for (SupportXFragment supportXFragment : this.gQe) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.gQe != null) {
            for (SupportXFragment supportXFragment : this.gQe) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.gQd != null) {
            this.gQd.release();
        }
        if (this.gQc != null) {
            this.gQc.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.gQe = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.f.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.gQa.setSelect(0);
        this.gPZ.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.gPZ.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                if (GuardClubRankActivity.this.gQe != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.gQe) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).vR(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void vP(int i) {
        if (this.gPZ != null) {
            this.gPZ.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aD(final String str, final int i) {
        this.gQc = new BdAlertDialog(getPageContext().getPageActivity());
        this.gQc.setMessage(String.format(getString(a.h.guard_club_join_alert_title), Integer.valueOf(i)));
        this.gQc.setPositiveButton(a.h.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.gQd != null) {
                    GuardClubRankActivity.this.gQd.aE(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.gQc.setNegativeButton(a.h.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQc.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            this.gQc.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            this.gQc.setPositiveButtonTextColor(-57754);
            this.gQc.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.gQc.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void y(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.gQe != null) {
            for (SupportXFragment supportXFragment : this.gQe) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).y(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bWm() {
        return this.gQb;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void N(Intent intent) {
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
        this.gQb = (RelativeLayout) findViewById(a.f.layout_join_suc);
        bWn();
    }

    private void Jg() {
        this.gQd = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.gQd.a(getIntent(), this);
        this.gQd.bWA();
    }

    private void initTitle() {
        this.gPZ = findViewById(a.f.layout_title);
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
        this.gQa = (GuardClubRankTabView) findViewById(a.f.gcb_rank_tab);
        this.gQa.setNames(gPY);
        this.gQa.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void fd(int i) {
                if (GuardClubRankActivity.this.gQe != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.gQe.length) {
                        GuardClubRankActivity.this.gQe[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.gQe[i2].getView() != null) {
                            GuardClubRankActivity.this.gQe[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bWn() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gPZ.setPadding(this.gPZ.getPaddingLeft(), this.gPZ.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.gPZ.getPaddingRight(), this.gPZ.getPaddingBottom());
        }
    }
}
