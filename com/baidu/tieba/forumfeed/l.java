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
public class l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1107a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private LinearLayout e;
    private Button f;
    private View g;
    private boolean h = false;

    public l(h hVar, Context context, View view) {
        this.f1107a = hVar;
        this.g = view;
        this.b = (TextView) view.findViewById(R.id.tip1);
        this.c = (TextView) view.findViewById(R.id.tip2);
        this.d = (ImageView) view.findViewById(R.id.nodata_img_bg);
        this.f = (Button) view.findViewById(R.id.btn_go);
        this.e = (LinearLayout) view.findViewById(R.id.layout_btn_go);
        this.f.setOnClickListener(new m(this, context));
    }

    public void a() {
        this.h = false;
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.g.setBackgroundColor(0);
    }

    public void b() {
        this.h = true;
        int ap = TiebaApplication.g().ap();
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        a(ap);
    }

    public void a(int i) {
        if (i == 1) {
            this.g.setBackgroundColor(-13618114);
        } else {
            this.g.setBackgroundColor(this.h ? -328966 : 0);
        }
    }
}
