package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1102a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f = -1;

    public aj(View view, int i, int i2) {
        this.d = i;
        this.e = i2;
        if (view != null) {
            this.f1102a = (LinearLayout) view.findViewById(R.id.no_data_container);
            this.b = (ImageView) view.findViewById(R.id.no_data_image);
            this.c = (TextView) view.findViewById(R.id.no_data_image_text);
        }
    }

    public aj(Activity activity, int i, int i2) {
        this.d = i;
        this.e = i2;
        this.f1102a = (LinearLayout) activity.findViewById(R.id.no_data_container);
        this.b = (ImageView) activity.findViewById(R.id.no_data_image);
        this.c = (TextView) activity.findViewById(R.id.no_data_image_text);
    }

    public void a(int i) {
        if (i != this.f) {
            this.f = i;
            if (i == 1) {
                this.b.setImageResource(this.e);
                this.c.setTextColor(bd.a(i));
                return;
            }
            this.b.setImageResource(this.d);
            this.c.setTextColor(-5065030);
        }
    }

    public void a() {
        a(TiebaApplication.g().ap());
    }

    public void b() {
        this.b.setImageDrawable(null);
        this.f = -1;
    }

    public void b(int i) {
        this.f1102a.setVisibility(i);
        if (i == 8) {
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
            this.f = -1;
            return;
        }
        this.b.setVisibility(0);
        a(TiebaApplication.g().ap());
    }

    public boolean c() {
        return this.f1102a.getVisibility() != 8;
    }
}
