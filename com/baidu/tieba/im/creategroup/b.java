package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class b implements x {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    TextView d;
    private ImageView f;
    private int h;
    private int i;
    private int j;
    private int e = 3;
    private boolean g = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.im.i.create_group_step4_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(com.baidu.tieba.im.h.step4_img_bg);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.im.h.txt_tip_view);
        this.f = (ImageView) this.b.findViewById(com.baidu.tieba.im.h.create_group_address_rightarrwow);
        this.h = i;
        this.i = i2;
        this.j = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final int b() {
        return this.h;
    }

    public final int c() {
        return this.e;
    }

    public final void d() {
        this.f.setVisibility(0);
        this.g = false;
        n();
        this.d.setText(com.baidu.tieba.im.j.address_locating);
        this.e = 3;
    }

    public final void a(String str) {
        this.f.setVisibility(0);
        this.g = true;
        n();
        this.d.setText(str);
        this.e = 0;
    }

    public final void b(String str) {
        this.f.setVisibility(8);
        this.g = true;
        n();
        this.d.setText(str);
        this.e = 4;
    }

    public final void e() {
        this.f.setVisibility(0);
        this.g = false;
        n();
        this.d.setText(com.baidu.tieba.im.j.address_locate_failed_opengps);
        this.e = 1;
    }

    public final void f() {
        this.g = false;
        n();
        this.d.setText(com.baidu.tieba.im.j.address_locate_failed_tryagain);
        this.f.setVisibility(8);
        this.e = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void g() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void h() {
        this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.a.getLayoutMode().a(this.b);
        n();
    }

    private void n() {
        if (TbadkApplication.j().l() == 1) {
            if (this.g) {
                Drawable drawable = this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_jq_lbs_s_1);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.d.setCompoundDrawables(drawable, null, null, null);
                this.d.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.im.e.name_text_color_1));
                return;
            }
            Drawable drawable2 = this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_jq_lbs_n_1);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.d.setCompoundDrawables(drawable2, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.im.e.listview_item_author_time_text_1));
        } else if (this.g) {
            Drawable drawable3 = this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_jq_lbs_s);
            drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
            this.d.setCompoundDrawables(drawable3, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.im.e.name_text_color));
        } else {
            Drawable drawable4 = this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_jq_lbs_n);
            drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
            this.d.setCompoundDrawables(drawable4, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.im.e.listview_item_author_time_text));
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String i() {
        return String.format(this.a.getString(com.baidu.tieba.im.j.group_create_step_address), Integer.valueOf(this.i));
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
    public final String l() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean m() {
        return true;
    }
}
