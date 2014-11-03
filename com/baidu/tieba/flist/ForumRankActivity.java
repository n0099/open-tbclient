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
    private ac awR = null;
    private p awS = null;
    private NavigationBar mNavigationBar = null;
    private TbImageView aui = null;
    private ag avA = null;
    private LinearLayout awA = null;
    private com.baidu.tbadk.core.view.y Yg = null;
    private FrameLayout awT = null;
    private String awU = null;
    private boolean awV = false;
    private final com.baidu.adp.base.h awW = new y(this);
    private final com.baidu.tbadk.core.util.z awX = new z(this);

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
        this.aui = new TbImageView(this);
        this.aui.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText("");
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.aui.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.m.n(this), (int) (com.baidu.adp.lib.util.m.n(this) * 0.5d)));
        this.aui.setVisibility(8);
        this.awA = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.forum_list_forum_footer, null);
        this.awA.setOnClickListener(new aa(this));
        this.Yg = new com.baidu.tbadk.core.view.y(this);
        this.vl.setPullRefresh(this.Yg);
        this.Yg.a(new ab(this));
        this.awT = (FrameLayout) findViewById(com.baidu.tieba.v.empty_textview_container);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.awR.saveToBundle(bundle);
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.awR = new ac(bundle);
        } else {
            this.awR = new ac(getIntent());
        }
        this.awV = true;
        this.awR.setLoadDataCallBack(this.awW);
        this.awS = new p(this, 0);
        this.awS.eA(100);
        this.awS.e(true);
        this.awS.a(ForumDetailActivity.FromType.BAR_RANK);
        this.vl.setAdapter((ListAdapter) this.awS);
        if (this.awR.LoadData()) {
            this.awS.eA(100);
            showProgressBar();
        }
        this.avA = new ag(this);
        this.awS.a(this.avA);
    }

    private void DS() {
        ForumInfoData[] DR = this.awS.DR();
        for (int i = 0; i < DR.length; i++) {
            int dV = aj.wm().dV(DR[i].forum_name);
            if (dV == 1) {
                DR[i].is_like = 1;
            } else if (dV == -1) {
                DR[i].is_like = 0;
            }
        }
        this.awS.a(DR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        if (i == 1) {
            this.vl.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_bg));
            this.awS.bG(true);
        } else {
            this.vl.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            this.awS.bG(false);
        }
        aw.e(findViewById(com.baidu.tieba.v.root_view), i);
        this.Yg.bM(i);
        this.awS.H(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        aw.h(this.awA, com.baidu.tieba.u.bg_black_banner_down);
    }
}
