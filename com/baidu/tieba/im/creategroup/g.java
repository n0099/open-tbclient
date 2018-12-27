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
    private int OH;
    EditText eOI;
    private ImageButton eOJ;
    private int eOK;
    CreateGroupStepActivity eOl;
    TbImageView eOm;
    private int mIndex;
    View mView;

    public EditText aPU() {
        return this.eOI;
    }

    public View aPV() {
        return this.eOJ;
    }

    public void aPW() {
        this.eOI.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eOI);
    }

    public void iq(boolean z) {
        if (z) {
            this.eOJ.setVisibility(0);
        } else {
            this.eOJ.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOl = null;
        this.mView = null;
        this.eOm = null;
        this.eOI = null;
        this.eOJ = null;
        this.eOl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step1_view, (ViewGroup) null);
        this.eOI = (EditText) this.mView.findViewById(e.g.step1_group_name);
        this.eOm = (TbImageView) this.mView.findViewById(e.g.step1_img_bg);
        this.eOJ = (ImageButton) this.mView.findViewById(e.g.button_del);
        this.eOJ.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.OH = i2;
        this.eOK = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aPC() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eOl.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPI() {
        this.eOm.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aPJ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOl.getLayoutMode().setNightMode(z);
        this.eOl.getLayoutMode().onModeChanged(this.mView);
        this.eOm.startLoad(c.a(this.eOl.getPageContext().getPageActivity(), c.eOt, z), 29, false);
        this.eOI.setHintTextColor(al.getColor(e.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOl.getPageContext().getString(e.j.group_create_step_name), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aPL() {
        if (this.mIndex != this.eOK) {
            return this.eOl.getPageContext().getString(e.j.next_step);
        }
        return this.eOl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPM() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eOl.getPageContext().getString(e.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPN() {
        return true;
    }
}
