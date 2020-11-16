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
    private static final String[] gGP = {"真爱团周榜", "真爱团总榜"};
    private View gGQ;
    private GuardClubRankTabView gGR;
    private RelativeLayout gGS;
    private BdAlertDialog gGT;
    private com.baidu.tieba.ala.guardclub.rank.b gGU;
    private SupportXFragment[] gGV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            Hp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gGV != null) {
            for (SupportXFragment supportXFragment : this.gGV) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.gGV != null) {
            for (SupportXFragment supportXFragment : this.gGV) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.gGV != null) {
            for (SupportXFragment supportXFragment : this.gGV) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.gGU != null) {
            this.gGU.release();
        }
        if (this.gGT != null) {
            this.gGT.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.gGV = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.f.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.gGR.setSelect(0);
        this.gGQ.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.gGQ.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                if (GuardClubRankActivity.this.gGV != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.gGV) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).vk(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void vi(int i) {
        if (this.gGQ != null) {
            this.gGQ.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aC(final String str, final int i) {
        this.gGT = new BdAlertDialog(getPageContext().getPageActivity());
        this.gGT.setMessage(String.format(getString(a.h.guard_club_join_alert_title), Integer.valueOf(i)));
        this.gGT.setPositiveButton(a.h.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.gGU != null) {
                    GuardClubRankActivity.this.gGU.aD(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.gGT.setNegativeButton(a.h.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gGT.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            this.gGT.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            this.gGT.setPositiveButtonTextColor(-57754);
            this.gGT.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.gGT.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void y(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.gGV != null) {
            for (SupportXFragment supportXFragment : this.gGV) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).y(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bSB() {
        return this.gGS;
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
        this.gGS = (RelativeLayout) findViewById(a.f.layout_join_suc);
        bSC();
    }

    private void Hp() {
        this.gGU = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.gGU.a(getIntent(), this);
        this.gGU.bSP();
    }

    private void initTitle() {
        this.gGQ = findViewById(a.f.layout_title);
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
        this.gGR = (GuardClubRankTabView) findViewById(a.f.gcb_rank_tab);
        this.gGR.setNames(gGP);
        this.gGR.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void ee(int i) {
                if (GuardClubRankActivity.this.gGV != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.gGV.length) {
                        GuardClubRankActivity.this.gGV[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.gGV[i2].getView() != null) {
                            GuardClubRankActivity.this.gGV[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bSC() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gGQ.setPadding(this.gGQ.getPaddingLeft(), this.gGQ.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.gGQ.getPaddingRight(), this.gGQ.getPaddingBottom());
        }
    }
}
