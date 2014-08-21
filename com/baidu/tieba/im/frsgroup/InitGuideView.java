package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.util.AttributeSet;
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
        addView(com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.im_frsgroup_guide, null));
        this.a = (ImageView) findViewById(com.baidu.tieba.u.guide_img);
        this.b = (TextView) findViewById(com.baidu.tieba.u.guide_tip1);
        this.c = (TextView) findViewById(com.baidu.tieba.u.guide_tip2);
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
                this.a.setBackgroundResource(com.baidu.tieba.t.pic_emotion03_1);
                this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
                this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                if (this.d != null) {
                    this.d.setBackgroundResource(com.baidu.tieba.t.btn_appdownload_1);
                    this.d.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.r.c_acc5e0));
                    return;
                }
                return;
            }
            this.a.setBackgroundResource(com.baidu.tieba.t.pic_emotion03);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_b));
            if (this.d != null) {
                this.d.setBackgroundResource(com.baidu.tieba.t.btn_appdownload);
                this.d.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.r.white));
            }
        }
    }

    public void c() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.x.frsgroup_no_recommend_tip);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void a(GroupPermData groupPermData) {
        setVisibility(0);
        getTip1().setText(com.baidu.tieba.x.frsgroup_no_hot_tip);
        getTip2().setText(com.baidu.tieba.x.frsgroup_hot_create_group_tip);
        if (groupPermData != null && this.d != null) {
            this.d.setText(com.baidu.tieba.x.frsgroup_hot_create_group);
            this.d.setVisibility(0);
        }
    }

    public void b(GroupPermData groupPermData) {
        setVisibility(0);
        if (groupPermData != null && groupPermData.isManager()) {
            getTip1().setVisibility(4);
            getTip2().setVisibility(0);
            getTip2().setText(com.baidu.tieba.x.frsgroup_office_no_tip1_owner);
            if (this.d != null) {
                this.d.setText(com.baidu.tieba.x.frsgroup_official_create_group);
                this.d.setVisibility(0);
                return;
            }
            return;
        }
        getTip1().setVisibility(0);
        getTip2().setVisibility(0);
        getTip1().setText(com.baidu.tieba.x.frsgroup_office_no_tip1_leaguer);
        getTip2().setText(com.baidu.tieba.x.frsgroup_office_no_tip2_leaguer);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void d() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.x.members_no_person);
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
