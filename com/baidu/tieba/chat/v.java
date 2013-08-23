package com.baidu.tieba.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private View.OnClickListener b;
    private Activity c;
    private DialogInterface.OnClickListener h;
    private FrameLayout i;
    private LinearLayout j;
    private com.baidu.tieba.ab k;
    private com.baidu.tieba.home.z l;
    private RelativeLayout d = null;
    private BdListView e = null;
    private t f = null;
    private com.baidu.tieba.view.aa g = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f961a = null;

    public v(Activity activity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = activity;
        this.b = onClickListener;
        m();
    }

    public void a() {
        this.i.setVisibility(0);
        this.j.setVisibility(8);
    }

    public void b() {
        if (this.l == null) {
            this.l = new com.baidu.tieba.home.z(this.c, this.c.getString(R.string.login_msg_tab), this.c.getString(R.string.login_msg_form), 3);
            this.j.addView(this.l.c());
            this.l.b(TiebaApplication.g().an());
        }
        this.i.setVisibility(8);
        this.j.setVisibility(0);
    }

    private void m() {
        this.c.setContentView(R.layout.chat_list_activity);
        this.d = (RelativeLayout) this.c.findViewById(R.id.chat_list);
        this.k = new com.baidu.tieba.ab(this.c, R.drawable.individual_center_news, R.drawable.individual_center_news_1);
        this.i = (FrameLayout) this.c.findViewById(R.id.bodyLogin);
        this.j = (LinearLayout) this.c.findViewById(R.id.bodyNotLogin);
        this.e = (BdListView) this.c.findViewById(R.id.chat_list_content);
        this.e.setDivider(null);
        this.g = new com.baidu.tieba.view.aa(this.c);
        this.e.setPullRefresh(this.g);
        this.f = new t(this.c);
        this.e.setAdapter((ListAdapter) this.f);
        this.f.a(this.b);
    }

    public void a(int i) {
        if (this.k != null) {
            this.k.a(i);
        }
        if (this.g != null) {
            this.g.a(i);
        }
        if (this.l != null) {
            this.l.b(i);
        }
        if (i == 1) {
            this.d.setBackgroundColor(-13618114);
            if (this.k.c()) {
                this.e.setDivider(this.c.getResources().getDrawable(17170445));
                return;
            } else {
                this.e.setDivider(this.c.getResources().getDrawable(R.drawable.list_divider_1));
                return;
            }
        }
        this.d.setBackgroundColor(-197380);
        if (this.k.c()) {
            this.e.setDivider(this.c.getResources().getDrawable(17170445));
        } else {
            this.e.setDivider(this.c.getResources().getDrawable(R.drawable.list_divider));
        }
    }

    public void c() {
        this.k.a();
    }

    public void d() {
        this.k.b();
    }

    public void a(List list) {
        this.f.a(list);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.e.setOnScrollListener(onScrollListener);
    }

    public void e() {
        AlertDialog.Builder builder;
        String string = this.c.getString(R.string.delete_user_chat);
        if (this.c.getParent() == null) {
            builder = new AlertDialog.Builder(this.c);
        } else {
            builder = new AlertDialog.Builder(this.c.getParent());
        }
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.h);
        this.f961a = builder.create();
        this.f961a.setCanceledOnTouchOutside(true);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.e.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.e.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.g.a(bVar);
    }

    public int f() {
        return this.e.getFirstVisiblePosition();
    }

    public int g() {
        return this.e.getLastVisiblePosition();
    }

    public t h() {
        return this.f;
    }

    public com.baidu.tieba.util.a i() {
        return this.f.a();
    }

    public BdListView j() {
        return this.e;
    }

    public void b(int i) {
        this.e.setSelection(i);
    }

    public void k() {
        this.e.a();
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void l() {
        if (this.f961a != null) {
            this.f961a.show();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.k.b(0);
        } else {
            this.k.b(8);
        }
        a(TiebaApplication.g().an());
    }
}
