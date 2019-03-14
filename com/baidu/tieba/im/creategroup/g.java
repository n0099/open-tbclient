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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class g implements o {
    private int Pl;
    private int gfA;
    CreateGroupStepActivity gfb;
    TbImageView gfc;
    EditText gfy;
    private ImageButton gfz;
    private int mIndex;
    View mView;

    public EditText bqZ() {
        return this.gfy;
    }

    public View bra() {
        return this.gfz;
    }

    public void brb() {
        this.gfy.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gfy);
    }

    public void kQ(boolean z) {
        if (z) {
            this.gfz.setVisibility(0);
        } else {
            this.gfz.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gfb = null;
        this.mView = null;
        this.gfc = null;
        this.gfy = null;
        this.gfz = null;
        this.gfb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.gfy = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.gfc = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.gfz = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.gfz.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Pl = i2;
        this.gfA = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqH() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gfb.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqN() {
        this.gfc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqO() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gfb.getLayoutMode().setNightMode(z);
        this.gfb.getLayoutMode().onModeChanged(this.mView);
        this.gfc.startLoad(c.a(this.gfb.getPageContext().getPageActivity(), c.gfj, z), 29, false);
        this.gfy.setHintTextColor(al.getColor(d.C0277d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gfb.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqQ() {
        if (this.mIndex != this.gfA) {
            return this.gfb.getPageContext().getString(d.j.next_step);
        }
        return this.gfb.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqR() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gfb.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqS() {
        return true;
    }
}
