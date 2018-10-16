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
    EditText eDI;
    private ImageButton eDJ;
    private int eDK;
    CreateGroupStepActivity eDl;
    TbImageView eDm;
    private int mIndex;
    View mView;

    public EditText aNS() {
        return this.eDI;
    }

    public View aNT() {
        return this.eDJ;
    }

    public void aNU() {
        this.eDI.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eDI);
    }

    public void ib(boolean z) {
        if (z) {
            this.eDJ.setVisibility(0);
        } else {
            this.eDJ.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDl = null;
        this.mView = null;
        this.eDm = null;
        this.eDI = null;
        this.eDJ = null;
        this.eDl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.eDI = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eDm = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.eDJ = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.eDJ.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OG = i2;
        this.eDK = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eDl.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDm.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDl.getLayoutMode().setNightMode(z);
        this.eDl.getLayoutMode().onModeChanged(this.mView);
        this.eDm.startLoad(c.a(this.eDl.getPageContext().getPageActivity(), c.eDt, z), 29, false);
        this.eDI.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDl.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDK) {
            return this.eDl.getPageContext().getString(e.j.next_step);
        }
        return this.eDl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eDl.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
