package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    public boolean a = false;
    final /* synthetic */ j b;
    private final TextView c;
    private final TextView d;
    private final ImageView e;
    private final LinearLayout f;
    private final Button g;
    private final View h;

    public o(j jVar, Context context, View view) {
        this.b = jVar;
        this.h = view;
        this.c = (TextView) view.findViewById(v.tip1);
        this.d = (TextView) view.findViewById(v.tip2);
        this.e = (ImageView) view.findViewById(v.nodata_img_bg);
        this.g = (Button) view.findViewById(v.btn_go);
        this.f = (LinearLayout) view.findViewById(v.layout_btn_go);
        this.g.setOnClickListener(new p(this, context));
    }

    public void a() {
        LinearLayout linearLayout;
        this.a = false;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        int i = TbadkApplication.m252getInst().getSkinType() == 1 ? s.forumfeed_frs_bg_1 : s.forumfeed_frs_bg;
        linearLayout = this.b.l;
        linearLayout.setBackgroundResource(i);
    }

    public void b() {
        LinearLayout linearLayout;
        this.a = true;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        a(skinType);
        linearLayout = this.b.l;
        linearLayout.setBackgroundColor(0);
    }

    public void a(int i) {
        if (i == 1) {
            this.h.setBackgroundResource(s.forumfeed_frs_bg_1);
        } else if (this.a) {
            this.h.setBackgroundResource(s.forumfeed_frs_bg);
        }
    }
}
