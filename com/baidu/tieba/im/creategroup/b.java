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
    private int OT;
    TextView axG;
    CreateGroupStepActivity eOX;
    TbImageView eOY;
    private ImageView eOZ;
    private int ePb;
    private int mIndex;
    View mView;
    private int eOW = 3;
    private boolean ePa = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOX = null;
        this.mView = null;
        this.eOY = null;
        this.axG = null;
        this.eOZ = null;
        this.eOX = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eOY = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.axG = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.eOZ = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OT = i2;
        this.ePb = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    public View aQd() {
        return this.axG;
    }

    public int aQe() {
        return this.eOW;
    }

    public void aQf() {
        this.eOZ.setVisibility(0);
        this.ePa = false;
        aQk();
        this.axG.setText(e.j.location_loading);
        this.eOW = 3;
    }

    public void setBusiness(String str) {
        this.eOZ.setVisibility(0);
        this.ePa = true;
        aQk();
        this.axG.setText(str);
        this.eOW = 0;
    }

    public void setAddress(String str) {
        this.eOZ.setVisibility(8);
        this.ePa = true;
        aQk();
        this.axG.setText(str);
        this.eOW = 4;
    }

    public void aQg() {
        this.eOZ.setVisibility(0);
        this.ePa = false;
        aQk();
        this.axG.setText(e.j.address_locate_failed_opengps);
        this.eOW = 1;
    }

    public void aQh() {
        this.ePa = false;
        aQk();
        this.axG.setText(e.j.address_locate_failed_tryagain);
        this.eOZ.setVisibility(8);
        this.eOW = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.eOY.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOX.getLayoutMode().setNightMode(z);
        this.eOX.getLayoutMode().onModeChanged(this.mView);
        this.eOY.startLoad(c.a(this.eOX.getActivity(), c.ePc, z), 29, false);
        aQk();
    }

    private void aQk() {
        if (this.ePa) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.axG.setCompoundDrawables(drawable, null, null, null);
            al.c(this.axG, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.axG.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.axG, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOX.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePb) {
            return this.eOX.getPageContext().getString(e.j.next_step);
        }
        return this.eOX.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return true;
    }
}
