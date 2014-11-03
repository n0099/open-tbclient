package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class g implements y {
    EditText aTB;
    private ImageButton aTC;
    private int aTD;
    CreateGroupStepActivity aTd;
    TbImageView aTe;
    private int mIndex;
    View mView;
    private int vp;

    public EditText Ll() {
        return this.aTB;
    }

    public View Lm() {
        return this.aTC;
    }

    public void Ln() {
        this.aTB.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.j.c(this.aTB);
    }

    public void cP(boolean z) {
        if (z) {
            this.aTC.setVisibility(0);
        } else {
            this.aTC.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aTd = null;
        this.mView = null;
        this.aTe = null;
        this.aTB = null;
        this.aTC = null;
        this.aTd = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step1_view, null);
        this.aTB = (EditText) this.mView.findViewById(com.baidu.tieba.v.step1_group_name);
        this.aTe = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step1_img_bg);
        this.aTC = (ImageButton) this.mView.findViewById(com.baidu.tieba.v.button_del);
        this.aTC.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.vp = i2;
        this.aTD = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KT() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        TiebaStatic.eventStat(this.aTd, "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
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
        this.aTe.c(c.a(this.aTd, c.aTm, z), 29, false);
        this.aTB.setHintTextColor(aw.getColor(com.baidu.tieba.s.create_group_input_hintcolor));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aTd.getString(com.baidu.tieba.y.group_create_step_name), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String Lc() {
        if (this.mIndex != this.aTD) {
            return this.aTd.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aTd.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Ld() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return this.aTd.getString(com.baidu.tieba.y.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Le() {
        return true;
    }
}
