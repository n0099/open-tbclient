package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g implements o {
    private int OH;
    CreateGroupStepActivity eEF;
    TbImageView eEG;
    EditText eFc;
    private ImageButton eFd;
    private int eFe;
    private int mIndex;
    View mView;

    public EditText aNp() {
        return this.eFc;
    }

    public View aNq() {
        return this.eFd;
    }

    public void aNr() {
        this.eFc.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eFc);
    }

    public void ik(boolean z) {
        if (z) {
            this.eFd.setVisibility(0);
        } else {
            this.eFd.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eEF = null;
        this.mView = null;
        this.eEG = null;
        this.eFc = null;
        this.eFd = null;
        this.eEF = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.eFc = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eEG = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.eFd = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.eFd.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OH = i2;
        this.eFe = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aMX() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eEF.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNd() {
        this.eEG.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNe() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eEF.getLayoutMode().setNightMode(z);
        this.eEF.getLayoutMode().onModeChanged(this.mView);
        this.eEG.startLoad(c.a(this.eEF.getPageContext().getPageActivity(), c.eEN, z), 29, false);
        this.eFc.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eEF.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNg() {
        if (this.mIndex != this.eFe) {
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
        return this.eEF.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNi() {
        return true;
    }
}
