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
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1463a;
    private View c;
    private LinearLayout d;
    private TextView e;
    private ImageView f;
    private Button g;
    private Button h;
    private int i;

    public void a(int i) {
        this.i = i;
    }

    public int a() {
        return this.i;
    }

    public s(Activity activity, String str, String str2, int i) {
        super(activity);
        this.i = -1;
        this.f1463a = activity;
        this.c = LayoutInflater.from(activity).inflate(R.layout.enter_forum_login, (ViewGroup) null);
        this.d = (LinearLayout) this.c;
        this.e = (TextView) this.c.findViewById(R.id.tip);
        this.f = (ImageView) this.c.findViewById(R.id.img_bg);
        this.g = (Button) this.c.findViewById(R.id.login_btn);
        if (str != null) {
            this.e.setText(str);
        }
        this.g.setOnClickListener(new t(this, activity, i, str2));
        this.h = (Button) this.c.findViewById(R.id.reg_btn);
        this.h.setOnClickListener(new u(this, activity));
        int a2 = UtilHelper.a((Context) activity, 7.0f);
        int a3 = UtilHelper.a((Context) activity, 5.0f);
        this.d.setPadding(a2, a3, a2, a3);
    }

    public View e() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1463a, "home_login_show", "loginshow", 1);
        }
        return this.c;
    }

    private boolean c(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }

    public void b(int i) {
        if (c(i)) {
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
