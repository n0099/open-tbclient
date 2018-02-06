package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements p {
    private int avj;
    EditText ezU;
    private ImageButton ezV;
    private int ezW;
    CreateGroupStepActivity ezx;
    TbImageView ezy;
    private int mIndex;
    View mView;

    public EditText aGQ() {
        return this.ezU;
    }

    public View aGR() {
        return this.ezV;
    }

    public void aGS() {
        this.ezU.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezU);
    }

    public void hm(boolean z) {
        if (z) {
            this.ezV.setVisibility(0);
        } else {
            this.ezV.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezx = null;
        this.mView = null;
        this.ezy = null;
        this.ezU = null;
        this.ezV = null;
        this.ezx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.ezU = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.ezy = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.ezV = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.ezV.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.avj = i2;
        this.ezW = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezx.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezx.getLayoutMode().aQ(z);
        this.ezx.getLayoutMode().aM(this.mView);
        this.ezy.startLoad(c.a(this.ezx.getPageContext().getPageActivity(), c.ezF, z), 29, false);
        this.ezU.setHintTextColor(aj.getColor(d.C0140d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezx.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.avj));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezW) {
            return this.ezx.getPageContext().getString(d.j.next_step);
        }
        return this.ezx.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezx.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}
