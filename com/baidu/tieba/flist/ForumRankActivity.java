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
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.bi;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ForumRankActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private BdListView f1234a = null;
    private ai b = null;
    private s c = null;
    private NavigationBar d = null;
    private TbImageView e = null;
    private com.baidu.tieba.util.i f = null;
    private ax g = null;
    private LinearLayout h = null;
    private bi i = null;
    private FrameLayout j = null;
    private TextView k = null;
    private Handler l = null;
    private com.baidu.adp.a.g m = new ae(this);
    private AbsListView.OnScrollListener n = new ag(this);
    private Runnable o = new ah(this);

    public static void a(Context context, String str, String str2) {
        if (context != null && str != null) {
            Intent intent = new Intent(context, ForumRankActivity.class);
            intent.putExtra(LocaleUtil.INDONESIAN, str);
            intent.putExtra("st_type", str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        a(bundle);
    }

    private void a() {
        this.l = new Handler();
        setContentView(R.layout.forum_rank_activity);
        this.e = new TbImageView(this);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f = new com.baidu.tieba.util.i(this);
        int a2 = UtilHelper.a((Context) this);
        this.f.a(a2, a2);
        this.d = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f1234a = (BdListView) findViewById(R.id.list);
        this.e.setLayoutParams(new AbsListView.LayoutParams(UtilHelper.a((Context) this), (int) (UtilHelper.a((Context) this) * 0.75d)));
        this.f1234a.addHeaderView(this.e, null, false);
        this.f1234a.setOnScrollListener(this.n);
        this.e.setVisibility(8);
        this.h = (LinearLayout) getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.h.setOnClickListener(new ac(this));
        this.i = new bi(this);
        this.f1234a.setPullRefresh(this.i);
        this.i.a(new ad(this));
        this.j = (FrameLayout) findViewById(R.id.empty_textview_container);
        this.k = (TextView) findViewById(R.id.empty_textview);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = new ai(bundle);
        } else {
            this.b = new ai(getIntent());
        }
        this.b.setLoadDataCallBack(this.m);
        this.c = new s(this, 0);
        this.c.a(100);
        this.c.a((Boolean) true);
        this.c.a(ForumDetailActivity.FromType.BAR_RANK);
        this.f1234a.setAdapter((ListAdapter) this.c);
        if (this.b.LoadData()) {
            this.c.a(100);
            showProgressBar();
        }
        this.g = new ax();
        this.c.a(this.g);
    }

    private void b() {
        ForumInfoData[] a2 = this.c.a();
        for (int i = 0; i < a2.length; i++) {
            int d = TiebaApplication.g().d(a2[i].forum_name);
            if (d == 1) {
                a2[i].is_like = 1;
            } else if (d == -1) {
                a2[i].is_like = 0;
            }
        }
        this.c.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        b();
        com.baidu.tieba.util.ak.a(this.f1234a, this.f, 1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.removeCallbacks(this.o);
        this.f.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.l.removeCallbacks(this.o);
        this.f.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.d.c(i);
        bd.a((ListView) this.f1234a, i);
        bd.b(findViewById(R.id.root_view), i);
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
