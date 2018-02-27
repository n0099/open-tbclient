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
    private int ava;
    EditText ezI;
    private ImageButton ezJ;
    private int ezK;
    CreateGroupStepActivity ezl;
    TbImageView ezm;
    private int mIndex;
    View mView;

    public EditText aGP() {
        return this.ezI;
    }

    public View aGQ() {
        return this.ezJ;
    }

    public void aGR() {
        this.ezI.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezI);
    }

    public void hm(boolean z) {
        if (z) {
            this.ezJ.setVisibility(0);
        } else {
            this.ezJ.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezl = null;
        this.mView = null;
        this.ezm = null;
        this.ezI = null;
        this.ezJ = null;
        this.ezl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.ezI = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.ezm = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.ezJ = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.ezJ.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.ava = i2;
        this.ezK = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGx() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezl.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGD() {
        this.ezm.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezl.getLayoutMode().aQ(z);
        this.ezl.getLayoutMode().aM(this.mView);
        this.ezm.startLoad(c.a(this.ezl.getPageContext().getPageActivity(), c.ezt, z), 29, false);
        this.ezI.setHintTextColor(aj.getColor(d.C0141d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezl.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.ava));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGG() {
        if (this.mIndex != this.ezK) {
            return this.ezl.getPageContext().getString(d.j.next_step);
        }
        return this.ezl.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGH() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezl.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }
}
