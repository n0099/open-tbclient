package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements o {
    private int FJ;
    TextView adw;
    CreateGroupStepActivity dVj;
    TbImageView dVk;
    private ImageView dVl;
    private int dVn;
    private int mIndex;
    View mView;
    private int dVi = 3;
    private boolean dVm = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dVj = null;
        this.mView = null;
        this.dVk = null;
        this.adw = null;
        this.dVl = null;
        this.dVj = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step4_view, (ViewGroup) null);
        this.dVk = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.adw = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.dVl = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.FJ = i2;
        this.dVn = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBw() {
        return this.mIndex;
    }

    public View aBx() {
        return this.adw;
    }

    public int aBy() {
        return this.dVi;
    }

    public void aBz() {
        this.dVl.setVisibility(0);
        this.dVm = false;
        aBE();
        this.adw.setText(d.k.location_loading);
        this.dVi = 3;
    }

    public void setBusiness(String str) {
        this.dVl.setVisibility(0);
        this.dVm = true;
        aBE();
        this.adw.setText(str);
        this.dVi = 0;
    }

    public void setAddress(String str) {
        this.dVl.setVisibility(8);
        this.dVm = true;
        aBE();
        this.adw.setText(str);
        this.dVi = 4;
    }

    public void aBA() {
        this.dVl.setVisibility(0);
        this.dVm = false;
        aBE();
        this.adw.setText(d.k.address_locate_failed_opengps);
        this.dVi = 1;
    }

    public void aBB() {
        this.dVm = false;
        aBE();
        this.adw.setText(d.k.address_locate_failed_tryagain);
        this.dVl.setVisibility(8);
        this.dVi = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBC() {
        this.dVk.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dVj.getLayoutMode().setNightMode(z);
        this.dVj.getLayoutMode().u(this.mView);
        this.dVk.startLoad(c.a(this.dVj.getActivity(), c.dVo, z), 29, false);
        aBE();
    }

    private void aBE() {
        if (this.dVm) {
            Drawable drawable = ak.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.adw.setCompoundDrawables(drawable, null, null, null);
            ak.c(this.adw, d.C0126d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = ak.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.adw.setCompoundDrawables(drawable2, null, null, null);
        ak.c(this.adw, d.C0126d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.dVj.getPageContext().getString(d.k.group_create_step_address), Integer.valueOf(this.FJ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBF() {
        if (this.mIndex != this.dVn) {
            return this.dVj.getPageContext().getString(d.k.next_step);
        }
        return this.dVj.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBG() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBH() {
        return true;
    }
}
