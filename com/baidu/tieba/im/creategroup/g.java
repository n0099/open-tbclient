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
    private int LV;
    EditText ekM;
    private ImageButton ekN;
    private int ekO;
    CreateGroupStepActivity ekp;
    TbImageView ekq;
    private int mIndex;
    View mView;

    public EditText aHq() {
        return this.ekM;
    }

    public View aHr() {
        return this.ekN;
    }

    public void aHs() {
        this.ekM.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ekM);
    }

    public void hi(boolean z) {
        if (z) {
            this.ekN.setVisibility(0);
        } else {
            this.ekN.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ekp = null;
        this.mView = null;
        this.ekq = null;
        this.ekM = null;
        this.ekN = null;
        this.ekp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step1_view, (ViewGroup) null);
        this.ekM = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.ekq = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.ekN = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.ekN.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.LV = i2;
        this.ekO = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ekp.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHe() {
        this.ekq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ekp.getLayoutMode().setNightMode(z);
        this.ekp.getLayoutMode().onModeChanged(this.mView);
        this.ekq.startLoad(c.a(this.ekp.getPageContext().getPageActivity(), c.ekx, z), 29, false);
        this.ekM.setHintTextColor(am.getColor(d.C0142d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ekp.getPageContext().getString(d.k.group_create_step_name), Integer.valueOf(this.LV));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aHh() {
        if (this.mIndex != this.ekO) {
            return this.ekp.getPageContext().getString(d.k.next_step);
        }
        return this.ekp.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ekp.getPageContext().getString(d.k.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHj() {
        return true;
    }
}
