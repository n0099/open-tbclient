package com.baidu.tieba.e;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n {
    public boolean a = false;
    final /* synthetic */ i b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private LinearLayout f;
    private Button g;
    private View h;

    public n(i iVar, Context context, View view) {
        this.b = iVar;
        this.h = view;
        this.c = (TextView) view.findViewById(R.id.tip1);
        this.d = (TextView) view.findViewById(R.id.tip2);
        this.e = (ImageView) view.findViewById(R.id.nodata_img_bg);
        this.g = (Button) view.findViewById(R.id.btn_go);
        this.f = (LinearLayout) view.findViewById(R.id.layout_btn_go);
        this.g.setOnClickListener(new o(this, context));
    }

    public final void a() {
        LinearLayout linearLayout;
        this.a = false;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        int i = TiebaApplication.g().ae() == 1 ? R.color.forumfeed_frs_bg_1 : R.color.forumfeed_frs_bg;
        linearLayout = this.b.n;
        linearLayout.setBackgroundResource(i);
    }

    public final void b() {
        LinearLayout linearLayout;
        this.a = true;
        int ae = TiebaApplication.g().ae();
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        a(ae);
        linearLayout = this.b.n;
        linearLayout.setBackgroundColor(0);
    }

    public final void a(int i) {
        if (i == 1) {
            this.h.setBackgroundResource(R.color.forumfeed_frs_bg_1);
        } else if (this.a) {
            this.h.setBackgroundResource(R.color.forumfeed_frs_bg);
        }
    }
}
