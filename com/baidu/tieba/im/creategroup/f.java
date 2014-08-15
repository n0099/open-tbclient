package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class f implements x {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    EditText d;
    private ImageButton e;
    private int f;
    private int g;
    private int h;

    public EditText c() {
        return this.d;
    }

    public View d() {
        return this.e;
    }

    public void e() {
        this.d.setText("");
    }

    public int f() {
        return com.baidu.tieba.im.d.l.b(this.d);
    }

    public void a(boolean z) {
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
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.v.create_group_step1_view, (ViewGroup) null);
        this.d = (EditText) this.b.findViewById(com.baidu.tieba.u.step1_group_name);
        this.c = (ImageView) this.b.findViewById(com.baidu.tieba.u.step1_img_bg);
        this.e = (ImageButton) this.b.findViewById(com.baidu.tieba.u.button_del);
        this.e.setOnClickListener(createGroupStepActivity);
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public int b() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public View a() {
        TiebaStatic.eventStat(this.a, "create_g_name", "pv", 1, new Object[0]);
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void h() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void i() {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(this.b);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.d.setHintTextColor(this.a.getResources().getColor(com.baidu.tieba.r.create_group_input_hintcolor_1));
        } else {
            this.d.setHintTextColor(this.a.getResources().getColor(com.baidu.tieba.r.create_group_input_hintcolor));
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String j() {
        return String.format(this.a.getString(com.baidu.tieba.x.group_create_step_name), Integer.valueOf(this.g));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String k() {
        if (this.f != this.h) {
            return this.a.getString(com.baidu.tieba.x.group_create_step_tip);
        }
        return this.a.getString(com.baidu.tieba.x.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean l() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String m() {
        return this.a.getString(com.baidu.tieba.x.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean n() {
        return true;
    }
}
