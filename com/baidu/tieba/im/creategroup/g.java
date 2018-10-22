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
    private int OG;
    EditText eDJ;
    private ImageButton eDK;
    private int eDL;
    CreateGroupStepActivity eDm;
    TbImageView eDn;
    private int mIndex;
    View mView;

    public EditText aNS() {
        return this.eDJ;
    }

    public View aNT() {
        return this.eDK;
    }

    public void aNU() {
        this.eDJ.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eDJ);
    }

    public void ib(boolean z) {
        if (z) {
            this.eDK.setVisibility(0);
        } else {
            this.eDK.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDm = null;
        this.mView = null;
        this.eDn = null;
        this.eDJ = null;
        this.eDK = null;
        this.eDm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.eDJ = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eDn = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.eDK = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.eDK.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OG = i2;
        this.eDL = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eDm.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDm.getLayoutMode().setNightMode(z);
        this.eDm.getLayoutMode().onModeChanged(this.mView);
        this.eDn.startLoad(c.a(this.eDm.getPageContext().getPageActivity(), c.eDu, z), 29, false);
        this.eDJ.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDm.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDL) {
            return this.eDm.getPageContext().getString(e.j.next_step);
        }
        return this.eDm.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eDm.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
