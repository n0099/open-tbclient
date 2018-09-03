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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class g implements o {
    private int LQ;
    EditText eoB;
    private ImageButton eoC;
    private int eoD;
    CreateGroupStepActivity eod;
    TbImageView eoe;
    private int mIndex;
    View mView;

    public EditText aIn() {
        return this.eoB;
    }

    public View aIo() {
        return this.eoC;
    }

    public void aIp() {
        this.eoB.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eoB);
    }

    public void hl(boolean z) {
        if (z) {
            this.eoC.setVisibility(0);
        } else {
            this.eoC.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eod = null;
        this.mView = null;
        this.eoe = null;
        this.eoB = null;
        this.eoC = null;
        this.eod = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(f.h.create_group_step1_view, (ViewGroup) null);
        this.eoB = (EditText) this.mView.findViewById(f.g.step1_group_name);
        this.eoe = (TbImageView) this.mView.findViewById(f.g.step1_img_bg);
        this.eoC = (ImageButton) this.mView.findViewById(f.g.button_del);
        this.eoC.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.LQ = i2;
        this.eoD = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eod.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIb() {
        this.eoe.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eod.getLayoutMode().setNightMode(z);
        this.eod.getLayoutMode().onModeChanged(this.mView);
        this.eoe.startLoad(c.a(this.eod.getPageContext().getPageActivity(), c.eom, z), 29, false);
        this.eoB.setHintTextColor(am.getColor(f.d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eod.getPageContext().getString(f.j.group_create_step_name), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIe() {
        if (this.mIndex != this.eoD) {
            return this.eod.getPageContext().getString(f.j.next_step);
        }
        return this.eod.getPageContext().getString(f.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eod.getPageContext().getString(f.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIg() {
        return true;
    }
}
