package com.baidu.tieba.flist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aw;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumRankActivity extends com.baidu.tieba.f {
    private BdListView a = null;
    private ag b = null;
    private r c = null;
    private NavigationBar d = null;
    private TbImageView e = null;
    private com.baidu.tieba.util.i f = null;
    private ar g = null;
    private LinearLayout h = null;
    private cs i = null;
    private FrameLayout j = null;
    private TextView k = null;
    private Handler l = null;
    private String m = null;
    private boolean n = false;
    private com.baidu.adp.a.g o = new aa(this);
    private aw p = new ab(this);
    private AbsListView.OnScrollListener q = new ac(this);
    private Runnable r = new ad(this);

    public static void a(Context context, String str, String str2) {
        if (context != null && str != null) {
            Intent intent = new Intent(context, ForumRankActivity.class);
            intent.putExtra("id", str);
            intent.putExtra("st_type", str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new Handler();
        setContentView(R.layout.forum_rank_activity);
        this.e = new TbImageView(this);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f = new com.baidu.tieba.util.i(this);
        int b = BdUtilHelper.b(this);
        this.f.a(b, b);
        this.d = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (BdListView) findViewById(R.id.list);
        this.e.setLayoutParams(new AbsListView.LayoutParams(BdUtilHelper.b(this), (int) (BdUtilHelper.b(this) * 0.5d)));
        this.a.setOnScrollListener(this.q);
        this.e.setVisibility(8);
        this.h = (LinearLayout) getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.h.setOnClickListener(new ae(this));
        this.i = new cs(this);
        this.a.setPullRefresh(this.i);
        this.i.a(new af(this));
        this.j = (FrameLayout) findViewById(R.id.empty_textview_container);
        this.k = (TextView) findViewById(R.id.empty_textview);
        if (bundle != null) {
            this.b = new ag(bundle);
        } else {
            this.b = new ag(getIntent());
        }
        this.n = true;
        this.b.setLoadDataCallBack(this.o);
        this.c = new r(this, 0);
        this.c.a(100);
        this.c.a((Boolean) true);
        this.c.a(ForumDetailActivity.FromType.BAR_RANK);
        this.a.setAdapter((ListAdapter) this.c);
        if (this.b.LoadData()) {
            this.c.a(100);
            showProgressBar();
        }
        this.g = new ar();
        this.c.a(this.g);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        ForumInfoData[] a = this.c.a();
        for (int i = 0; i < a.length; i++) {
            int d = TiebaApplication.g().d(a[i].forum_name);
            if (d == 1) {
                a[i].is_like = 1;
            } else if (d == -1) {
                a[i].is_like = 0;
            }
        }
        this.c.a(a);
        ap.a(this.a, this.f, 0, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.removeCallbacks(this.r);
        this.f.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.l.removeCallbacks(this.r);
        this.f.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.d.b(i);
        if (i == 1) {
            this.a.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.c.a(true);
        } else {
            this.a.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
            this.c.a(false);
        }
        bq.b(findViewById(R.id.root_view), i);
        this.i.a(i);
        if (i == 1) {
            this.c.a(R.drawable.btn_add_end_1, R.drawable.btn_add_1);
            this.h.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            return;
        }
        this.c.a(R.drawable.btn_add_end, R.drawable.btn_add);
        this.h.setBackgroundResource(R.drawable.bg_black_banner_down);
    }
}
