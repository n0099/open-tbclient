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
    CreateGroupStepActivity eEF;
    TbImageView eEG;
    private int eEJ;
    EditText eEP;
    TextView eEQ;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eEF = null;
        this.mView = null;
        this.eEG = null;
        this.eEP = null;
        this.eEQ = null;
        this.eEF = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eEG = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.eEP = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.eEQ = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OH = i2;
        this.eEJ = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aMX() {
        return this.mIndex;
    }

    public EditText aNj() {
        return this.eEP;
    }

    public TextView aNk() {
        return this.eEQ;
    }

    public void pm(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eEP.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.it(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eEP.setText(a);
            this.eEP.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eEF.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eEP);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNd() {
        this.eEG.setBackgroundDrawable(null);
    }

    public void aNl() {
        this.eEF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eEF.getLayoutMode().onModeChanged(this.eEQ);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNe() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eEF.getLayoutMode().setNightMode(z);
        this.eEF.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eEF.getActivity(), c.eEL, z);
        this.eEP.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eEG.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eEF.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNg() {
        if (this.mIndex != this.eEJ) {
            return this.eEF.getPageContext().getString(e.j.next_step);
        }
        return this.eEF.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNh() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eEF.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNi() {
        return true;
    }
}
