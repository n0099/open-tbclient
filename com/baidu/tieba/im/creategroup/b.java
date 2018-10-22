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
    private int OG;
    TextView asQ;
    CreateGroupStepActivity eDm;
    TbImageView eDn;
    private ImageView eDo;
    private int eDq;
    private int mIndex;
    View mView;
    private int eDl = 3;
    private boolean eDp = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDm = null;
        this.mView = null;
        this.eDn = null;
        this.asQ = null;
        this.eDo = null;
        this.eDm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eDn = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.asQ = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.eDo = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OG = i2;
        this.eDq = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    public View aNB() {
        return this.asQ;
    }

    public int aNC() {
        return this.eDl;
    }

    public void aND() {
        this.eDo.setVisibility(0);
        this.eDp = false;
        aNI();
        this.asQ.setText(e.j.location_loading);
        this.eDl = 3;
    }

    public void setBusiness(String str) {
        this.eDo.setVisibility(0);
        this.eDp = true;
        aNI();
        this.asQ.setText(str);
        this.eDl = 0;
    }

    public void setAddress(String str) {
        this.eDo.setVisibility(8);
        this.eDp = true;
        aNI();
        this.asQ.setText(str);
        this.eDl = 4;
    }

    public void aNE() {
        this.eDo.setVisibility(0);
        this.eDp = false;
        aNI();
        this.asQ.setText(e.j.address_locate_failed_opengps);
        this.eDl = 1;
    }

    public void aNF() {
        this.eDp = false;
        aNI();
        this.asQ.setText(e.j.address_locate_failed_tryagain);
        this.eDo.setVisibility(8);
        this.eDl = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDm.getLayoutMode().setNightMode(z);
        this.eDm.getLayoutMode().onModeChanged(this.mView);
        this.eDn.startLoad(c.a(this.eDm.getActivity(), c.eDr, z), 29, false);
        aNI();
    }

    private void aNI() {
        if (this.eDp) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.asQ.setCompoundDrawables(drawable, null, null, null);
            al.c(this.asQ, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.asQ.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.asQ, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDm.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDq) {
            return this.eDm.getPageContext().getString(e.j.next_step);
        }
        return this.eDm.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
