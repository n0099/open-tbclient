package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f {
    private View a;
    private NavigationBar b;
    private View c;
    private EditText d;
    private ImageButton e;
    private ProgressBar f;
    private Button g;
    private AddGroupActivity h;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.h = addGroupActivity;
        e();
    }

    public View a() {
        return this.e;
    }

    public View b() {
        return this.g;
    }

    public View c() {
        return this.c;
    }

    public void d() {
        if (this.d != null) {
            this.d.setText("");
        }
    }

    public void a(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }

    public void a(int i) {
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.a);
        this.b.c(i);
    }

    private void e() {
        this.h.setContentView(w.im_add_group_activity);
        this.a = this.h.findViewById(v.addgroup_rootlayout);
        this.b = (NavigationBar) this.h.findViewById(v.addgroup_navigationbar);
        this.c = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(this.h.getResources().getString(y.add_group_title_main));
        this.d = (EditText) this.h.findViewById(v.addgroup_input);
        this.d.setInputType(2);
        this.e = (ImageButton) this.h.findViewById(v.addgroup_delbtn);
        this.g = (Button) this.h.findViewById(v.addgroup_searchbutton);
        this.d.addTextChangedListener(new c(this));
        this.g = (Button) this.h.findViewById(v.addgroup_searchbutton);
        this.f = (ProgressBar) this.h.findViewById(v.addgroup_progress);
        this.c.setOnClickListener(this.h);
        this.e.setOnClickListener(this.h);
        this.g.setOnClickListener(this.h);
    }
}
