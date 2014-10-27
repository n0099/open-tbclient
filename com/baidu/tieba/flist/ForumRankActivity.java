package com.baidu.tieba.flist;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
public class ForumRankActivity extends BaseActivity {
    private BdListView vl = null;
    private ac awI = null;
    private p awJ = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView atZ = null;
    private ag avr = null;
    private LinearLayout awr = null;
    private com.baidu.tbadk.core.view.y Yc = null;
    private FrameLayout awK = null;
    private String awL = null;
    private boolean awM = false;
    private final com.baidu.adp.base.h awN = new y(this);
    private final com.baidu.tbadk.core.util.z awO = new z(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(ForumRankActivityConfig.class, ForumRankActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        d(bundle);
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.forum_rank_activity);
        this.atZ = new TbImageView(this);
        this.atZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.atZ.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.m.n(this), (int) (com.baidu.adp.lib.util.m.n(this) * 0.5d)));
        this.atZ.setVisibility(8);
        this.awr = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.awr.setOnClickListener(new aa(this));
        this.Yc = new com.baidu.tbadk.core.view.y(this);
        this.vl.setPullRefresh(this.Yc);
        this.Yc.a(new ab(this));
        this.awK = (FrameLayout) findViewById(com.baidu.tieba.v.empty_textview_container);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.awI.saveToBundle(bundle);
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.awI = new ac(bundle);
        } else {
            this.awI = new ac(getIntent());
        }
        this.awM = true;
        this.awI.setLoadDataCallBack(this.awN);
        this.awJ = new p(this, 0);
        this.awJ.eA(100);
        this.awJ.e(true);
        this.awJ.a(ForumDetailActivity.FromType.BAR_RANK);
        this.vl.setAdapter((ListAdapter) this.awJ);
        if (this.awI.LoadData()) {
            this.awJ.eA(100);
            showProgressBar();
        }
        this.avr = new ag(this);
        this.awJ.a(this.avr);
    }

    private void DQ() {
        ForumInfoData[] DP = this.awJ.DP();
        for (int i = 0; i < DP.length; i++) {
            int dV = aj.wk().dV(DP[i].forum_name);
            if (dV == 1) {
                DP[i].is_like = 1;
            } else if (dV == -1) {
                DP[i].is_like = 0;
            }
        }
        this.awJ.a(DP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        if (i == 1) {
            this.vl.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_bg));
            this.awJ.bG(true);
        } else {
            this.vl.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            this.awJ.bG(false);
        }
        aw.e(findViewById(com.baidu.tieba.v.root_view), i);
        this.Yc.bM(i);
        this.awJ.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        aw.h(this.awr, com.baidu.tieba.u.bg_black_banner_down);
    }
}
