package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    NavigationBar f1582a;
    View c;
    Button d;
    Button e;
    TextView f;
    TextView g;
    CreateGroupMainActivity h;
    private int i;

    public int a() {
        return this.i;
    }

    public View e() {
        return this.d;
    }

    public View f() {
        return this.e;
    }

    public b(CreateGroupMainActivity createGroupMainActivity) {
        super(createGroupMainActivity);
        this.f1582a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        b(createGroupMainActivity);
        a(createGroupMainActivity);
    }

    private void a(CreateGroupMainActivity createGroupMainActivity) {
        this.d.setOnClickListener(createGroupMainActivity);
        this.e.setOnClickListener(createGroupMainActivity);
    }

    public void a(boolean z, boolean z2, String str, String str2, int i) {
        this.d.setEnabled(z2);
        this.e.setEnabled(z);
        this.f.setText(str2);
        this.g.setText(str);
        this.i = i;
    }

    private void b(CreateGroupMainActivity createGroupMainActivity) {
        this.h = createGroupMainActivity;
        createGroupMainActivity.setContentView(R.layout.create_group_main_activity);
        this.c = createGroupMainActivity.findViewById(R.id.parent);
        this.d = (Button) createGroupMainActivity.findViewById(R.id.create_group1);
        this.e = (Button) createGroupMainActivity.findViewById(R.id.create_group2);
        this.f = (TextView) createGroupMainActivity.findViewById(R.id.create_group1_text);
        this.g = (TextView) createGroupMainActivity.findViewById(R.id.create_group2_text);
        this.f1582a = (NavigationBar) createGroupMainActivity.findViewById(R.id.view_navigation_bar);
        this.f1582a.a(createGroupMainActivity.getResources().getString(R.string.group_create));
        this.f1582a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public void a(int i) {
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.c);
        bd.a(this.c, i);
        this.f1582a.c(i);
    }
}
