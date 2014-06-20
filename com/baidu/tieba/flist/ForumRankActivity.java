package com.baidu.tieba.flist;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* loaded from: classes.dex */
public class ForumRankActivity extends BaseActivity {
    private BdListView a = null;
    private ag b = null;
    private r c = null;
    private NavigationBar d = null;
    private TbImageView e = null;
    private com.baidu.tbadk.editortool.ab f = null;
    private com.baidu.tieba.model.af g = null;
    private LinearLayout h = null;
    private com.baidu.tbadk.core.view.q i = null;
    private FrameLayout j = null;
    private Handler k = null;
    private String l = null;
    private boolean m = false;
    private final com.baidu.adp.base.e n = new aa(this);
    private final com.baidu.tbadk.core.util.af o = new ab(this);
    private final AbsListView.OnScrollListener p = new ac(this);
    private final Runnable q = new ad(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.l.class, ForumRankActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        a(bundle);
    }

    private void a() {
        this.k = new Handler();
        setContentView(com.baidu.tieba.w.forum_rank_activity);
        this.e = new TbImageView(this);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f = new com.baidu.tbadk.editortool.ab(this);
        int b = com.baidu.adp.lib.util.k.b(this);
        this.f.a(b, b);
        this.d = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.e.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.b(this), (int) (com.baidu.adp.lib.util.k.b(this) * 0.5d)));
        this.a.setOnScrollListener(this.p);
        this.e.setVisibility(8);
        this.h = (LinearLayout) getLayoutInflater().inflate(com.baidu.tieba.w.forum_list_forum_footer, (ViewGroup) null);
        this.h.setOnClickListener(new ae(this));
        this.i = new com.baidu.tbadk.core.view.q(this);
        this.a.setPullRefresh(this.i);
        this.i.a(new af(this));
        this.j = (FrameLayout) findViewById(com.baidu.tieba.v.empty_textview_container);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = new ag(bundle);
        } else {
            this.b = new ag(getIntent());
        }
        this.m = true;
        this.b.setLoadDataCallBack(this.n);
        this.c = new r(this, 0);
        this.c.a(100);
        this.c.a((Boolean) true);
        this.c.a(ForumDetailActivity.FromType.BAR_RANK);
        this.a.setAdapter((ListAdapter) this.c);
        if (this.b.LoadData()) {
            this.c.a(100);
            showProgressBar();
        }
        this.g = new com.baidu.tieba.model.af();
        this.c.a(this.g);
    }

    private void b() {
        ForumInfoData[] a = this.c.a();
        for (int i = 0; i < a.length; i++) {
            int d = ai.c().d(a[i].forum_name);
            if (d == 1) {
                a[i].is_like = 1;
            } else if (d == -1) {
                a[i].is_like = 0;
            }
        }
        this.c.a(a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b();
        com.baidu.tbadk.core.util.ag.a(this.a, this.f, 0, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k.removeCallbacks(this.q);
        this.f.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacks(this.q);
        this.f.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.d.c(i);
        if (i == 1) {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_bg));
            this.c.a(true);
        } else {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            this.c.a(false);
        }
        be.b(findViewById(com.baidu.tieba.v.root_view), i);
        this.i.a(i);
        if (i == 1) {
            this.c.a(com.baidu.tieba.u.btn_add_end_1, com.baidu.tieba.u.btn_add_1);
            this.h.setBackgroundResource(com.baidu.tieba.u.bg_black_banner_down_1);
            return;
        }
        this.c.a(com.baidu.tieba.u.btn_add_end, com.baidu.tieba.u.btn_add);
        this.h.setBackgroundResource(com.baidu.tieba.u.bg_black_banner_down);
    }
}
