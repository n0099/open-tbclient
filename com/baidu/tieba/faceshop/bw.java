package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ bt a;
    private final BaseActivity b;
    private TextView c = null;
    private ProgressBar d = null;
    private View e = null;
    private View f;

    public bw(bt btVar, BaseActivity baseActivity) {
        this.a = btVar;
        this.b = baseActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.e = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_pb_list_more, (ViewGroup) null);
        this.e.setPadding(0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.c = (TextView) this.e.findViewById(com.baidu.tieba.v.pb_more_text);
        this.f = this.e.findViewById(com.baidu.tieba.v.pb_more_view);
        this.f.setVisibility(8);
        this.d = (ProgressBar) this.e.findViewById(com.baidu.tieba.v.progress);
        a(TbadkApplication.m252getInst().getSkinType());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.e;
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.f);
    }

    public void c() {
        this.e.setVisibility(8);
    }

    public void d() {
        this.e.setVisibility(0);
    }

    public void e() {
        this.c.setText(this.b.getText(com.baidu.tieba.y.loading));
        this.f.setVisibility(0);
    }

    public void f() {
        this.d.setVisibility(8);
        this.c.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
    }
}
