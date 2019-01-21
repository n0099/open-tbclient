package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d implements o {
    private int OT;
    CreateGroupStepActivity eOY;
    TbImageView eOZ;
    private int ePc;
    EditText ePi;
    TextView ePj;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOY = null;
        this.mView = null;
        this.eOZ = null;
        this.ePi = null;
        this.ePj = null;
        this.eOY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eOZ = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.ePi = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.ePj = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OT = i2;
        this.ePc = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    public EditText aQo() {
        return this.ePi;
    }

    public TextView aQp() {
        return this.ePj;
    }

    public void pV(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ePi.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.jc(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ePi.setText(a);
            this.ePi.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eOY.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ePi);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.eOZ.setBackgroundDrawable(null);
    }

    public void aQq() {
        this.eOY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOY.getLayoutMode().onModeChanged(this.ePj);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOY.getLayoutMode().setNightMode(z);
        this.eOY.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eOY.getActivity(), c.ePe, z);
        this.ePi.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eOZ.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOY.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePc) {
            return this.eOY.getPageContext().getString(e.j.next_step);
        }
        return this.eOY.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eOY.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return true;
    }
}
