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
/* loaded from: classes3.dex */
public class g implements o {
    private int LS;
    EditText egT;
    private ImageButton egU;
    private int egV;
    CreateGroupStepActivity egw;
    TbImageView egx;
    private int mIndex;
    View mView;

    public EditText aGJ() {
        return this.egT;
    }

    public View aGK() {
        return this.egU;
    }

    public void aGL() {
        this.egT.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.egT);
    }

    public void gY(boolean z) {
        if (z) {
            this.egU.setVisibility(0);
        } else {
            this.egU.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.egw = null;
        this.mView = null;
        this.egx = null;
        this.egT = null;
        this.egU = null;
        this.egw = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step1_view, (ViewGroup) null);
        this.egT = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.egx = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.egU = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.egU.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.LS = i2;
        this.egV = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.egw.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGx() {
        this.egx.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.egw.getLayoutMode().setNightMode(z);
        this.egw.getLayoutMode().onModeChanged(this.mView);
        this.egx.startLoad(c.a(this.egw.getPageContext().getPageActivity(), c.egE, z), 29, false);
        this.egT.setHintTextColor(al.getColor(d.C0141d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.egw.getPageContext().getString(d.k.group_create_step_name), Integer.valueOf(this.LS));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aGA() {
        if (this.mIndex != this.egV) {
            return this.egw.getPageContext().getString(d.k.next_step);
        }
        return this.egw.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGB() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.egw.getPageContext().getString(d.k.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGC() {
        return true;
    }
}
