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
    EditText dUC;
    private ImageButton dUD;
    private int dUE;
    CreateGroupStepActivity dUf;
    TbImageView dUg;
    private int mIndex;
    View mView;

    public EditText aBQ() {
        return this.dUC;
    }

    public View aBR() {
        return this.dUD;
    }

    public void aBS() {
        this.dUC.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.dUC);
    }

    public void gR(boolean z) {
        if (z) {
            this.dUD.setVisibility(0);
        } else {
            this.dUD.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUf = null;
        this.mView = null;
        this.dUg = null;
        this.dUC = null;
        this.dUD = null;
        this.dUf = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step1_view, (ViewGroup) null);
        this.dUC = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.dUg = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.dUD = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.dUD.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.FN = i2;
        this.dUE = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.dUf.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUg.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUf.getLayoutMode().setNightMode(z);
        this.dUf.getLayoutMode().u(this.mView);
        this.dUg.startLoad(c.a(this.dUf.getPageContext().getPageActivity(), c.dUn, z), 29, false);
        this.dUC.setHintTextColor(ak.getColor(d.C0126d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dUf.getPageContext().getString(d.k.group_create_step_name), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUE) {
            return this.dUf.getPageContext().getString(d.k.next_step);
        }
        return this.dUf.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.dUf.getPageContext().getString(d.k.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
