package com.baidu.tieba.forumfeed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ j a;
    private com.baidu.tbadk.core.e b;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private View g;

    public n(j jVar, com.baidu.tbadk.core.e eVar) {
        this.a = jVar;
        this.b = null;
        this.b = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.f = LayoutInflater.from(this.b).inflate(s.new_pb_list_more, (ViewGroup) null);
        this.f.setPadding(0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_item_margin));
        this.c = (TextView) this.f.findViewById(r.pb_more_text);
        this.g = this.f.findViewById(r.pb_more_view);
        this.g.setVisibility(8);
        this.d = (ProgressBar) this.f.findViewById(r.progress);
        a(TbadkApplication.m252getInst().getSkinType());
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.f;
    }

    public void a(int i) {
        o oVar;
        this.b.a().a(this.g);
        oVar = this.a.k;
        oVar.a(i);
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void c() {
        this.f.setVisibility(8);
    }

    public void d() {
        this.f.setVisibility(0);
    }

    public void e() {
        this.d.setVisibility(0);
        this.c.setText(this.b.getText(u.loading));
        this.g.setVisibility(0);
    }

    public void f() {
        this.d.setVisibility(8);
        this.c.setText(u.no_more_to_load);
    }

    public void g() {
        this.d.setVisibility(8);
        this.c.setText(u.load_more);
    }

    public void h() {
        this.g.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
