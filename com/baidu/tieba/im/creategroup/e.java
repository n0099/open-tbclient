package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.a.f {
    NavigationBar a;
    View c;
    Button d;
    Button e;
    TextView f;
    TextView g;
    CreateGroupMainActivity h;
    private int i;

    public final int a() {
        return this.i;
    }

    public e(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.h = createGroupMainActivity;
        createGroupMainActivity.setContentView(com.baidu.tieba.im.i.create_group_main_activity);
        this.c = createGroupMainActivity.findViewById(com.baidu.tieba.im.h.parent);
        this.d = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.im.h.create_group1);
        this.e = (Button) createGroupMainActivity.findViewById(com.baidu.tieba.im.h.create_group2);
        this.f = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.im.h.create_group1_text);
        this.g = (TextView) createGroupMainActivity.findViewById(com.baidu.tieba.im.h.create_group2_text);
        this.a = (NavigationBar) createGroupMainActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.a.a(createGroupMainActivity.getResources().getString(com.baidu.tieba.im.j.group_create));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setOnClickListener(createGroupMainActivity);
        this.e.setOnClickListener(createGroupMainActivity);
    }

    public final void a(boolean z, boolean z2, String str, String str2, int i) {
        this.d.setEnabled(z2);
        this.e.setEnabled(z);
        this.f.setText(str2);
        this.g.setText(str);
        this.i = i;
    }
}
