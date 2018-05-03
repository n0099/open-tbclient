package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d implements o {
    private int FN;
    CreateGroupStepActivity dUc;
    TbImageView dUd;
    private int dUg;
    EditText dUm;
    TextView dUn;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUc = null;
        this.mView = null;
        this.dUd = null;
        this.dUm = null;
        this.dUn = null;
        this.dUc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step2_view, (ViewGroup) null);
        this.dUd = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.dUm = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.dUn = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.FN = i2;
        this.dUg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    public EditText aBK() {
        return this.dUm;
    }

    public TextView aBL() {
        return this.dUn;
    }

    public void nm(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.dUm.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hk(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.dUm.setText(a);
            this.dUm.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dUc.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dUm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUd.setBackgroundDrawable(null);
    }

    public void aBM() {
        this.dUc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dUc.getLayoutMode().u(this.dUn);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUc.getLayoutMode().setNightMode(z);
        this.dUc.getLayoutMode().u(this.mView);
        String a = c.a(this.dUc.getActivity(), c.dUi, z);
        this.dUm.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
        this.dUd.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUc.getPageContext().getString(d.k.group_create_step_intro), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUg) {
            return this.dUc.getPageContext().getString(d.k.next_step);
        }
        return this.dUc.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.dUc.getPageContext().getString(d.k.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
