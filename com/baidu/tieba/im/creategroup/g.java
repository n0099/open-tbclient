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
    private int OT;
    CreateGroupStepActivity eOX;
    TbImageView eOY;
    EditText ePu;
    private ImageButton ePv;
    private int ePw;
    private int mIndex;
    View mView;

    public EditText aQu() {
        return this.ePu;
    }

    public View aQv() {
        return this.ePv;
    }

    public void aQw() {
        this.ePu.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ePu);
    }

    public void iq(boolean z) {
        if (z) {
            this.ePv.setVisibility(0);
        } else {
            this.ePv.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOX = null;
        this.mView = null;
        this.eOY = null;
        this.ePu = null;
        this.ePv = null;
        this.eOX = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.ePu = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eOY = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.ePv = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.ePv.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OT = i2;
        this.ePw = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eOX.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.eOY.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOX.getLayoutMode().setNightMode(z);
        this.eOX.getLayoutMode().onModeChanged(this.mView);
        this.eOY.startLoad(c.a(this.eOX.getPageContext().getPageActivity(), c.ePf, z), 29, false);
        this.ePu.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOX.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePw) {
            return this.eOX.getPageContext().getString(e.j.next_step);
        }
        return this.eOX.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eOX.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return true;
    }
}
