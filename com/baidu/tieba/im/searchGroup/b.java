package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private View f1873a;
    private NavigationBar c;
    private ImageView d;
    private EditText e;
    private ImageButton f;
    private ProgressBar g;
    private Button h;
    private AddGroupActivity i;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity);
        this.f1873a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.i = addGroupActivity;
        h();
    }

    public View a() {
        return this.f;
    }

    public View e() {
        return this.h;
    }

    public View f() {
        return this.d;
    }

    public void g() {
        if (this.e != null) {
            this.e.setText("");
        }
    }

    public void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public void a(int i) {
        this.i.getLayoutMode().a(i == 1);
        this.i.getLayoutMode().a(this.f1873a);
        ba.b(this.f1873a, i);
        this.c.c(i);
        if (i == 1) {
            this.f1873a.setBackgroundResource(R.color.im_add_group_page_backgroundcolor_1);
        } else {
            this.f1873a.setBackgroundResource(R.color.im_add_group_page_backgroundcolor);
        }
    }

    private void h() {
        this.i.setContentView(R.layout.im_add_group_activity);
        this.f1873a = this.i.findViewById(R.id.addgroup_rootlayout);
        this.c = (NavigationBar) this.i.findViewById(R.id.addgroup_navigationbar);
        this.c.a(this.i.getResources().getString(R.string.add_group_title_main));
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (EditText) this.i.findViewById(R.id.addgroup_input);
        this.e.setInputType(2);
        this.f = (ImageButton) this.i.findViewById(R.id.addgroup_delbtn);
        this.h = (Button) this.i.findViewById(R.id.addgroup_searchbutton);
        this.e.addTextChangedListener(new c(this));
        this.h = (Button) this.i.findViewById(R.id.addgroup_searchbutton);
        this.g = (ProgressBar) this.i.findViewById(R.id.addgroup_progress);
        this.d.setOnClickListener(this.i);
        this.f.setOnClickListener(this.i);
        this.h.setOnClickListener(this.i);
    }
}
