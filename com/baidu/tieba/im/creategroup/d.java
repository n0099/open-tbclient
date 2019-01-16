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
    CreateGroupStepActivity eOX;
    TbImageView eOY;
    private int ePb;
    EditText ePh;
    TextView ePi;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOX = null;
        this.mView = null;
        this.eOY = null;
        this.ePh = null;
        this.ePi = null;
        this.eOX = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eOY = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.ePh = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.ePi = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OT = i2;
        this.ePb = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    public EditText aQo() {
        return this.ePh;
    }

    public TextView aQp() {
        return this.ePi;
    }

    public void pV(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ePh.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.jc(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ePh.setText(a);
            this.ePh.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eOX.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ePh);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.eOY.setBackgroundDrawable(null);
    }

    public void aQq() {
        this.eOX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOX.getLayoutMode().onModeChanged(this.ePi);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOX.getLayoutMode().setNightMode(z);
        this.eOX.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eOX.getActivity(), c.ePd, z);
        this.ePh.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eOY.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOX.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePb) {
            return this.eOX.getPageContext().getString(e.j.next_step);
        }
        return this.eOX.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eOX.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return true;
    }
}
