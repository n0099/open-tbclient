package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class aj {
    private LinearLayout a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private int f;

    public aj(View view, int i, int i2) {
        this.f = -1;
        this.d = i;
        this.e = i2;
        if (view != null) {
            this.a = (LinearLayout) view.findViewById(R.id.no_data_container);
            this.b = (ImageView) view.findViewById(R.id.no_data_image);
            this.c = (TextView) view.findViewById(R.id.no_data_image_text);
        }
    }

    public aj(Activity activity, int i, int i2) {
        this.f = -1;
        this.d = R.drawable.individual_center_like;
        this.e = R.drawable.individual_center_like_1;
        this.a = (LinearLayout) activity.findViewById(R.id.no_data_container);
        this.b = (ImageView) activity.findViewById(R.id.no_data_image);
        this.c = (TextView) activity.findViewById(R.id.no_data_image_text);
    }

    public final void a(int i) {
        if (i != this.f) {
            this.f = i;
            if (i == 1) {
                this.b.setImageResource(this.e);
                this.c.setTextColor(bq.a(i));
                return;
            }
            this.b.setImageResource(this.d);
            this.c.setTextColor(-5065030);
        }
    }

    public final void a() {
        a(TiebaApplication.g().ae());
    }

    public final void b() {
        this.b.setImageDrawable(null);
        this.f = -1;
    }

    public final void b(int i) {
        this.a.setVisibility(i);
        if (i == 8) {
            this.b.setImageDrawable(null);
            this.b.setVisibility(8);
            this.f = -1;
            return;
        }
        this.b.setVisibility(0);
        a(TiebaApplication.g().ae());
    }

    public final boolean c() {
        return this.a.getVisibility() != 8;
    }
}
