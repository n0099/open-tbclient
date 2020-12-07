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
    private static final String[] gPW = {"真爱团周榜", "真爱团总榜"};
    private View gPX;
    private GuardClubRankTabView gPY;
    private RelativeLayout gPZ;
    private BdAlertDialog gQa;
    private com.baidu.tieba.ala.guardclub.rank.b gQb;
    private SupportXFragment[] gQc;

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
        if (this.gQc != null) {
            for (SupportXFragment supportXFragment : this.gQc) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.gQc != null) {
            for (SupportXFragment supportXFragment : this.gQc) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.gQc != null) {
            for (SupportXFragment supportXFragment : this.gQc) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.gQb != null) {
            this.gQb.release();
        }
        if (this.gQa != null) {
            this.gQa.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.gQc = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.f.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.gPY.setSelect(0);
        this.gPX.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.gPX.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                if (GuardClubRankActivity.this.gQc != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.gQc) {
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
        if (this.gPX != null) {
            this.gPX.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aD(final String str, final int i) {
        this.gQa = new BdAlertDialog(getPageContext().getPageActivity());
        this.gQa.setMessage(String.format(getString(a.h.guard_club_join_alert_title), Integer.valueOf(i)));
        this.gQa.setPositiveButton(a.h.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.gQb != null) {
                    GuardClubRankActivity.this.gQb.aE(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.gQa.setNegativeButton(a.h.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQa.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            this.gQa.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            this.gQa.setPositiveButtonTextColor(-57754);
            this.gQa.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.gQa.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void y(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.gQc != null) {
            for (SupportXFragment supportXFragment : this.gQc) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).y(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bWl() {
        return this.gPZ;
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
        this.gPZ = (RelativeLayout) findViewById(a.f.layout_join_suc);
        bWm();
    }

    private void Jg() {
        this.gQb = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.gQb.a(getIntent(), this);
        this.gQb.bWz();
    }

    private void initTitle() {
        this.gPX = findViewById(a.f.layout_title);
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
        this.gPY = (GuardClubRankTabView) findViewById(a.f.gcb_rank_tab);
        this.gPY.setNames(gPW);
        this.gPY.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void fd(int i) {
                if (GuardClubRankActivity.this.gQc != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.gQc.length) {
                        GuardClubRankActivity.this.gQc[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.gQc[i2].getView() != null) {
                            GuardClubRankActivity.this.gQc[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bWm() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gPX.setPadding(this.gPX.getPaddingLeft(), this.gPX.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.gPX.getPaddingRight(), this.gPX.getPaddingBottom());
        }
    }
}
