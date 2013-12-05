package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b implements v {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1619a;
    View b;
    ImageView c;
    TextView d;
    private ImageView f;
    private int e = 3;
    private boolean g = false;

    public b(CreateGroupStepActivity createGroupStepActivity) {
        this.f1619a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.f1619a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.step4_img_bg);
        this.d = (TextView) this.b.findViewById(R.id.txt_tip_view);
        this.f = (ImageView) this.b.findViewById(R.id.create_group_address_rightarrwow);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public View a() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int b() {
        return 4;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int c() {
        return R.string.group_create_step_done_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int d() {
        return R.string.group_create_step4;
    }

    public View e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public void g() {
        this.f.setVisibility(0);
        this.g = false;
        l();
        this.d.setText(R.string.address_locating);
        this.e = 3;
    }

    public void a(String str) {
        this.f.setVisibility(0);
        this.g = true;
        l();
        this.d.setText(str);
        this.e = 0;
    }

    public void b(String str) {
        this.f.setVisibility(8);
        this.g = true;
        l();
        this.d.setText(str);
        this.e = 4;
    }

    public void h() {
        this.f.setVisibility(0);
        this.g = false;
        l();
        this.d.setText(R.string.address_locate_failed_opengps);
        this.e = 1;
    }

    public void i() {
        this.g = false;
        l();
        this.d.setText(R.string.address_locate_failed_tryagain);
        this.f.setVisibility(8);
        this.e = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void j() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void k() {
        this.f1619a.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.f1619a.getLayoutMode().a(this.b);
        l();
    }

    private void l() {
        if (TiebaApplication.h().an() == 1) {
            if (this.g) {
                Drawable drawable = this.f1619a.getResources().getDrawable(R.drawable.icon_jq_lbs_s_1);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.d.setCompoundDrawables(drawable, null, null, null);
                this.d.setTextColor(this.f1619a.getResources().getColorStateList(R.color.name_text_color_1));
                return;
            }
            Drawable drawable2 = this.f1619a.getResources().getDrawable(R.drawable.icon_jq_lbs_n_1);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.d.setCompoundDrawables(drawable2, null, null, null);
            this.d.setTextColor(this.f1619a.getResources().getColorStateList(R.color.listview_item_author_time_text_1));
        } else if (this.g) {
            Drawable drawable3 = this.f1619a.getResources().getDrawable(R.drawable.icon_jq_lbs_s);
            drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
            this.d.setCompoundDrawables(drawable3, null, null, null);
            this.d.setTextColor(this.f1619a.getResources().getColorStateList(R.color.name_text_color));
        } else {
            Drawable drawable4 = this.f1619a.getResources().getDrawable(R.drawable.icon_jq_lbs_n);
            drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
            this.d.setCompoundDrawables(drawable4, null, null, null);
            this.d.setTextColor(this.f1619a.getResources().getColorStateList(R.color.listview_item_author_time_text));
        }
    }
}
