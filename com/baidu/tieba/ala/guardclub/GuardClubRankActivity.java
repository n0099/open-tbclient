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
    private static final String[] gHi = {"真爱团周榜", "真爱团总榜"};
    private View gHj;
    private GuardClubRankTabView gHk;
    private RelativeLayout gHl;
    private BdAlertDialog gHm;
    private com.baidu.tieba.ala.guardclub.rank.b gHn;
    private SupportXFragment[] gHo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            HY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gHo != null) {
            for (SupportXFragment supportXFragment : this.gHo) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.gHo != null) {
            for (SupportXFragment supportXFragment : this.gHo) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.gHo != null) {
            for (SupportXFragment supportXFragment : this.gHo) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.gHn != null) {
            this.gHn.release();
        }
        if (this.gHm != null) {
            this.gHm.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.gHo = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.f.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.gHk.setSelect(0);
        this.gHj.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.gHj.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                if (GuardClubRankActivity.this.gHo != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.gHo) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).uM(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void uK(int i) {
        if (this.gHj != null) {
            this.gHj.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void aD(final String str, final int i) {
        this.gHm = new BdAlertDialog(getPageContext().getPageActivity());
        this.gHm.setMessage(String.format(getString(a.h.guard_club_join_alert_title), Integer.valueOf(i)));
        this.gHm.setPositiveButton(a.h.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.gHn != null) {
                    GuardClubRankActivity.this.gHn.aE(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.gHm.setNegativeButton(a.h.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gHm.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            this.gHm.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            this.gHm.setPositiveButtonTextColor(-57754);
            this.gHm.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.gHm.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void y(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.gHo != null) {
            for (SupportXFragment supportXFragment : this.gHo) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).y(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup bTi() {
        return this.gHl;
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
        this.gHl = (RelativeLayout) findViewById(a.f.layout_join_suc);
        bTj();
    }

    private void HY() {
        this.gHn = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.gHn.a(getIntent(), this);
        this.gHn.bTw();
    }

    private void initTitle() {
        this.gHj = findViewById(a.f.layout_title);
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
        this.gHk = (GuardClubRankTabView) findViewById(a.f.gcb_rank_tab);
        this.gHk.setNames(gHi);
        this.gHk.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void ei(int i) {
                if (GuardClubRankActivity.this.gHo != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.gHo.length) {
                        GuardClubRankActivity.this.gHo[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.gHo[i2].getView() != null) {
                            GuardClubRankActivity.this.gHo[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void bTj() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gHj.setPadding(this.gHj.getPaddingLeft(), this.gHj.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.gHj.getPaddingRight(), this.gHj.getPaddingBottom());
        }
    }
}
