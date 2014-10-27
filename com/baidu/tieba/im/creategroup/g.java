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
    CreateGroupStepActivity aSP;
    TbImageView aSQ;
    EditText aTn;
    private ImageButton aTo;
    private int aTp;
    private int mIndex;
    View mView;
    private int vp;

    public EditText Lh() {
        return this.aTn;
    }

    public View Li() {
        return this.aTo;
    }

    public void Lj() {
        this.aTn.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.j.c(this.aTn);
    }

    public void cP(boolean z) {
        if (z) {
            this.aTo.setVisibility(0);
        } else {
            this.aTo.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aSP = null;
        this.mView = null;
        this.aSQ = null;
        this.aTn = null;
        this.aTo = null;
        this.aSP = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step1_view, null);
        this.aTn = (EditText) this.mView.findViewById(com.baidu.tieba.v.step1_group_name);
        this.aSQ = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step1_img_bg);
        this.aTo = (ImageButton) this.mView.findViewById(com.baidu.tieba.v.button_del);
        this.aTo.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.vp = i2;
        this.aTp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KP() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        TiebaStatic.eventStat(this.aSP, "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
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
        this.aSQ.c(c.a(this.aSP, c.aSY, z), 29, false);
        this.aTn.setHintTextColor(aw.getColor(com.baidu.tieba.s.create_group_input_hintcolor));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aSP.getString(com.baidu.tieba.y.group_create_step_name), Integer.valueOf(this.vp));
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String KY() {
        if (this.mIndex != this.aTp) {
            return this.aSP.getString(com.baidu.tieba.y.group_create_step_tip);
        }
        return this.aSP.getString(com.baidu.tieba.y.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean KZ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return this.aSP.getString(com.baidu.tieba.y.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean La() {
        return true;
    }
}
