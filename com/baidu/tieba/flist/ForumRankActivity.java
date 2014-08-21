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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.af;
/* loaded from: classes.dex */
public class ForumRankActivity extends BaseActivity {
    private BdListView a = null;
    private ac b = null;
    private p c = null;
    private NavigationBar d = null;
    private TbImageView e = null;
    private af f = null;
    private LinearLayout g = null;
    private com.baidu.tbadk.core.view.v h = null;
    private FrameLayout i = null;
    private String j = null;
    private boolean k = false;
    private final com.baidu.adp.base.h l = new y(this);
    private final com.baidu.tbadk.core.util.aa m = new z(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.q.class, ForumRankActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        a(bundle);
    }

    private void a() {
        setContentView(com.baidu.tieba.v.forum_rank_activity);
        this.e = new TbImageView(this);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (BdListView) findViewById(com.baidu.tieba.u.list);
        this.e.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.j.b(this), (int) (com.baidu.adp.lib.util.j.b(this) * 0.5d)));
        this.e.setVisibility(8);
        this.g = (LinearLayout) com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.forum_list_forum_footer, null);
        this.g.setOnClickListener(new aa(this));
        this.h = new com.baidu.tbadk.core.view.v(this);
        this.a.setPullRefresh(this.h);
        this.h.a(new ab(this));
        this.i = (FrameLayout) findViewById(com.baidu.tieba.u.empty_textview_container);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = new ac(bundle);
        } else {
            this.b = new ac(getIntent());
        }
        this.k = true;
        this.b.setLoadDataCallBack(this.l);
        this.c = new p(this, 0);
        this.c.a(100);
        this.c.a((Boolean) true);
        this.c.a(ForumDetailActivity.FromType.BAR_RANK);
        this.a.setAdapter((ListAdapter) this.c);
        if (this.b.LoadData()) {
            this.c.a(100);
            showProgressBar();
        }
        this.f = new af();
        this.c.a(this.f);
    }

    private void b() {
        ForumInfoData[] a = this.c.a();
        for (int i = 0; i < a.length; i++) {
            int c = ai.c().c(a[i].forum_name);
            if (c == 1) {
                a[i].is_like = 1;
            } else if (c == -1) {
                a[i].is_like = 0;
            }
        }
        this.c.a(a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.d.c(i);
        if (i == 1) {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.skin_1_common_bg));
            this.c.a(true);
        } else {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.r.backgroundcolor));
            this.c.a(false);
        }
        ay.b(findViewById(com.baidu.tieba.u.root_view), i);
        this.h.a(i);
        if (i == 1) {
            this.c.a(com.baidu.tieba.t.btn_add_end_1, com.baidu.tieba.t.btn_add_1);
            this.g.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down_1);
            return;
        }
        this.c.a(com.baidu.tieba.t.btn_add_end, com.baidu.tieba.t.btn_add);
        this.g.setBackgroundResource(com.baidu.tieba.t.bg_black_banner_down);
    }
}
