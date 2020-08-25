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
/* loaded from: classes7.dex */
public class GuardClubRankActivity extends BaseActivity implements b.a {
    private static final String[] gbK = {"真爱团周榜", "真爱团总榜"};
    private View gbL;
    private GuardClubRankTabView gbM;
    private RelativeLayout gbN;
    private BdAlertDialog gbO;
    private com.baidu.tieba.ala.guardclub.rank.b gbP;
    private SupportXFragment[] gbQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            FF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gbQ != null) {
            for (SupportXFragment supportXFragment : this.gbQ) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.gbQ != null) {
            for (SupportXFragment supportXFragment : this.gbQ) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.gbQ != null) {
            for (SupportXFragment supportXFragment : this.gbQ) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.gbP != null) {
            this.gbP.release();
        }
        if (this.gbO != null) {
            this.gbO.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.gbQ = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.g.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.gbM.setSelect(0);
        this.gbL.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.gbL.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                if (GuardClubRankActivity.this.gbQ != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.gbQ) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).tt(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void tr(int i) {
        if (this.gbL != null) {
            this.gbL.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void az(final String str, final int i) {
        this.gbO = new BdAlertDialog(getPageContext().getPageActivity());
        this.gbO.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.gbO.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.gbP != null) {
                    GuardClubRankActivity.this.gbP.aA(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.gbO.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gbO.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.gbO.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.gbO.setPositiveButtonTextColor(-57754);
            this.gbO.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.gbO.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void v(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.gbQ != null) {
            for (SupportXFragment supportXFragment : this.gbQ) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).v(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bKj() {
        return this.gbN;
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
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.gbN = (RelativeLayout) findViewById(a.g.layout_join_suc);
        bKk();
    }

    private void FF() {
        this.gbP = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.gbP.a(getIntent(), this);
        this.gbP.bKx();
    }

    private void initTitle() {
        this.gbL = findViewById(a.g.layout_title);
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
        this.gbM = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.gbM.setNames(gbK);
        this.gbM.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void dY(int i) {
                if (GuardClubRankActivity.this.gbQ != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.gbQ.length) {
                        GuardClubRankActivity.this.gbQ[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.gbQ[i2].getView() != null) {
                            GuardClubRankActivity.this.gbQ[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bKk() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gbL.setPadding(this.gbL.getPaddingLeft(), this.gbL.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.gbL.getPaddingRight(), this.gbL.getPaddingBottom());
        }
    }
}
