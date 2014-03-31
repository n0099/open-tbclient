package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public final class h implements x {
    CreateGroupStepActivity a;
    View b;
    HeadImageView c;
    ImageView d;
    Button e;
    private com.baidu.adp.widget.ImageView.b f = null;
    private i g = null;
    private int h;
    private int i;
    private int j;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.im.i.create_group_step3_view, (ViewGroup) null);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.im.h.step3_img_bg);
        this.c = (HeadImageView) this.b.findViewById(com.baidu.tieba.im.h.step3_img_scr);
        this.e = (Button) this.b.findViewById(com.baidu.tieba.im.h.create_group3);
        this.h = i;
        this.i = i2;
        this.j = i3;
    }

    public final void c() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.f = null;
        this.g = new i(this, (byte) 0);
        this.g.execute(new Object[0]);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void g() {
        this.d.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void h() {
        this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.c();
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String i() {
        return String.format(this.a.getString(com.baidu.tieba.im.j.group_create_step_photo), Integer.valueOf(this.i));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String j() {
        if (this.h != this.j) {
            return this.a.getString(com.baidu.tieba.im.j.group_create_step_tip);
        }
        return this.a.getString(com.baidu.tieba.im.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean k() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final int b() {
        return this.h;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String l() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean m() {
        return true;
    }
}
