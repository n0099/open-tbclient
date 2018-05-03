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
    private int FN;
    private ImageButton dUA;
    private int dUB;
    CreateGroupStepActivity dUc;
    TbImageView dUd;
    EditText dUz;
    private int mIndex;
    View mView;

    public EditText aBQ() {
        return this.dUz;
    }

    public View aBR() {
        return this.dUA;
    }

    public void aBS() {
        this.dUz.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dUz);
    }

    public void gR(boolean z) {
        if (z) {
            this.dUA.setVisibility(0);
        } else {
            this.dUA.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUc = null;
        this.mView = null;
        this.dUd = null;
        this.dUz = null;
        this.dUA = null;
        this.dUc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step1_view, (ViewGroup) null);
        this.dUz = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.dUd = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.dUA = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.dUA.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.FN = i2;
        this.dUB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dUc.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUc.getLayoutMode().setNightMode(z);
        this.dUc.getLayoutMode().u(this.mView);
        this.dUd.startLoad(c.a(this.dUc.getPageContext().getPageActivity(), c.dUk, z), 29, false);
        this.dUz.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUc.getPageContext().getString(d.k.group_create_step_name), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUB) {
            return this.dUc.getPageContext().getString(d.k.next_step);
        }
        return this.dUc.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.dUc.getPageContext().getString(d.k.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
