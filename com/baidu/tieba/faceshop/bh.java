package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class bh extends com.baidu.adp.widget.ListView.c {
    final /* synthetic */ be a;
    private com.baidu.tieba.f b;
    private TextView c = null;
    private ProgressBar d = null;
    private View e = null;
    private View f;

    public bh(be beVar, com.baidu.tieba.f fVar) {
        this.a = beVar;
        this.b = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public final View a() {
        this.e = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.b.getResources().getDimensionPixelSize(R.dimen.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(R.dimen.listview_item_margin));
        this.c = (TextView) this.e.findViewById(R.id.pb_more_text);
        this.f = this.e.findViewById(R.id.pb_more_view);
        this.f.setVisibility(8);
        this.d = (ProgressBar) this.e.findViewById(R.id.progress);
        a(TiebaApplication.g().ae());
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
        this.c.setText(this.b.getText(R.string.loading));
        this.f.setVisibility(0);
    }

    public final void f() {
        this.d.setVisibility(8);
        this.c.setText(R.string.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public final void onClick() {
    }
}
