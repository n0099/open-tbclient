package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class bx extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ bu a;
    private final com.baidu.tbadk.a b;
    private TextView c = null;
    private ProgressBar d = null;
    private View e = null;
    private View f;

    public bx(bu buVar, com.baidu.tbadk.a aVar) {
        this.a = buVar;
        this.b = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final View a() {
        this.e = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_margin));
        this.c = (TextView) this.e.findViewById(com.baidu.tieba.a.h.pb_more_text);
        this.f = this.e.findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.f.setVisibility(8);
        this.d = (ProgressBar) this.e.findViewById(com.baidu.tieba.a.h.progress);
        a(TbadkApplication.j().l());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public final void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.f);
    }

    public final void c() {
        this.e.setVisibility(8);
    }

    public final void d() {
        this.e.setVisibility(0);
    }

    public final void e() {
        this.d.setVisibility(0);
        this.c.setText(this.b.getText(com.baidu.tieba.a.k.loading));
        this.f.setVisibility(0);
    }

    public final void f() {
        this.d.setVisibility(8);
        this.c.setText(com.baidu.tieba.a.k.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public final void onClick() {
    }
}
