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
    TextView axd;
    CreateGroupStepActivity eLu;
    TbImageView eLv;
    private ImageView eLw;
    private int eLy;
    private int mIndex;
    View mView;
    private int eLt = 3;
    private boolean eLx = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eLu = null;
        this.mView = null;
        this.eLv = null;
        this.axd = null;
        this.eLw = null;
        this.eLu = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eLv = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.axd = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.eLw = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OH = i2;
        this.eLy = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aOP() {
        return this.mIndex;
    }

    public View aOQ() {
        return this.axd;
    }

    public int aOR() {
        return this.eLt;
    }

    public void aOS() {
        this.eLw.setVisibility(0);
        this.eLx = false;
        aOX();
        this.axd.setText(e.j.location_loading);
        this.eLt = 3;
    }

    public void setBusiness(String str) {
        this.eLw.setVisibility(0);
        this.eLx = true;
        aOX();
        this.axd.setText(str);
        this.eLt = 0;
    }

    public void setAddress(String str) {
        this.eLw.setVisibility(8);
        this.eLx = true;
        aOX();
        this.axd.setText(str);
        this.eLt = 4;
    }

    public void aOT() {
        this.eLw.setVisibility(0);
        this.eLx = false;
        aOX();
        this.axd.setText(e.j.address_locate_failed_opengps);
        this.eLt = 1;
    }

    public void aOU() {
        this.eLx = false;
        aOX();
        this.axd.setText(e.j.address_locate_failed_tryagain);
        this.eLw.setVisibility(8);
        this.eLt = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOV() {
        this.eLv.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOW() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eLu.getLayoutMode().setNightMode(z);
        this.eLu.getLayoutMode().onModeChanged(this.mView);
        this.eLv.startLoad(c.a(this.eLu.getActivity(), c.eLz, z), 29, false);
        aOX();
    }

    private void aOX() {
        if (this.eLx) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.axd.setCompoundDrawables(drawable, null, null, null);
            al.c(this.axd, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.axd.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.axd, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eLu.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aOY() {
        if (this.mIndex != this.eLy) {
            return this.eLu.getPageContext().getString(e.j.next_step);
        }
        return this.eLu.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOZ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPa() {
        return true;
    }
}
