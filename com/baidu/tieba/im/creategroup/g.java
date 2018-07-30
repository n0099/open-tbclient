package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements o {
    private int LQ;
    EditText eoF;
    private ImageButton eoG;
    private int eoH;
    CreateGroupStepActivity eoi;
    TbImageView eoj;
    private int mIndex;
    View mView;

    public EditText aIq() {
        return this.eoF;
    }

    public View aIr() {
        return this.eoG;
    }

    public void aIs() {
        this.eoF.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eoF);
    }

    public void hl(boolean z) {
        if (z) {
            this.eoG.setVisibility(0);
        } else {
            this.eoG.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eoi = null;
        this.mView = null;
        this.eoj = null;
        this.eoF = null;
        this.eoG = null;
        this.eoi = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.eoF = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.eoj = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.eoG = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.eoG.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.LQ = i2;
        this.eoH = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eoi.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIe() {
        this.eoj.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eoi.getLayoutMode().setNightMode(z);
        this.eoi.getLayoutMode().onModeChanged(this.mView);
        this.eoj.startLoad(c.a(this.eoi.getPageContext().getPageActivity(), c.eoq, z), 29, false);
        this.eoF.setHintTextColor(am.getColor(d.C0140d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eoi.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIh() {
        if (this.mIndex != this.eoH) {
            return this.eoi.getPageContext().getString(d.j.next_step);
        }
        return this.eoi.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eoi.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIj() {
        return true;
    }
}
