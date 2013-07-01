package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.d {
    RelativeLayout b;
    RelativeLayout c;
    LinearLayout d;
    TextView e;
    Button f;
    com.baidu.tieba.view.ao g;
    private EnterForumActivity h;
    private BdListView i;
    private ProgressBar j;
    private k k;
    private AlertDialog l;
    private AlertDialog m;
    private AlertDialog n;
    private com.baidu.tieba.util.a o;

    public n(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.o = null;
        this.h = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.b = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.c = (RelativeLayout) enterForumActivity.findViewById(R.id.title);
        this.d = (LinearLayout) enterForumActivity.findViewById(R.id.search_bg_layout);
        this.e = (TextView) enterForumActivity.findViewById(R.id.search_bar_text);
        this.d.setOnClickListener(enterForumActivity);
        this.o = new com.baidu.tieba.util.a(this.h);
        int a2 = com.baidu.tieba.util.ab.a(this.h, 41.0f);
        this.o.a(a2, a2);
        this.o.a("forum_icon_mini");
        this.i = (BdListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.k = new k(enterForumActivity);
        this.k.a((View.OnClickListener) enterForumActivity);
        this.k.a((View.OnLongClickListener) enterForumActivity);
        this.k.b(enterForumActivity);
        this.i.setAdapter((ListAdapter) this.k);
        this.i.setOnKeyListener(onKeyListener);
        this.i.setOnItemClickListener(enterForumActivity);
        this.i.setOnScrollListener(enterForumActivity);
        this.g = new com.baidu.tieba.view.ao(enterForumActivity);
        this.i.setPullRefresh(this.g);
        this.f = (Button) enterForumActivity.findViewById(R.id.enter_forum_dir);
        this.f.setOnClickListener(enterForumActivity);
        CharSequence[] charSequenceArr = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(enterForumActivity);
        builder.setTitle(enterForumActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.m = builder.create();
        this.m.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(enterForumActivity);
        builder2.setTitle(enterForumActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.n = builder2.create();
        this.n.setCanceledOnTouchOutside(true);
        this.j = (ProgressBar) enterForumActivity.findViewById(R.id.enter_forum_progress);
        this.j.setVisibility(8);
    }

    public void a(com.baidu.tieba.data.m mVar, boolean z) {
        this.i.a();
        if (mVar != null) {
            try {
                this.k.a(Boolean.valueOf(z));
                this.k.a(mVar);
                this.k.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        this.j.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.j.setVisibility(8);
        if (!z && str != null) {
            this.h.a(str);
        }
    }

    public View b() {
        return this.f;
    }

    public void c() {
        this.k.notifyDataSetChanged();
    }

    public void d() {
        this.k.c();
    }

    public void e() {
    }

    public void f() {
        this.j.setVisibility(8);
        if (this.o != null) {
            this.o.b();
        }
    }

    public void g() {
        if (this.m != null) {
            this.m.dismiss();
        }
        if (this.n != null) {
            this.n.dismiss();
        }
    }

    public void a(int i) {
        com.baidu.tieba.util.x.b(this.b, i);
        com.baidu.tieba.util.x.d(this.c, i);
        if (i == 1) {
            com.baidu.tieba.util.x.h(this.d, (int) R.drawable.inputbox_top_1);
            this.e.setHintTextColor(-11446171);
        } else {
            com.baidu.tieba.util.x.h(this.d, (int) R.drawable.inputbox_top2);
            this.e.setHintTextColor(-5921112);
        }
        com.baidu.tieba.util.x.g((TextView) this.f, i);
        this.k.a(i);
        this.g.a(i);
    }

    public int h() {
        return R.id.first;
    }

    public int i() {
        return R.id.second;
    }

    public int j() {
        return R.id.show_more_layout;
    }

    public int k() {
        return R.id.want_login;
    }

    public void l() {
        this.m.show();
    }

    public void m() {
        this.n.show();
    }

    public void n() {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.h.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.h.getString(R.string.confirm), this.h);
            builder.setNegativeButton(this.h.getString(R.string.cancel), this.h);
            this.l = builder.create();
        }
        this.l.show();
    }

    public AlertDialog o() {
        return this.m;
    }

    public AlertDialog p() {
        return this.n;
    }

    public void a(String str) {
        View findViewWithTag;
        if (this.i != null && (findViewWithTag = this.i.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }

    public void q() {
        this.k.a();
        this.k.notifyDataSetChanged();
        if (!this.k.b().booleanValue()) {
            this.i.setSelection(0);
        }
    }

    public void r() {
        int headerViewsCount = this.i.getHeaderViewsCount() + 1;
        int firstVisiblePosition = this.i.getFirstVisiblePosition();
        int lastVisiblePosition = this.i.getLastVisiblePosition();
        if (firstVisiblePosition > 0) {
            firstVisiblePosition -= headerViewsCount;
            lastVisiblePosition -= headerViewsCount;
        }
        this.k.a(this.i, firstVisiblePosition, lastVisiblePosition);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.g.a(bVar);
    }
}
