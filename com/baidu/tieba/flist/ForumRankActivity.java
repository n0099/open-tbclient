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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
/* loaded from: classes.dex */
public class ForumRankActivity extends com.baidu.tbadk.a {
    private BdListView a = null;
    private ag b = null;
    private r c = null;
    private NavigationBar d = null;
    private TbImageView e = null;
    private com.baidu.tbadk.editortool.aa f = null;
    private com.baidu.tieba.model.af g = null;
    private LinearLayout h = null;
    private com.baidu.tbadk.core.view.q i = null;
    private FrameLayout j = null;
    private Handler k = null;
    private String l = null;
    private boolean m = false;
    private final com.baidu.adp.a.h n = new aa(this);
    private final com.baidu.tbadk.core.util.ab o = new ab(this);
    private final AbsListView.OnScrollListener p = new ac(this);
    private final Runnable q = new ad(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.k.class, ForumRankActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = new Handler();
        setContentView(com.baidu.tieba.a.i.forum_rank_activity);
        this.e = new TbImageView(this);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f = new com.baidu.tbadk.editortool.aa(this);
        int b = com.baidu.adp.lib.util.i.b(this);
        this.f.a(b, b);
        this.d = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (BdListView) findViewById(com.baidu.tieba.a.h.list);
        this.e.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.i.b(this), (int) (com.baidu.adp.lib.util.i.b(this) * 0.5d)));
        this.a.setOnScrollListener(this.p);
        this.e.setVisibility(8);
        this.h = (LinearLayout) getLayoutInflater().inflate(com.baidu.tieba.a.i.forum_list_forum_footer, (ViewGroup) null);
        this.h.setOnClickListener(new ae(this));
        this.i = new com.baidu.tbadk.core.view.q(this);
        this.a.setPullRefresh(this.i);
        this.i.a(new af(this));
        this.j = (FrameLayout) findViewById(com.baidu.tieba.a.h.empty_textview_container);
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

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        ForumInfoData[] a = this.c.a();
        for (int i = 0; i < a.length; i++) {
            int d = com.baidu.tieba.r.c().d(a[i].forum_name);
            if (d == 1) {
                a[i].is_like = 1;
            } else if (d == -1) {
                a[i].is_like = 0;
            }
        }
        this.c.a(a);
        com.baidu.tbadk.core.util.ac.a(this.a, this.f, 0, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.k.removeCallbacks(this.q);
        this.f.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacks(this.q);
        this.f.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.d.b(i);
        if (i == 1) {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_bg));
            this.c.a(true);
        } else {
            this.a.setBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.backgroundcolor));
            this.c.a(false);
        }
        ba.b(findViewById(com.baidu.tieba.a.h.root_view), i);
        this.i.a(i);
        if (i == 1) {
            this.c.a(com.baidu.tieba.a.g.btn_add_end_1, com.baidu.tieba.a.g.btn_add_1);
            this.h.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down_1);
            return;
        }
        this.c.a(com.baidu.tieba.a.g.btn_add_end, com.baidu.tieba.a.g.btn_add);
        this.h.setBackgroundResource(com.baidu.tieba.a.g.bg_black_banner_down);
    }
}
