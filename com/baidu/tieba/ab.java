package com.baidu.tieba;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f860a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f = -1;

    public ab(Activity activity, int i, int i2) {
        this.d = i;
        this.e = i2;
        this.f860a = (LinearLayout) activity.findViewById(R.id.no_data_container);
        this.b = (ImageView) activity.findViewById(R.id.no_data_image);
        this.c = (TextView) activity.findViewById(R.id.no_data_image_text);
    }

    public void a(int i) {
        if (i != this.f) {
            this.f = i;
            if (i == 1) {
                this.b.setImageResource(this.e);
                this.c.setTextColor(com.baidu.tieba.util.ao.a(i));
                return;
            }
            this.b.setImageResource(this.d);
            this.c.setTextColor(-5065030);
        }
    }

    public void a() {
        a(TiebaApplication.g().an());
    }

    public void b() {
        this.b.setImageResource(0);
        this.f = -1;
    }

    public void b(int i) {
        this.f860a.setVisibility(i);
        if (i == 8) {
            this.b.setImageResource(0);
            this.f = -1;
            return;
        }
        a(TiebaApplication.g().an());
    }

    public boolean c() {
        return this.f860a.getVisibility() != 8;
    }
}
