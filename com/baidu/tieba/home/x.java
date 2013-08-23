package com.baidu.tieba.home;

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
public class x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1198a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private LinearLayout e;
    private Button f;
    private View g;
    private boolean h = false;

    public x(s sVar, Context context, View view) {
        this.f1198a = sVar;
        this.g = view;
        this.b = (TextView) view.findViewById(R.id.tip1);
        this.c = (TextView) view.findViewById(R.id.tip2);
        this.d = (ImageView) view.findViewById(R.id.nodata_img_bg);
        this.f = (Button) view.findViewById(R.id.btn_go);
        this.e = (LinearLayout) view.findViewById(R.id.layout_btn_go);
        this.f.setOnClickListener(new y(this, context));
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
        int an = TiebaApplication.g().an();
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        a(an);
    }

    public void a(int i) {
        if (i == 1) {
            this.g.setBackgroundColor(-13618114);
            this.b.setTextColor(-8815226);
            this.c.setTextColor(-8815226);
            this.f.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.f.setTextColor(-5454368);
            this.d.setBackgroundResource(R.drawable.pic_go_ba_1);
            return;
        }
        this.g.setBackgroundColor(this.h ? -328966 : 0);
        this.b.setTextColor(-7367785);
        this.c.setTextColor(-7367785);
        this.f.setBackgroundResource(R.drawable.btn_blue_square);
        this.f.setTextColor(-1);
        this.d.setBackgroundResource(R.drawable.pic_go_ba);
    }
}
