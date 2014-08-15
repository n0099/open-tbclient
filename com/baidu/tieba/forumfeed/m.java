package com.baidu.tieba.forumfeed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ j a;
    private BaseFragmentActivity b;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private View g;

    public m(j jVar, BaseFragmentActivity baseFragmentActivity) {
        this.a = jVar;
        this.b = null;
        this.b = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.f = LayoutInflater.from(this.b).inflate(v.new_pb_list_more, (ViewGroup) null);
        this.f.setPadding(0, this.b.getResources().getDimensionPixelSize(s.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(s.listview_item_margin));
        this.c = (TextView) this.f.findViewById(u.pb_more_text);
        this.g = this.f.findViewById(u.pb_more_view);
        this.g.setVisibility(8);
        this.d = (ProgressBar) this.f.findViewById(u.progress);
        a(TbadkApplication.m252getInst().getSkinType());
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.f;
    }

    public void a(int i) {
        n nVar;
        this.b.c().a(this.g);
        nVar = this.a.j;
        nVar.a(i);
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
        this.c.setText(this.b.getText(x.loading));
        this.g.setVisibility(0);
    }

    public void f() {
        this.d.setVisibility(8);
        this.c.setText(x.no_more_to_load);
    }

    public void g() {
        this.d.setVisibility(8);
        this.c.setText(x.load_more);
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
