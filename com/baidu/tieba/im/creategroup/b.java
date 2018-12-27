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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b implements o {
    private int OH;
    TextView axe;
    CreateGroupStepActivity eOl;
    TbImageView eOm;
    private ImageView eOn;
    private int eOp;
    private int mIndex;
    View mView;
    private int eOk = 3;
    private boolean eOo = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOl = null;
        this.mView = null;
        this.eOm = null;
        this.axe = null;
        this.eOn = null;
        this.eOl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eOm = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.axe = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.eOn = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OH = i2;
        this.eOp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aPC() {
        return this.mIndex;
    }

    public View aPD() {
        return this.axe;
    }

    public int aPE() {
        return this.eOk;
    }

    public void aPF() {
        this.eOn.setVisibility(0);
        this.eOo = false;
        aPK();
        this.axe.setText(e.j.location_loading);
        this.eOk = 3;
    }

    public void setBusiness(String str) {
        this.eOn.setVisibility(0);
        this.eOo = true;
        aPK();
        this.axe.setText(str);
        this.eOk = 0;
    }

    public void setAddress(String str) {
        this.eOn.setVisibility(8);
        this.eOo = true;
        aPK();
        this.axe.setText(str);
        this.eOk = 4;
    }

    public void aPG() {
        this.eOn.setVisibility(0);
        this.eOo = false;
        aPK();
        this.axe.setText(e.j.address_locate_failed_opengps);
        this.eOk = 1;
    }

    public void aPH() {
        this.eOo = false;
        aPK();
        this.axe.setText(e.j.address_locate_failed_tryagain);
        this.eOn.setVisibility(8);
        this.eOk = 2;
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
        this.eOm.startLoad(c.a(this.eOl.getActivity(), c.eOq, z), 29, false);
        aPK();
    }

    private void aPK() {
        if (this.eOo) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.axe.setCompoundDrawables(drawable, null, null, null);
            al.c(this.axe, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.axe.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.axe, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOl.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aPL() {
        if (this.mIndex != this.eOp) {
            return this.eOl.getPageContext().getString(e.j.next_step);
        }
        return this.eOl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPM() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPN() {
        return true;
    }
}
