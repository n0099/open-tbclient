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
    CreateGroupStepActivity dUf;
    TbImageView dUg;
    private int dUj;
    EditText dUp;
    TextView dUq;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUf = null;
        this.mView = null;
        this.dUg = null;
        this.dUp = null;
        this.dUq = null;
        this.dUf = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step2_view, (ViewGroup) null);
        this.dUg = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.dUp = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.dUq = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.FN = i2;
        this.dUj = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    public EditText aBK() {
        return this.dUp;
    }

    public TextView aBL() {
        return this.dUq;
    }

    public void nm(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.dUp.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hk(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.dUp.setText(a);
            this.dUp.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dUf.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dUp);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUg.setBackgroundDrawable(null);
    }

    public void aBM() {
        this.dUf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dUf.getLayoutMode().u(this.dUq);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUf.getLayoutMode().setNightMode(z);
        this.dUf.getLayoutMode().u(this.mView);
        String a = c.a(this.dUf.getActivity(), c.dUl, z);
        this.dUp.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
        this.dUg.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUf.getPageContext().getString(d.k.group_create_step_intro), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUj) {
            return this.dUf.getPageContext().getString(d.k.next_step);
        }
        return this.dUf.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.dUf.getPageContext().getString(d.k.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
