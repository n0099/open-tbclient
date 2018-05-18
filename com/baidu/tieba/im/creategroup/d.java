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
    private int FJ;
    CreateGroupStepActivity dVj;
    TbImageView dVk;
    private int dVn;
    EditText dVt;
    TextView dVu;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dVj = null;
        this.mView = null;
        this.dVk = null;
        this.dVt = null;
        this.dVu = null;
        this.dVj = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step2_view, (ViewGroup) null);
        this.dVk = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.dVt = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.dVu = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.FJ = i2;
        this.dVn = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBw() {
        return this.mIndex;
    }

    public EditText aBI() {
        return this.dVt;
    }

    public TextView aBJ() {
        return this.dVu;
    }

    public void nl(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.dVt.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hl(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.dVt.setText(a);
            this.dVt.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dVj.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dVt);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBC() {
        this.dVk.setBackgroundDrawable(null);
    }

    public void aBK() {
        this.dVj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dVj.getLayoutMode().u(this.dVu);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dVj.getLayoutMode().setNightMode(z);
        this.dVj.getLayoutMode().u(this.mView);
        String a = c.a(this.dVj.getActivity(), c.dVp, z);
        this.dVt.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
        this.dVk.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dVj.getPageContext().getString(d.k.group_create_step_intro), Integer.valueOf(this.FJ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBF() {
        if (this.mIndex != this.dVn) {
            return this.dVj.getPageContext().getString(d.k.next_step);
        }
        return this.dVj.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBG() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.dVj.getPageContext().getString(d.k.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBH() {
        return true;
    }
}
