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
    private int Or;
    EditText evU;
    private ImageButton evV;
    private int evW;
    CreateGroupStepActivity evx;
    TbImageView evy;
    private int mIndex;
    View mView;

    public EditText aKC() {
        return this.evU;
    }

    public View aKD() {
        return this.evV;
    }

    public void aKE() {
        this.evU.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.evU);
    }

    public void hJ(boolean z) {
        if (z) {
            this.evV.setVisibility(0);
        } else {
            this.evV.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.evx = null;
        this.mView = null;
        this.evy = null;
        this.evU = null;
        this.evV = null;
        this.evx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.evU = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.evy = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.evV = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.evV.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Or = i2;
        this.evW = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aKk() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.evx.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKq() {
        this.evy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKr() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.evx.getLayoutMode().setNightMode(z);
        this.evx.getLayoutMode().onModeChanged(this.mView);
        this.evy.startLoad(c.a(this.evx.getPageContext().getPageActivity(), c.evF, z), 29, false);
        this.evU.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.evx.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.Or));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aKt() {
        if (this.mIndex != this.evW) {
            return this.evx.getPageContext().getString(e.j.next_step);
        }
        return this.evx.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKu() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.evx.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKv() {
        return true;
    }
}
