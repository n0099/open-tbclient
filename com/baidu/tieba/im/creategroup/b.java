package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements o {
    private int LS;
    TextView alu;
    private int egA;
    CreateGroupStepActivity egw;
    TbImageView egx;
    private ImageView egy;
    private int mIndex;
    View mView;
    private int egv = 3;
    private boolean egz = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.egw = null;
        this.mView = null;
        this.egx = null;
        this.alu = null;
        this.egy = null;
        this.egw = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step4_view, (ViewGroup) null);
        this.egx = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.alu = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.egy = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.LS = i2;
        this.egA = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGr() {
        return this.mIndex;
    }

    public View aGs() {
        return this.alu;
    }

    public int aGt() {
        return this.egv;
    }

    public void aGu() {
        this.egy.setVisibility(0);
        this.egz = false;
        aGz();
        this.alu.setText(d.k.location_loading);
        this.egv = 3;
    }

    public void setBusiness(String str) {
        this.egy.setVisibility(0);
        this.egz = true;
        aGz();
        this.alu.setText(str);
        this.egv = 0;
    }

    public void setAddress(String str) {
        this.egy.setVisibility(8);
        this.egz = true;
        aGz();
        this.alu.setText(str);
        this.egv = 4;
    }

    public void aGv() {
        this.egy.setVisibility(0);
        this.egz = false;
        aGz();
        this.alu.setText(d.k.address_locate_failed_opengps);
        this.egv = 1;
    }

    public void aGw() {
        this.egz = false;
        aGz();
        this.alu.setText(d.k.address_locate_failed_tryagain);
        this.egy.setVisibility(8);
        this.egv = 2;
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
        this.egx.startLoad(c.a(this.egw.getActivity(), c.egB, z), 29, false);
        aGz();
    }

    private void aGz() {
        if (this.egz) {
            Drawable drawable = al.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.alu.setCompoundDrawables(drawable, null, null, null);
            al.c(this.alu, d.C0141d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.alu.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.alu, d.C0141d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.egw.getPageContext().getString(d.k.group_create_step_address), Integer.valueOf(this.LS));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aGA() {
        if (this.mIndex != this.egA) {
            return this.egw.getPageContext().getString(d.k.next_step);
        }
        return this.egw.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGB() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGC() {
        return true;
    }
}
