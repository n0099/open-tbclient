package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements o {
    private int LQ;
    TextView alu;
    CreateGroupStepActivity eoi;
    TbImageView eoj;
    private ImageView eok;
    private int eom;
    private int mIndex;
    View mView;
    private int eoh = 3;
    private boolean eol = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eoi = null;
        this.mView = null;
        this.eoj = null;
        this.alu = null;
        this.eok = null;
        this.eoi = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.eoj = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.alu = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.eok = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.LQ = i2;
        this.eom = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHY() {
        return this.mIndex;
    }

    public View aHZ() {
        return this.alu;
    }

    public int aIa() {
        return this.eoh;
    }

    public void aIb() {
        this.eok.setVisibility(0);
        this.eol = false;
        aIg();
        this.alu.setText(d.j.location_loading);
        this.eoh = 3;
    }

    public void setBusiness(String str) {
        this.eok.setVisibility(0);
        this.eol = true;
        aIg();
        this.alu.setText(str);
        this.eoh = 0;
    }

    public void setAddress(String str) {
        this.eok.setVisibility(8);
        this.eol = true;
        aIg();
        this.alu.setText(str);
        this.eoh = 4;
    }

    public void aIc() {
        this.eok.setVisibility(0);
        this.eol = false;
        aIg();
        this.alu.setText(d.j.address_locate_failed_opengps);
        this.eoh = 1;
    }

    public void aId() {
        this.eol = false;
        aIg();
        this.alu.setText(d.j.address_locate_failed_tryagain);
        this.eok.setVisibility(8);
        this.eoh = 2;
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
        this.eoj.startLoad(c.a(this.eoi.getActivity(), c.eon, z), 29, false);
        aIg();
    }

    private void aIg() {
        if (this.eol) {
            Drawable drawable = am.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.alu.setCompoundDrawables(drawable, null, null, null);
            am.c(this.alu, d.C0140d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.alu.setCompoundDrawables(drawable2, null, null, null);
        am.c(this.alu, d.C0140d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eoi.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIh() {
        if (this.mIndex != this.eom) {
            return this.eoi.getPageContext().getString(d.j.next_step);
        }
        return this.eoi.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIi() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIj() {
        return true;
    }
}
