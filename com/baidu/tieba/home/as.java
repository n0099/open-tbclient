package com.baidu.tieba.home;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class as extends com.baidu.adp.a.e {
    public static int a;
    private com.baidu.tieba.f c;
    private NavigationBar d;
    private RelativeLayout e;
    private ao f;
    private ProgressBar g;
    private BdListView h;
    private cs i;
    private ae j;
    private u k;
    private View l;
    private TextView m;
    private TextView n;
    private TextView o;

    public as(com.baidu.tieba.f fVar) {
        super(fVar);
        this.i = null;
        this.c = fVar;
        this.c.setContentView(R.layout.signallforum_view);
        this.e = (RelativeLayout) this.c.findViewById(R.id.parent);
        this.d = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.d.a(this.c.getString(R.string.signallforum));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new at(this));
        this.h = (BdListView) this.c.findViewById(R.id.signallforum_list);
        this.h.setOnItemClickListener(fVar);
        this.i = new cs(fVar);
        this.h.setPullRefresh(this.i);
        this.o = (TextView) this.c.getLayoutInflater().inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.h.addFooterView(this.o);
        this.f = new ao(this.c);
        this.g = this.f.getProgressBar();
        this.g.setOnClickListener(this.c);
        this.h.addHeaderView(this.f);
        this.f.setVisibility(8);
        this.l = this.c.getLayoutInflater().inflate(R.layout.signallforum_header, (ViewGroup) null);
        this.m = (TextView) this.l.findViewById(R.id.signallforum_head_title);
        this.n = (TextView) this.l.findViewById(R.id.signallforum_head_res);
        this.h.addHeaderView(this.l);
        this.l.setVisibility(8);
        this.j = new ae(this.c, this.n);
        this.h.setAdapter((ListAdapter) this.j);
        this.h.setOnScrollListener(this.j);
    }

    public final void a(int i) {
        Resources resources = this.c.getResources();
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.e);
        this.c.getLayoutMode().a(this.o);
        if (i == 1) {
            this.e.setBackgroundColor(-13618114);
        } else {
            this.e.setBackgroundColor(-197380);
        }
        this.d.b(i);
        this.i.a(i);
        int i2 = i == 1 ? R.drawable.bg_ba_catalogue_1 : R.drawable.bg_ba_catalogue;
        int i3 = i == 1 ? R.color.forum_detail_ht_title_color_1 : R.color.forum_detail_ht_title_color;
        this.l.setBackgroundResource(i2);
        this.m.setTextColor(resources.getColor(i3));
        this.n.setTextColor(resources.getColor(i3));
        this.j.notifyDataSetChanged();
    }

    public final void a(u uVar) {
        this.k = uVar;
        if (this.k.i() == 0 || this.k.l().size() == this.k.j().size()) {
            this.f.a();
            int size = this.k.j().size();
            int size2 = this.k.l().size();
            this.n.setText(this.c.getString(R.string.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
        } else {
            this.n.setText(String.format(this.c.getString(R.string.signallforum_count), Integer.valueOf(this.k.j().size())));
        }
        TextView message1 = this.f.getMessage1();
        SpannableString spannableString = new SpannableString(String.valueOf(this.k.b()) + this.k.c() + this.k.d());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#56aeff"));
        int length = this.k.b().length();
        spannableString.setSpan(foregroundColorSpan, length, this.k.c().length() + length, 33);
        message1.setText(spannableString);
        this.f.getMessage2().setText(this.k.e());
        this.m.setText(this.k.a());
        this.l.setVisibility(0);
        this.f.setVisibility(0);
        ArrayList<v> j = uVar.j();
        this.j.a(this.k);
        if (j.size() == a) {
            this.o.setVisibility(0);
            this.o.setText(uVar.f());
            return;
        }
        this.o.setVisibility(8);
    }

    public final void a() {
        this.h.b();
    }

    public final void d() {
        this.h.a();
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.i.a(bVar);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.h.setOnItemClickListener(onItemClickListener);
    }

    public final ao e() {
        return this.f;
    }

    public final ProgressBar f() {
        return this.g;
    }

    public final u g() {
        return this.k;
    }

    public final ae h() {
        return this.j;
    }

    public final TextView i() {
        return this.n;
    }
}
