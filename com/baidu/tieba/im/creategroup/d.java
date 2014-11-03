package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class d implements y {
    CreateGroupStepActivity aTd;
    TbImageView aTe;
    private int aTi;
    EditText aTo;
    TextView aTp;
    private int mIndex;
    View mView;
    private int vp;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aTd = null;
        this.mView = null;
        this.aTe = null;
        this.aTo = null;
        this.aTp = null;
        this.aTd = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step2_view, null);
        this.aTe = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step2_img_bg);
        this.aTo = (EditText) this.mView.findViewById(com.baidu.tieba.v.step2_group_info);
        this.aTp = (TextView) this.mView.findViewById(com.baidu.tieba.v.step2_group_info_count);
        this.mIndex = i;
        this.vp = i2;
        this.aTi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KT() {
        return this.mIndex;
    }

    public EditText Lf() {
        return this.aTo;
    }

    public TextView Lg() {
        return this.aTp;
    }

    public void ft(int i) {
        String a;
        if (getLength() > i && (a = com.baidu.adp.lib.util.l.a(this.aTo.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.j.fy(a) > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.aTo.setText(a);
            this.aTo.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        TiebaStatic.eventStat(this.aTd, "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.j.c(this.aTo);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KZ() {
        this.aTe.setBackgroundDrawable(null);
    }

    public void Lh() {
        this.aTd.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aTd.getLayoutMode().h(this.aTp);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void La() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aTd.getLayoutMode().L(z);
        this.aTd.getLayoutMode().h(this.mView);
        String a = c.a(this.aTd, c.aTk, z);
        this.aTo.setHintTextColor(aw.getColor(com.baidu.tieba.s.create_group_input_hintcolor));
        this.aTe.c(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aTd.getString(com.baidu.tieba.y.group_create_step_intro), Integer.valueOf(this.vp));
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
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return this.aTd.getString(com.baidu.tieba.y.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean Le() {
        return true;
    }
}
