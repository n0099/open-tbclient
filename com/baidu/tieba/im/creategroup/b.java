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
    private int LV;
    TextView alU;
    CreateGroupStepActivity ekp;
    TbImageView ekq;
    private ImageView ekr;
    private int ekt;
    private int mIndex;
    View mView;
    private int eko = 3;
    private boolean eks = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ekp = null;
        this.mView = null;
        this.ekq = null;
        this.alU = null;
        this.ekr = null;
        this.ekp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step4_view, (ViewGroup) null);
        this.ekq = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.alU = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.ekr = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.LV = i2;
        this.ekt = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGY() {
        return this.mIndex;
    }

    public View aGZ() {
        return this.alU;
    }

    public int aHa() {
        return this.eko;
    }

    public void aHb() {
        this.ekr.setVisibility(0);
        this.eks = false;
        aHg();
        this.alU.setText(d.k.location_loading);
        this.eko = 3;
    }

    public void setBusiness(String str) {
        this.ekr.setVisibility(0);
        this.eks = true;
        aHg();
        this.alU.setText(str);
        this.eko = 0;
    }

    public void setAddress(String str) {
        this.ekr.setVisibility(8);
        this.eks = true;
        aHg();
        this.alU.setText(str);
        this.eko = 4;
    }

    public void aHc() {
        this.ekr.setVisibility(0);
        this.eks = false;
        aHg();
        this.alU.setText(d.k.address_locate_failed_opengps);
        this.eko = 1;
    }

    public void aHd() {
        this.eks = false;
        aHg();
        this.alU.setText(d.k.address_locate_failed_tryagain);
        this.ekr.setVisibility(8);
        this.eko = 2;
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
        this.ekq.startLoad(c.a(this.ekp.getActivity(), c.eku, z), 29, false);
        aHg();
    }

    private void aHg() {
        if (this.eks) {
            Drawable drawable = am.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.alU.setCompoundDrawables(drawable, null, null, null);
            am.c(this.alU, d.C0142d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.alU.setCompoundDrawables(drawable2, null, null, null);
        am.c(this.alU, d.C0142d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ekp.getPageContext().getString(d.k.group_create_step_address), Integer.valueOf(this.LV));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aHh() {
        if (this.mIndex != this.ekt) {
            return this.ekp.getPageContext().getString(d.k.next_step);
        }
        return this.ekp.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHi() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHj() {
        return true;
    }
}
