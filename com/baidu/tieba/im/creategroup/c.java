package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class c implements x {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    EditText d;
    TextView e;
    private int f;
    private int g;
    private int h;

    public c(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.v.create_group_step2_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(com.baidu.tieba.u.step2_img_bg);
        this.d = (EditText) this.b.findViewById(com.baidu.tieba.u.step2_group_info);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.u.step2_group_info_count);
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public int b() {
        return this.f;
    }

    public EditText c() {
        return this.d;
    }

    public TextView d() {
        return this.e;
    }

    public void a(int i) {
        String a;
        if (e() > i && (a = com.baidu.adp.lib.util.i.a(this.d.getText(), (String) null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.d.l.a(a) > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.d.setText(a);
            this.d.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public View a() {
        TiebaStatic.eventStat(this.a, "create_g_intro", "pv", 1, new Object[0]);
        return this.b;
    }

    public int e() {
        return com.baidu.tieba.im.d.l.b(this.d);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void h() {
        this.c.setBackgroundDrawable(null);
    }

    public void f() {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(this.e);
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
        return String.format(this.a.getString(com.baidu.tieba.x.group_create_step_intro), Integer.valueOf(this.g));
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
        return this.a.getString(com.baidu.tieba.x.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean n() {
        return true;
    }
}
