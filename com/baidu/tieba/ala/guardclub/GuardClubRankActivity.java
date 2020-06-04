package com.baidu.tieba.ala.guardclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.fragment.SupportXFragment;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.BackBar;
import com.baidu.tieba.ala.guardclub.rank.b;
import com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView;
/* loaded from: classes3.dex */
public class GuardClubRankActivity extends BaseFragmentActivity implements b.a {
    private static final String[] fzg = {"真爱团周榜", "真爱团总榜"};
    private View fzh;
    private GuardClubRankTabView fzi;
    private RelativeLayout fzj;
    private BdAlertDialog fzk;
    private com.baidu.tieba.ala.guardclub.rank.b fzl;
    private SupportXFragment[] fzm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            initView();
            za();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fzm != null) {
            for (SupportXFragment supportXFragment : this.fzm) {
                supportXFragment.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        if (this.fzm != null) {
            for (SupportXFragment supportXFragment : this.fzm) {
                supportXFragment.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportXFragment[] supportXFragmentArr;
        if (this.fzm != null) {
            for (SupportXFragment supportXFragment : this.fzm) {
                supportXFragment.onDestroyView();
                supportXFragment.onDestroy();
            }
        }
        if (this.fzl != null) {
            this.fzl.release();
        }
        if (this.fzk != null) {
            this.fzk.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void a(SupportXFragment... supportXFragmentArr) {
        this.fzm = supportXFragmentArr;
        ViewGroup viewGroup = (ViewGroup) findViewById(a.g.layout_supportx);
        viewGroup.removeAllViews();
        if (supportXFragmentArr != null) {
            for (SupportXFragment supportXFragment : supportXFragmentArr) {
                supportXFragment.onCreateView(getLayoutInflater(), null, null);
                supportXFragment.onActivityCreated(null);
                viewGroup.addView(supportXFragment.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
        this.fzi.setSelect(0);
        this.fzh.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportXFragment[] supportXFragmentArr2;
                int bottom = GuardClubRankActivity.this.fzh.getBottom() + GuardClubRankActivity.this.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                if (GuardClubRankActivity.this.fzm != null) {
                    for (SupportXFragment supportXFragment2 : GuardClubRankActivity.this.fzm) {
                        if (supportXFragment2 instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                            ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment2).qs(bottom);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void qq(int i) {
        if (this.fzh != null) {
            this.fzh.setBackgroundColor(i);
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void ax(final String str, final int i) {
        this.fzk = new BdAlertDialog(getPageContext().getPageActivity());
        this.fzk.setMessage(String.format(getString(a.i.guard_club_join_alert_title), Integer.valueOf(i)));
        this.fzk.setPositiveButton(a.i.guard_club_join_immediately, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (GuardClubRankActivity.this.fzl != null) {
                    GuardClubRankActivity.this.fzl.ay(str, i);
                }
                bdAlertDialog.dismiss();
            }
        });
        this.fzk.setNegativeButton(a.i.guard_club_join_think_again, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fzk.setPositiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            this.fzk.setNagetiveButtonTextColor(getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            this.fzk.setPositiveButtonTextColor(-57754);
            this.fzk.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.fzk.create(getPageContext()).show();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void w(String str, long j) {
        SupportXFragment[] supportXFragmentArr;
        if (this.fzm != null) {
            for (SupportXFragment supportXFragment : this.fzm) {
                if (supportXFragment instanceof com.baidu.tieba.ala.guardclub.rank.c) {
                    ((com.baidu.tieba.ala.guardclub.rank.c) supportXFragment).w(str, j);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public ViewGroup buC() {
        return this.fzj;
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.b.a
    public void K(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    private void initView() {
        setContentView(a.h.live_guard_club_activity_rank);
        initTitle();
        this.fzj = (RelativeLayout) findViewById(a.g.layout_join_suc);
        buD();
    }

    private void za() {
        this.fzl = new com.baidu.tieba.ala.guardclub.rank.b(getPageContext());
        this.fzl.a(getIntent(), this);
        this.fzl.buS();
    }

    private void initTitle() {
        this.fzh = findViewById(a.g.layout_title);
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
        this.fzi = (GuardClubRankTabView) findViewById(a.g.gcb_rank_tab);
        this.fzi.setNames(fzg);
        this.fzi.setCallback(new GuardClubRankTabView.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubRankActivity.6
            @Override // com.baidu.tieba.ala.guardclub.view.GuardClubRankTabView.a
            public void bX(int i) {
                if (GuardClubRankActivity.this.fzm != null) {
                    int i2 = 0;
                    while (i2 < GuardClubRankActivity.this.fzm.length) {
                        GuardClubRankActivity.this.fzm[i2].setUserVisibleHint(i2 == i);
                        if (GuardClubRankActivity.this.fzm[i2].getView() != null) {
                            GuardClubRankActivity.this.fzm[i2].getView().setVisibility(i2 == i ? 0 : 8);
                        }
                        i2++;
                    }
                }
            }
        });
    }

    private void buD() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fzh.setPadding(this.fzh.getPaddingLeft(), this.fzh.getPaddingTop() + UtilHelper.getStatusBarHeight(), this.fzh.getPaddingRight(), this.fzh.getPaddingBottom());
        }
    }
}
