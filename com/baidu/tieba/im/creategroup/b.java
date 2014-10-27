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
    CreateGroupStepActivity aSP;
    TbImageView aSQ;
    TextView aSR;
    private ImageView aSS;
    private int aSU;
    private int mIndex;
    View mView;
    private int vp;
    private int aSO = 3;
    private boolean aST = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aSP = null;
        this.mView = null;
        this.aSQ = null;
        this.aSR = null;
        this.aSS = null;
        this.aSP = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step4_view, null);
        this.aSQ = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step4_img_bg);
        this.aSR = (TextView) this.mView.findViewById(com.baidu.tieba.v.txt_tip_view);
        this.aSS = (ImageView) this.mView.findViewById(com.baidu.tieba.v.create_group_address_rightarrwow);
        this.mIndex = i;
        this.vp = i2;
        this.aSU = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KP() {
        return this.mIndex;
    }

    public View KQ() {
        return this.aSR;
    }

    public int KR() {
        return this.aSO;
    }

    public void KS() {
        this.aSS.setVisibility(0);
        this.aST = false;
        KX();
        this.aSR.setText(com.baidu.tieba.y.address_locating);
        this.aSO = 3;
    }

    public void setBusiness(String str) {
        this.aSS.setVisibility(0);
        this.aST = true;
        KX();
        this.aSR.setText(str);
        this.aSO = 0;
    }

    public void setAddress(String str) {
        this.aSS.setVisibility(8);
        this.aST = true;
        KX();
        this.aSR.setText(str);
        this.aSO = 4;
    }

    public void KT() {
        this.aSS.setVisibility(0);
        this.aST = false;
        KX();
        this.aSR.setText(com.baidu.tieba.y.address_locate_failed_opengps);
        this.aSO = 1;
    }

    public void KU() {
        this.aST = false;
        KX();
        this.aSR.setText(com.baidu.tieba.y.address_locate_failed_tryagain);
        this.aSS.setVisibility(8);
        this.aSO = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KV() {
        this.aSQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KW() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aSP.getLayoutMode().L(z);
        this.aSP.getLayoutMode().h(this.mView);
        this.aSQ.c(c.a(this.aSP, c.aSV, z), 29, false);
        KX();
    }

    private void KX() {
        if (this.aST) {
            Drawable drawable = aw.getDrawable(com.baidu.tieba.u.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.aSR.setCompoundDrawables(drawable, null, null, null);
            aw.b(this.aSR, com.baidu.tieba.s.name_text_color, 1);
            return;
        }
        Drawable drawable2 = aw.getDrawable(com.baidu.tieba.u.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.aSR.setCompoundDrawables(drawable2, null, null, null);
        aw.b(this.aSR, com.baidu.tieba.s.listview_item_author_time_text, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aSP.getString(com.baidu.tieba.y.group_create_step_address), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String KY() {
        if (this.mIndex != this.aSU) {
            return this.aSP.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aSP.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean KZ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean La() {
        return true;
    }
}
