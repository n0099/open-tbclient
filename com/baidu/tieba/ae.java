package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f934a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f = -1;

    public ae(View view, int i, int i2) {
        this.d = i;
        this.e = i2;
        if (view != null) {
            this.f934a = (LinearLayout) view.findViewById(R.id.no_data_container);
            this.b = (ImageView) view.findViewById(R.id.no_data_image);
            this.c = (TextView) view.findViewById(R.id.no_data_image_text);
        }
    }

    public ae(Activity activity, int i, int i2) {
        this.d = i;
        this.e = i2;
        this.f934a = (LinearLayout) activity.findViewById(R.id.no_data_container);
        this.b = (ImageView) activity.findViewById(R.id.no_data_image);
        this.c = (TextView) activity.findViewById(R.id.no_data_image_text);
    }

    public void a(int i) {
        if (i != this.f) {
            this.f = i;
            if (i == 1) {
                this.b.setImageResource(this.e);
                this.c.setTextColor(com.baidu.tieba.util.as.a(i));
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
        this.b.setImageResource(0);
        this.f = -1;
    }

    public void b(int i) {
        this.f934a.setVisibility(i);
        if (i == 8) {
            this.b.setImageResource(0);
            this.f = -1;
            return;
        }
        a(TiebaApplication.g().ap());
    }

    public boolean c() {
        return this.f934a.getVisibility() != 8;
    }
}
