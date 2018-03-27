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
    private int avb;
    private int eAa;
    CreateGroupStepActivity ezB;
    TbImageView ezC;
    EditText ezY;
    private ImageButton ezZ;
    private int mIndex;
    View mView;

    public EditText aGQ() {
        return this.ezY;
    }

    public View aGR() {
        return this.ezZ;
    }

    public void aGS() {
        this.ezY.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezY);
    }

    public void hr(boolean z) {
        if (z) {
            this.ezZ.setVisibility(0);
        } else {
            this.ezZ.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezB = null;
        this.mView = null;
        this.ezC = null;
        this.ezY = null;
        this.ezZ = null;
        this.ezB = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.ezY = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.ezC = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.ezZ = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.ezZ.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.avb = i2;
        this.eAa = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezB.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezC.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezB.getLayoutMode().aQ(z);
        this.ezB.getLayoutMode().aM(this.mView);
        this.ezC.startLoad(c.a(this.ezB.getPageContext().getPageActivity(), c.ezJ, z), 29, false);
        this.ezY.setHintTextColor(aj.getColor(d.C0141d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezB.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.avb));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.eAa) {
            return this.ezB.getPageContext().getString(d.j.next_step);
        }
        return this.ezB.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezB.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}
