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
    CreateGroupStepActivity aSP;
    TbImageView aSQ;
    private int aSU;
    EditText aTa;
    TextView aTb;
    private int mIndex;
    View mView;
    private int vp;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.aSP = null;
        this.mView = null;
        this.aSQ = null;
        this.aTa = null;
        this.aTb = null;
        this.aSP = createGroupStepActivity;
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(createGroupStepActivity, com.baidu.tieba.w.create_group_step2_view, null);
        this.aSQ = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.step2_img_bg);
        this.aTa = (EditText) this.mView.findViewById(com.baidu.tieba.v.step2_group_info);
        this.aTb = (TextView) this.mView.findViewById(com.baidu.tieba.v.step2_group_info_count);
        this.mIndex = i;
        this.vp = i2;
        this.aSU = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public int KP() {
        return this.mIndex;
    }

    public EditText Lb() {
        return this.aTa;
    }

    public TextView Lc() {
        return this.aTb;
    }

    public void ft(int i) {
        String a;
        if (getLength() > i && (a = com.baidu.adp.lib.util.l.a(this.aTa.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.j.fy(a) > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.aTa.setText(a);
            this.aTa.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public View getView() {
        TiebaStatic.eventStat(this.aSP, "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.j.c(this.aTa);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KV() {
        this.aSQ.setBackgroundDrawable(null);
    }

    public void Ld() {
        this.aSP.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aSP.getLayoutMode().h(this.aTb);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public void KW() {
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        this.aSP.getLayoutMode().L(z);
        this.aSP.getLayoutMode().h(this.mView);
        String a = c.a(this.aSP, c.aSW, z);
        this.aTa.setHintTextColor(aw.getColor(com.baidu.tieba.s.create_group_input_hintcolor));
        this.aSQ.c(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getTitle() {
        return String.format(this.aSP.getString(com.baidu.tieba.y.group_create_step_intro), Integer.valueOf(this.vp));
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
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public String getErrMsg() {
        return this.aSP.getString(com.baidu.tieba.y.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.y
    public boolean La() {
        return true;
    }
}
