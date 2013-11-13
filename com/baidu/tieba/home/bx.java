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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bx extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1441a;
    private NavigationBar c;
    private RelativeLayout d;
    private bu e;
    private ProgressBar f;
    private BdListView g;
    private com.baidu.tieba.view.bi h;
    private bk i;
    private y j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;

    public bx(com.baidu.tieba.j jVar) {
        super(jVar);
        this.h = null;
        this.f1441a = jVar;
        this.f1441a.setContentView(R.layout.signallforum_view);
        this.d = (RelativeLayout) this.f1441a.findViewById(R.id.parent);
        this.c = (NavigationBar) this.f1441a.findViewById(R.id.view_navigation_bar);
        this.c.a(this.f1441a.getString(R.string.signallforum));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new by(this));
        this.g = (BdListView) this.f1441a.findViewById(R.id.signallforum_list);
        this.g.setOnItemClickListener(jVar);
        this.h = new com.baidu.tieba.view.bi(jVar);
        this.g.setPullRefresh(this.h);
        this.n = (TextView) this.f1441a.getLayoutInflater().inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.g.addFooterView(this.n);
        this.e = new bu(this.f1441a);
        this.f = this.e.getProgressBar();
        this.f.setOnClickListener(this.f1441a);
        this.g.addHeaderView(this.e);
        this.e.setVisibility(8);
        this.k = this.f1441a.getLayoutInflater().inflate(R.layout.signallforum_header, (ViewGroup) null);
        this.l = (TextView) this.k.findViewById(R.id.signallforum_head_title);
        this.m = (TextView) this.k.findViewById(R.id.signallforum_head_res);
        this.g.addHeaderView(this.k);
        this.k.setVisibility(8);
        this.i = new bk(this.f1441a, this.m);
        this.g.setAdapter((ListAdapter) this.i);
        this.g.setOnScrollListener(this.i);
    }

    public void a(int i) {
        Resources resources = this.f1441a.getResources();
        this.f1441a.getLayoutMode().a(i == 1);
        this.f1441a.getLayoutMode().a(this.d);
        this.f1441a.getLayoutMode().a(this.n);
        if (i == 1) {
            this.d.setBackgroundColor(-13618114);
        } else {
            this.d.setBackgroundColor(-197380);
        }
        this.c.c(i);
        this.h.a(i);
        int i2 = i == 1 ? R.drawable.bg_ba_catalogue_1 : R.drawable.bg_ba_catalogue;
        int i3 = i == 1 ? R.color.forum_detail_ht_title_color_1 : R.color.forum_detail_ht_title_color;
        this.k.setBackgroundResource(i2);
        this.l.setTextColor(resources.getColor(i3));
        this.m.setTextColor(resources.getColor(i3));
        this.i.notifyDataSetChanged();
    }

    public void a(y yVar) {
        this.j = yVar;
        k();
        ArrayList<z> j = yVar.j();
        this.i.a(this.j);
        if (j.size() == 200) {
            this.n.setVisibility(0);
            this.n.setText(yVar.f());
            return;
        }
        this.n.setVisibility(8);
    }

    private void k() {
        if (this.j.i() == 0 || this.j.l().size() == this.j.j().size()) {
            this.e.a();
            int size = this.j.j().size();
            int size2 = this.j.l().size();
            this.m.setText(String.format(this.f1441a.getString(R.string.signallforum_res), Integer.valueOf(size2), Integer.valueOf(size - size2)));
        } else {
            this.m.setText(String.format(this.f1441a.getString(R.string.signallforum_count), Integer.valueOf(this.j.j().size())));
        }
        TextView message1 = this.e.getMessage1();
        SpannableString spannableString = new SpannableString(this.j.b() + this.j.c() + this.j.d());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#56aeff"));
        int length = this.j.b().length();
        spannableString.setSpan(foregroundColorSpan, length, this.j.c().length() + length, 33);
        message1.setText(spannableString);
        this.e.getMessage2().setText(this.j.e());
        this.l.setText(this.j.a());
        this.k.setVisibility(0);
        this.e.setVisibility(0);
    }

    public void a() {
        this.g.b();
    }

    public void e() {
        this.g.a();
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.h.a(bVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.g.setOnItemClickListener(onItemClickListener);
    }

    public bu f() {
        return this.e;
    }

    public ProgressBar g() {
        return this.f;
    }

    public y h() {
        return this.j;
    }

    public bk i() {
        return this.i;
    }

    public TextView j() {
        return this.m;
    }
}
