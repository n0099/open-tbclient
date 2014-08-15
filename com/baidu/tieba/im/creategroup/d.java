package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class d implements x {
    private CreateGroupStepActivity a;
    private int b;
    private View c;
    private ImageView d;
    private Button e;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.a = createGroupStepActivity;
        this.c = createGroupStepActivity.getLayoutInflater().inflate(com.baidu.tieba.v.create_group_lbs_tips, (ViewGroup) null);
        this.e = (Button) this.c.findViewById(com.baidu.tieba.u.create_group_tips_btn);
        this.d = (ImageView) this.c.findViewById(com.baidu.tieba.u.create_group_tips_image);
        this.b = i;
        this.e.setText(String.format(createGroupStepActivity.getString(com.baidu.tieba.x.group_create_can_create_num), Integer.valueOf(i2)));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void h() {
        this.d.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public void i() {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(this.c);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public View a() {
        return this.c;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public int b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String j() {
        return this.a.getString(com.baidu.tieba.x.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String k() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean l() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public String m() {
        return null;
    }

    public Button c() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public boolean n() {
        return false;
    }
}
