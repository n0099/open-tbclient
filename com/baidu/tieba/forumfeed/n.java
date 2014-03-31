package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n {
    public boolean a = false;
    final /* synthetic */ i b;
    private final TextView c;
    private final TextView d;
    private final ImageView e;
    private final LinearLayout f;
    private final Button g;
    private final View h;

    public n(i iVar, Context context, View view) {
        this.b = iVar;
        this.h = view;
        this.c = (TextView) view.findViewById(com.baidu.tieba.a.h.tip1);
        this.d = (TextView) view.findViewById(com.baidu.tieba.a.h.tip2);
        this.e = (ImageView) view.findViewById(com.baidu.tieba.a.h.nodata_img_bg);
        this.g = (Button) view.findViewById(com.baidu.tieba.a.h.btn_go);
        this.f = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.layout_btn_go);
        this.g.setOnClickListener(new o(this, context));
    }

    public final void a() {
        LinearLayout linearLayout;
        this.a = false;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        int i = TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.e.forumfeed_frs_bg_1 : com.baidu.tieba.a.e.forumfeed_frs_bg;
        linearLayout = this.b.m;
        linearLayout.setBackgroundResource(i);
    }

    public final void b() {
        LinearLayout linearLayout;
        this.a = true;
        int l = TbadkApplication.j().l();
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        a(l);
        linearLayout = this.b.m;
        linearLayout.setBackgroundColor(0);
    }

    public final void a(int i) {
        if (i == 1) {
            this.h.setBackgroundResource(com.baidu.tieba.a.e.forumfeed_frs_bg_1);
        } else if (this.a) {
            this.h.setBackgroundResource(com.baidu.tieba.a.e.forumfeed_frs_bg);
        }
    }
}
