package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class b implements y {
    CreateGroupStepActivity aTd;
    TbImageView aTe;
    TextView aTf;
    private ImageView aTg;
    private int aTi;
    private int mIndex;
    View mView;
    private int vp;
    private int aTc = 3;
    private boolean aTh = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aTd = null;
        this.mView = null;
        this.aTe = null;
        this.aTf = null;
        this.aTg = null;
        this.aTd = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step4_view, null);
        this.aTe = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step4_img_bg);
        this.aTf = (TextView) this.mView.findViewById(com.baidu.tieba.v.txt_tip_view);
        this.aTg = (ImageView) this.mView.findViewById(com.baidu.tieba.v.create_group_address_rightarrwow);
        this.mIndex = i;
        this.vp = i2;
        this.aTi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KT() {
        return this.mIndex;
    }

    public View KU() {
        return this.aTf;
    }

    public int KV() {
        return this.aTc;
    }

    public void KW() {
        this.aTg.setVisibility(0);
        this.aTh = false;
        Lb();
        this.aTf.setText(com.baidu.tieba.y.address_locating);
        this.aTc = 3;
    }

    public void setBusiness(String str) {
        this.aTg.setVisibility(0);
        this.aTh = true;
        Lb();
        this.aTf.setText(str);
        this.aTc = 0;
    }

    public void setAddress(String str) {
        this.aTg.setVisibility(8);
        this.aTh = true;
        Lb();
        this.aTf.setText(str);
        this.aTc = 4;
    }

    public void KX() {
        this.aTg.setVisibility(0);
        this.aTh = false;
        Lb();
        this.aTf.setText(com.baidu.tieba.y.address_locate_failed_opengps);
        this.aTc = 1;
    }

    public void KY() {
        this.aTh = false;
        Lb();
        this.aTf.setText(com.baidu.tieba.y.address_locate_failed_tryagain);
        this.aTg.setVisibility(8);
        this.aTc = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KZ() {
        this.aTe.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void La() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aTd.getLayoutMode().L(z);
        this.aTd.getLayoutMode().h(this.mView);
        this.aTe.c(c.a(this.aTd, c.aTj, z), 29, false);
        Lb();
    }

    private void Lb() {
        if (this.aTh) {
            Drawable drawable = aw.getDrawable(com.baidu.tieba.u.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.aTf.setCompoundDrawables(drawable, null, null, null);
            aw.b(this.aTf, com.baidu.tieba.s.name_text_color, 1);
            return;
        }
        Drawable drawable2 = aw.getDrawable(com.baidu.tieba.u.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.aTf.setCompoundDrawables(drawable2, null, null, null);
        aw.b(this.aTf, com.baidu.tieba.s.listview_item_author_time_text, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aTd.getString(com.baidu.tieba.y.group_create_step_address), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String Lc() {
        if (this.mIndex != this.aTi) {
            return this.aTd.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aTd.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Ld() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Le() {
        return true;
    }
}
