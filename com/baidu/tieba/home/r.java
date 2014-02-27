package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.e {
    private Activity a;
    private View c;
    private LinearLayout d;
    private TextView e;
    private ImageView f;
    private Button g;
    private Button h;
    private int i;

    public r(Activity activity, String str, String str2, int i) {
        super(activity);
        this.i = -1;
        this.a = activity;
        this.c = LayoutInflater.from(activity).inflate(R.layout.enter_forum_login, (ViewGroup) null);
        this.d = (LinearLayout) this.c;
        this.e = (TextView) this.c.findViewById(R.id.tip);
        this.f = (ImageView) this.c.findViewById(R.id.img_bg);
        this.g = (Button) this.c.findViewById(R.id.login_btn);
        if (str != null) {
            this.e.setText(str);
        }
        this.g.setOnClickListener(new s(this, activity, i, str2));
        this.h = (Button) this.c.findViewById(R.id.reg_btn);
        this.h.setOnClickListener(new t(this, activity));
        int a = BdUtilHelper.a((Context) activity, 7.0f);
        int a2 = BdUtilHelper.a((Context) activity, 5.0f);
        this.d.setPadding(a, a2, a, a2);
    }

    public final View a() {
        cb.a(this.a, "home_login_show", "loginshow", 1, new Object[0]);
        return this.c;
    }

    public final void a(int i) {
        boolean z;
        if (i == this.i) {
            z = false;
        } else {
            this.i = i;
            z = true;
        }
        if (z) {
            if (i == 1) {
                this.e.setTextColor(-11444363);
                this.f.setBackgroundResource(R.drawable.pic_inset_login_1);
                this.g.setBackgroundResource(R.drawable.btn_blue_square_1);
                this.h.setBackgroundResource(R.drawable.btn_w_square_1);
                this.g.setTextColor(-5454368);
                this.h.setTextColor(-9207399);
                return;
            }
            this.e.setTextColor(-5065030);
            this.f.setBackgroundResource(R.drawable.pic_inset_login);
            this.g.setBackgroundResource(R.drawable.btn_blue_square);
            this.h.setBackgroundResource(R.drawable.btn_w_square);
            this.g.setTextColor(-1);
            this.h.setTextColor(-14277082);
        }
    }
}
