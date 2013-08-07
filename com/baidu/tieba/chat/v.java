package com.baidu.tieba.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ah;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private View.OnClickListener b;
    private Activity c;
    private DialogInterface.OnClickListener m;
    private RelativeLayout d = null;
    private LinearLayout e = null;
    private ImageView f = null;
    private TextView g = null;
    private ImageView h = null;
    private TextView i = null;
    private BdListView j = null;
    private t k = null;
    private com.baidu.tieba.view.s l = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f951a = null;

    public v(Activity activity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = activity;
        this.b = onClickListener;
        i();
    }

    private void i() {
        this.c.setContentView(R.layout.chat_list_activity);
        this.d = (RelativeLayout) this.c.findViewById(R.id.chat_list);
        this.e = (LinearLayout) this.c.findViewById(R.id.chat_list_title);
        this.f = (ImageView) this.c.findViewById(R.id.bt_back);
        this.g = (TextView) this.c.findViewById(R.id.top_title);
        this.h = (ImageView) this.c.findViewById(R.id.add_chat);
        this.i = (TextView) this.c.findViewById(R.id.no_chat_text);
        this.j = (BdListView) this.c.findViewById(R.id.chat_list_content);
        this.j.setDivider(null);
        this.l = new com.baidu.tieba.view.s(this.c);
        this.j.setPullRefresh(this.l);
        this.k = new t(this.c);
        this.j.setAdapter((ListAdapter) this.k);
        this.k.a(this.b);
        this.f.setOnClickListener(this.b);
        this.h.setOnClickListener(this.b);
    }

    public void a(int i) {
        ah.d(this.e, i);
        ah.a(this.f, i);
        ah.f(this.g, i);
        if (this.l != null) {
            this.l.a(i);
        }
        if (i == 1) {
            this.d.setBackgroundColor(-13618114);
            this.j.setBackgroundColor(-13618114);
            this.h.setImageResource(R.drawable.icon_addbar_chat_1);
            this.h.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.j.setSelector(R.drawable.list_selector_1);
            this.i.setTextColor(-11446171);
            return;
        }
        this.d.setBackgroundColor(-197380);
        this.j.setBackgroundColor(-197380);
        this.h.setImageResource(R.drawable.icon_addbar_chat);
        this.h.setBackgroundResource(R.drawable.title_icon_bg);
        this.j.setSelector(R.drawable.list_selector);
        this.i.setTextColor(-10066330);
    }

    public void a(List list) {
        this.k.a(list);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.j.setOnScrollListener(onScrollListener);
    }

    public void a() {
        String string = this.c.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.m);
        this.f951a = builder.create();
        this.f951a.setCanceledOnTouchOutside(true);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.j.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.j.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.l.a(bVar);
    }

    public int b() {
        return this.j.getFirstVisiblePosition();
    }

    public int c() {
        return this.j.getLastVisiblePosition();
    }

    public t d() {
        return this.k;
    }

    public com.baidu.tieba.util.a e() {
        return this.k.a();
    }

    public BdListView f() {
        return this.j;
    }

    public void b(int i) {
        this.j.setSelection(i);
    }

    public void g() {
        this.j.a();
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void h() {
        if (this.f951a != null) {
            this.f951a.show();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }
}
