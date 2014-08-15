package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.f {
    private BaseActivity a;
    private View b;
    private NavigationBar c;
    private BarImageView d;
    private TextView e;
    private TextView f;
    private SettingTextSwitchView g;
    private RelativeLayout h;
    private RelativeLayout i;
    private Button j;

    public am(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = baseActivity;
        d();
    }

    private void d() {
        this.b = View.inflate(this.a, com.baidu.tieba.v.official_bar_info_activity, null);
        this.a.setContentView(this.b);
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(com.baidu.tieba.x.officical_bar_info_title);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (BarImageView) this.b.findViewById(com.baidu.tieba.u.bar_img);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.u.bar_name);
        this.f = (TextView) this.b.findViewById(com.baidu.tieba.u.bar_authen_content);
        this.g = (SettingTextSwitchView) this.b.findViewById(com.baidu.tieba.u.bar_notify);
        this.h = (RelativeLayout) this.b.findViewById(com.baidu.tieba.u.bar_info_clean_lay);
        this.i = (RelativeLayout) this.b.findViewById(com.baidu.tieba.u.bar_info_history_lay);
        this.j = (Button) this.b.findViewById(com.baidu.tieba.u.bar_info_goto_btn);
    }

    public void a(boolean z) {
        if (z) {
            this.g.b();
        } else {
            this.g.a();
        }
    }

    public RelativeLayout a() {
        return this.h;
    }

    public RelativeLayout b() {
        return this.i;
    }

    public Button c() {
        return this.j;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.f.setText(str);
    }

    public void b(String str) {
        String str2 = String.valueOf(str) + this.a.getString(com.baidu.tieba.x.bar);
        this.e.setText(str2);
        this.j.setText(String.valueOf(this.a.getString(com.baidu.tieba.x.visit)) + str2);
    }

    public void c(String str) {
        this.d.a(str, 10, false);
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.g.setSwitchStateChangeListener(cVar);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.c(i);
        this.g.a(i);
    }
}
