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
/* loaded from: classes3.dex */
public class GuardClubRankActivity extends BaseActivity implements b.a {
    private static final String[] fKq = {"真爱团周榜", "真爱团总榜"};
    private View fKr;
    private GuardClubRankTabView fKs;
    private RelativeLayout fKt;
    private BdAlertDialog fKu;
    private com.baidu.tieba.ala.guardclub.rank.b fKv;
    private SupportXFragment[] fKw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            zA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fKw != null) {
            for (SupportXFragment supportXFragment : this.fKw) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.fKw != null) {
            for (SupportXFragment supportXFragment : this.fKw) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.fKw != null) {
            for (SupportXFragment supportXFragment : this.fKw) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.fKv != null) {
            this.fKv.release();
        }
        if (this.fKu != null) {
            this.fKu.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.fKw = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.g.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.fKs.setSelect(0);
        this.fKr.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.fKr.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                if (GuardClubRankActivity.this.fKw != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.fKw) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).qR(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void qP(int i) {
        if (this.fKr != null) {
            this.fKr.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void ax(final String str, final int i) {
        this.fKu = new BdAlertDialog(getPageContext().getPageActivity());
        this.fKu.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.fKu.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.fKv != null) {
                    GuardClubRankActivity.this.fKv.ay(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.fKu.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fKu.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.fKu.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.fKu.setPositiveButtonTextColor(-57754);
            this.fKu.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.fKu.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void w(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.fKw != null) {
            for (SupportXFragment supportXFragment : this.fKw) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).w(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bxy() {
        return this.fKt;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void K(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.fKt = (RelativeLayout) findViewById(a.g.layout_join_suc);
        bxz();
    }

    private void zA() {
        this.fKv = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.fKv.a(getIntent(), this);
        this.fKv.bxO();
    }

    private void initTitle() {
        this.fKr = findViewById(a.g.layout_title);
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
        this.fKs = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.fKs.setNames(fKq);
        this.fKs.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void cd(int i) {
                if (GuardClubRankActivity.this.fKw != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.fKw.length) {
                        GuardClubRankActivity.this.fKw[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.fKw[i2].getView() != null) {
                            GuardClubRankActivity.this.fKw[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bxz() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fKr.setPadding(this.fKr.getPaddingLeft(), this.fKr.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.fKr.getPaddingRight(), this.fKr.getPaddingBottom());
        }
    }
}
