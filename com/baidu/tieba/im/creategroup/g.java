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
    EditText eLR;
    private ImageButton eLS;
    private int eLT;
    CreateGroupStepActivity eLu;
    TbImageView eLv;
    private int mIndex;
    View mView;

    public EditText aPg() {
        return this.eLR;
    }

    public View aPh() {
        return this.eLS;
    }

    public void aPi() {
        this.eLR.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eLR);
    }

    public void in(boolean z) {
        if (z) {
            this.eLS.setVisibility(0);
        } else {
            this.eLS.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eLu = null;
        this.mView = null;
        this.eLv = null;
        this.eLR = null;
        this.eLS = null;
        this.eLu = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.eLR = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eLv = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.eLS = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.eLS.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OH = i2;
        this.eLT = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aOO() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eLu.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOU() {
        this.eLv.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOV() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eLu.getLayoutMode().setNightMode(z);
        this.eLu.getLayoutMode().onModeChanged(this.mView);
        this.eLv.startLoad(c.a(this.eLu.getPageContext().getPageActivity(), c.eLC, z), 29, false);
        this.eLR.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eLu.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aOX() {
        if (this.mIndex != this.eLT) {
            return this.eLu.getPageContext().getString(e.j.next_step);
        }
        return this.eLu.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOY() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eLu.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOZ() {
        return true;
    }
}
