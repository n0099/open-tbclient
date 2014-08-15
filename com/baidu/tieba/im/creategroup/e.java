package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    NavigationBar a;
    View b;
    Button c;
    Button d;
    TextView e;
    TextView f;
    CreateGroupMainActivity g;
    private int h;

    public int a() {
        return this.h;
    }

    public View b() {
        return this.c;
    }

    public View c() {
        return this.d;
    }

    public e(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.c.setOnClickListener(createGroupMainActivity);
        this.d.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.c.setEnabled(z2);
        this.d.setEnabled(z);
        this.e.setText(str2);
        this.f.setText(str);
        this.h = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.g = createGroupMainActivity;
        createGroupMainActivity.setContentView(com.baidu.tieba.v.create_group_main_activity);
        this.b = createGroupMainActivity.findViewById(com.baidu.tieba.u.parent);
        this.c = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.u.create_group1);
        this.d = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.u.create_group2);
        this.e = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.u.create_group1_text);
        this.f = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.u.create_group2_text);
        this.a = (NavigationBar) createGroupMainActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.a.a(createGroupMainActivity.getResources().getString(com.baidu.tieba.x.group_create));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void a(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.b);
        ay.a(this.b, i);
        this.a.c(i);
    }
}
