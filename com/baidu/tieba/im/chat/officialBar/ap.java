package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public final class ap extends com.baidu.adp.a.f {
    private com.baidu.tbadk.a a;
    private View c;
    private NavigationBar d;
    private HeadImageView e;
    private TextView f;
    private TextView g;
    private SettingTextSwitchView h;
    private RelativeLayout i;
    private RelativeLayout j;
    private Button k;

    public ap(com.baidu.tbadk.a aVar) {
        super(aVar);
        this.a = aVar;
        this.c = View.inflate(this.a, com.baidu.tieba.im.i.official_bar_info_activity, null);
        this.a.setContentView(this.c);
        this.d = (NavigationBar) this.c.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(com.baidu.tieba.im.j.officical_bar_info_title);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (HeadImageView) this.c.findViewById(com.baidu.tieba.im.h.bar_img);
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.im.h.bar_name);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.im.h.bar_authen_content);
        this.h = (SettingTextSwitchView) this.c.findViewById(com.baidu.tieba.im.h.bar_notify);
        this.i = (RelativeLayout) this.c.findViewById(com.baidu.tieba.im.h.bar_info_clean_lay);
        this.j = (RelativeLayout) this.c.findViewById(com.baidu.tieba.im.h.bar_info_history_lay);
        this.k = (Button) this.c.findViewById(com.baidu.tieba.im.h.bar_info_goto_btn);
    }

    public final void a(boolean z) {
        if (z) {
            this.h.b();
        } else {
            this.h.a();
        }
    }

    public final RelativeLayout a() {
        return this.i;
    }

    public final RelativeLayout d() {
        return this.j;
    }

    public final Button e() {
        return this.k;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    public final void a(String str) {
        this.g.setText(str);
    }

    public final void b(String str) {
        String str2 = String.valueOf(str) + this.a.getString(com.baidu.tieba.im.j.bar);
        this.f.setText(str2);
        this.k.setText(String.valueOf(this.a.getString(com.baidu.tieba.im.j.visit)) + str2);
    }

    public final void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.h.setSwitchStateChangeListener(cVar);
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
        this.d.b(i);
        this.h.a(i);
    }
}
