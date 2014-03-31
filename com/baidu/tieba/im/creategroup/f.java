package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public final class f implements x {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    EditText d;
    private ImageButton e;
    private int f;
    private int g;
    private int h;

    public final View c() {
        return this.e;
    }

    public final void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public f(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.im.i.create_group_step1_view, (ViewGroup) null);
        this.d = (EditText) this.b.findViewById(com.baidu.tieba.im.h.step1_group_name);
        this.c = (ImageView) this.b.findViewById(com.baidu.tieba.im.h.step1_img_bg);
        this.e = (ImageButton) this.b.findViewById(com.baidu.tieba.im.h.button_del);
        this.e.setOnClickListener(createGroupStepActivity);
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final int b() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final View a() {
        TiebaStatic.a(this.a, "create_g_name", "pv", 1, new Object[0]);
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void g() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void h() {
        this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.a.getLayoutMode().a(this.b);
        if (TbadkApplication.j().l() == 1) {
            this.d.setHintTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.create_group_input_hintcolor_1));
        } else {
            this.d.setHintTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.create_group_input_hintcolor));
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String i() {
        return String.format(this.a.getString(com.baidu.tieba.im.j.group_create_step_name), Integer.valueOf(this.g));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String j() {
        if (this.f != this.h) {
            return this.a.getString(com.baidu.tieba.im.j.group_create_step_tip);
        }
        return this.a.getString(com.baidu.tieba.im.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean k() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String l() {
        return this.a.getString(com.baidu.tieba.im.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean m() {
        return true;
    }
}
