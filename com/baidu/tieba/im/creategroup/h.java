package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class h implements x {
    CreateGroupStepActivity a;
    View b;
    HeadImageView c;
    ImageView d;
    TextView e;
    private com.baidu.adp.widget.a.a f = null;
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
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.v.create_group_step3_view, (ViewGroup) null);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.u.step3_img_bg);
        this.c = (HeadImageView) this.b.findViewById(com.baidu.tieba.u.step3_img_scr);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.u.create_group3);
        this.h = i;
        this.i = i2;
        this.j = i3;
    }

    public void c() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.f = null;
        this.g = new i(this, null);
        this.g.execute(new Object[0]);
    }

    public ImageView d() {
        return this.d;
    }

    public TextView e() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void h() {
        this.d.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void i() {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.b();
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String j() {
        return String.format(this.a.getString(com.baidu.tieba.x.group_create_step_photo), Integer.valueOf(this.i));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String k() {
        if (this.h != this.j) {
            return this.a.getString(com.baidu.tieba.x.group_create_step_tip);
        }
        return this.a.getString(com.baidu.tieba.x.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean l() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public int b() {
        return this.h;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String m() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean n() {
        return true;
    }
}
