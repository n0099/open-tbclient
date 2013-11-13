package com.baidu.tieba.forumfeed;

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
public class n {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1298a = false;
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
        this.g.setOnClickListener(new o(this, iVar, context));
    }

    public void a() {
        LinearLayout linearLayout;
        this.f1298a = false;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        int i = TiebaApplication.g().ap() == 1 ? R.color.forumfeed_frs_bg_1 : R.color.forumfeed_frs_bg;
        linearLayout = this.b.n;
        linearLayout.setBackgroundResource(i);
    }

    public void b() {
        LinearLayout linearLayout;
        this.f1298a = true;
        int ap = TiebaApplication.g().ap();
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        a(ap);
        linearLayout = this.b.n;
        linearLayout.setBackgroundColor(0);
    }

    public void a(int i) {
        if (i == 1) {
            this.h.setBackgroundResource(R.color.forumfeed_frs_bg_1);
        } else if (this.f1298a) {
            this.h.setBackgroundResource(R.color.forumfeed_frs_bg);
        }
    }
}
