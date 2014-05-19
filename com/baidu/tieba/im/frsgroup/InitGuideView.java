package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes.dex */
public class InitGuideView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private Button d;
    private int e;

    public InitGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        a(context);
    }

    public InitGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        a(context);
    }

    public InitGuideView(Context context) {
        super(context);
        this.e = -1;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.s.im_frsgroup_guide, (ViewGroup) null));
        this.a = (ImageView) findViewById(com.baidu.tieba.r.guide_img);
        this.b = (TextView) findViewById(com.baidu.tieba.r.guide_tip1);
        this.c = (TextView) findViewById(com.baidu.tieba.r.guide_tip2);
    }

    private void setSkinType(int i) {
        this.e = i;
    }

    private int getSkinType() {
        return this.e;
    }

    private boolean b(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a() {
        setVisibility(8);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void a(int i) {
        if (b(i)) {
            if (i == 1) {
                this.a.setBackgroundResource(com.baidu.tieba.q.pic_go_ba_1);
                this.b.setTextColor(-8815226);
                this.c.setTextColor(-8815226);
                if (this.d != null) {
                    this.d.setBackgroundResource(com.baidu.tieba.q.btn_blue_square_1);
                    this.d.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.o.c_acc5e0));
                    return;
                }
                return;
            }
            this.a.setBackgroundResource(com.baidu.tieba.q.pic_go_ba);
            this.b.setTextColor(-5065030);
            this.c.setTextColor(-5065030);
            if (this.d != null) {
                this.d.setBackgroundResource(com.baidu.tieba.q.btn_blue_square);
                this.d.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.o.white));
            }
        }
    }

    public void c() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.u.frsgroup_no_recommend_tip);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void a(GroupPermData groupPermData) {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.u.frsgroup_no_hot_tip);
        if (groupPermData != null && this.d != null) {
            this.d.setText(com.baidu.tieba.u.frsgroup_hot_create_group);
            this.d.setVisibility(0);
        }
    }

    public void b(GroupPermData groupPermData) {
        setVisibility(0);
        if (groupPermData != null && groupPermData.isManager()) {
            getTip1().setVisibility(4);
            getTip2().setVisibility(0);
            getTip2().setText(com.baidu.tieba.u.frsgroup_office_no_tip1_owner);
            if (this.d != null) {
                this.d.setText(com.baidu.tieba.u.frsgroup_official_create_group);
                this.d.setVisibility(0);
                return;
            }
            return;
        }
        getTip1().setVisibility(0);
        getTip2().setVisibility(0);
        getTip1().setText(com.baidu.tieba.u.frsgroup_office_no_tip1_leaguer);
        getTip2().setText(com.baidu.tieba.u.frsgroup_office_no_tip2_leaguer);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void d() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.u.members_no_person);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public TextView getTip1() {
        return this.b;
    }

    public TextView getTip2() {
        return this.c;
    }

    public Button getCreateButton() {
        return this.d;
    }

    public void setCreateButton(Button button) {
        this.d = button;
    }

    public void e() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void f() {
        e();
    }

    public void g() {
        this.e = -1;
        this.a.setBackgroundDrawable(null);
    }
}
