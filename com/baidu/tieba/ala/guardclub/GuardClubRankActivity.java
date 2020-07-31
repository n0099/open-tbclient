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
    private static final String[] fPL = {"真爱团周榜", "真爱团总榜"};
    private View fPM;
    private GuardClubRankTabView fPN;
    private RelativeLayout fPO;
    private BdAlertDialog fPP;
    private com.baidu.tieba.ala.guardclub.rank.b fPQ;
    private SupportXFragment[] fPR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            Ac();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fPR != null) {
            for (SupportXFragment supportXFragment : this.fPR) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.fPR != null) {
            for (SupportXFragment supportXFragment : this.fPR) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.fPR != null) {
            for (SupportXFragment supportXFragment : this.fPR) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.fPQ != null) {
            this.fPQ.release();
        }
        if (this.fPP != null) {
            this.fPP.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.fPR = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.g.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.fPN.setSelect(0);
        this.fPM.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.fPM.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                if (GuardClubRankActivity.this.fPR != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.fPR) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).rh(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void rf(int i) {
        if (this.fPM != null) {
            this.fPM.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aw(final String str, final int i) {
        this.fPP = new BdAlertDialog(getPageContext().getPageActivity());
        this.fPP.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.fPP.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.fPQ != null) {
                    GuardClubRankActivity.this.fPQ.ax(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.fPP.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fPP.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.fPP.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.fPP.setPositiveButtonTextColor(-57754);
            this.fPP.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.fPP.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void u(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.fPR != null) {
            for (SupportXFragment supportXFragment : this.fPR) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).u(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bAO() {
        return this.fPO;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void L(Intent intent) {
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
        this.fPO = (RelativeLayout) findViewById(a.g.layout_join_suc);
        bAP();
    }

    private void Ac() {
        this.fPQ = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.fPQ.a(getIntent(), this);
        this.fPQ.bBd();
    }

    private void initTitle() {
        this.fPM = findViewById(a.g.layout_title);
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
        this.fPN = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.fPN.setNames(fPL);
        this.fPN.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void cj(int i) {
                if (GuardClubRankActivity.this.fPR != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.fPR.length) {
                        GuardClubRankActivity.this.fPR[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.fPR[i2].getView() != null) {
                            GuardClubRankActivity.this.fPR[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bAP() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fPM.setPadding(this.fPM.getPaddingLeft(), this.fPM.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.fPM.getPaddingRight(), this.fPM.getPaddingBottom());
        }
    }
}
