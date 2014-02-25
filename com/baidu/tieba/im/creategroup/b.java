package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b implements x {
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
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.step4_img_bg);
        this.d = (TextView) this.b.findViewById(R.id.txt_tip_view);
        this.f = (ImageView) this.b.findViewById(R.id.create_group_address_rightarrwow);
        this.h = i;
        this.i = i2;
        this.j = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public int b() {
        return this.h;
    }

    public View c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public void e() {
        this.f.setVisibility(0);
        this.g = false;
        o();
        this.d.setText(R.string.address_locating);
        this.e = 3;
    }

    public void a(String str) {
        this.f.setVisibility(0);
        this.g = true;
        o();
        this.d.setText(str);
        this.e = 0;
    }

    public void b(String str) {
        this.f.setVisibility(8);
        this.g = true;
        o();
        this.d.setText(str);
        this.e = 4;
    }

    public void f() {
        this.f.setVisibility(0);
        this.g = false;
        o();
        this.d.setText(R.string.address_locate_failed_opengps);
        this.e = 1;
    }

    public void g() {
        this.g = false;
        o();
        this.d.setText(R.string.address_locate_failed_tryagain);
        this.f.setVisibility(8);
        this.e = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void h() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void i() {
        this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
        this.a.getLayoutMode().a(this.b);
        o();
    }

    private void o() {
        if (TiebaApplication.g().al() == 1) {
            if (this.g) {
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.icon_jq_lbs_s_1);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.d.setCompoundDrawables(drawable, null, null, null);
                this.d.setTextColor(this.a.getResources().getColorStateList(R.color.name_text_color_1));
                return;
            }
            Drawable drawable2 = this.a.getResources().getDrawable(R.drawable.icon_jq_lbs_n_1);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.d.setCompoundDrawables(drawable2, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(R.color.listview_item_author_time_text_1));
        } else if (this.g) {
            Drawable drawable3 = this.a.getResources().getDrawable(R.drawable.icon_jq_lbs_s);
            drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
            this.d.setCompoundDrawables(drawable3, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(R.color.name_text_color));
        } else {
            Drawable drawable4 = this.a.getResources().getDrawable(R.drawable.icon_jq_lbs_n);
            drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
            this.d.setCompoundDrawables(drawable4, null, null, null);
            this.d.setTextColor(this.a.getResources().getColorStateList(R.color.listview_item_author_time_text));
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String j() {
        return String.format(this.a.getString(R.string.group_create_step_address), Integer.valueOf(this.i));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String k() {
        if (this.h != this.j) {
            return this.a.getString(R.string.group_create_step_tip);
        }
        return this.a.getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean l() {
        return true;
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
