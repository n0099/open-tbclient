package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements o {
    private int FJ;
    EditText dVG;
    private ImageButton dVH;
    private int dVI;
    CreateGroupStepActivity dVj;
    TbImageView dVk;
    private int mIndex;
    View mView;

    public EditText aBO() {
        return this.dVG;
    }

    public View aBP() {
        return this.dVH;
    }

    public void aBQ() {
        this.dVG.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dVG);
    }

    public void gS(boolean z) {
        if (z) {
            this.dVH.setVisibility(0);
        } else {
            this.dVH.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dVj = null;
        this.mView = null;
        this.dVk = null;
        this.dVG = null;
        this.dVH = null;
        this.dVj = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step1_view, (ViewGroup) null);
        this.dVG = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.dVk = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.dVH = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.dVH.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.FJ = i2;
        this.dVI = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dVj.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBC() {
        this.dVk.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dVj.getLayoutMode().setNightMode(z);
        this.dVj.getLayoutMode().u(this.mView);
        this.dVk.startLoad(c.a(this.dVj.getPageContext().getPageActivity(), c.dVr, z), 29, false);
        this.dVG.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dVj.getPageContext().getString(d.k.group_create_step_name), Integer.valueOf(this.FJ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBF() {
        if (this.mIndex != this.dVI) {
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
        return this.dVj.getPageContext().getString(d.k.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBH() {
        return true;
    }
}
