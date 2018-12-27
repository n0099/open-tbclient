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
    private int OH;
    CreateGroupStepActivity eOl;
    TbImageView eOm;
    private int eOp;
    EditText eOv;
    TextView eOw;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOl = null;
        this.mView = null;
        this.eOm = null;
        this.eOv = null;
        this.eOw = null;
        this.eOl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eOm = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.eOv = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.eOw = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OH = i2;
        this.eOp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aPC() {
        return this.mIndex;
    }

    public EditText aPO() {
        return this.eOv;
    }

    public TextView aPP() {
        return this.eOw;
    }

    public void pU(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eOv.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.iM(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eOv.setText(a);
            this.eOv.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eOl.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eOv);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPI() {
        this.eOm.setBackgroundDrawable(null);
    }

    public void aPQ() {
        this.eOl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOl.getLayoutMode().onModeChanged(this.eOw);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPJ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOl.getLayoutMode().setNightMode(z);
        this.eOl.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eOl.getActivity(), c.eOr, z);
        this.eOv.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eOm.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOl.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aPL() {
        if (this.mIndex != this.eOp) {
            return this.eOl.getPageContext().getString(e.j.next_step);
        }
        return this.eOl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPM() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eOl.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPN() {
        return true;
    }
}
