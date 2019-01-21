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
    TextView axH;
    CreateGroupStepActivity eOY;
    TbImageView eOZ;
    private ImageView ePa;
    private int ePc;
    private int mIndex;
    View mView;
    private int eOX = 3;
    private boolean ePb = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eOY = null;
        this.mView = null;
        this.eOZ = null;
        this.axH = null;
        this.ePa = null;
        this.eOY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eOZ = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.axH = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.ePa = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OT = i2;
        this.ePc = i3;
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
        return this.axH;
    }

    public int aQe() {
        return this.eOX;
    }

    public void aQf() {
        this.ePa.setVisibility(0);
        this.ePb = false;
        aQk();
        this.axH.setText(e.j.location_loading);
        this.eOX = 3;
    }

    public void setBusiness(String str) {
        this.ePa.setVisibility(0);
        this.ePb = true;
        aQk();
        this.axH.setText(str);
        this.eOX = 0;
    }

    public void setAddress(String str) {
        this.ePa.setVisibility(8);
        this.ePb = true;
        aQk();
        this.axH.setText(str);
        this.eOX = 4;
    }

    public void aQg() {
        this.ePa.setVisibility(0);
        this.ePb = false;
        aQk();
        this.axH.setText(e.j.address_locate_failed_opengps);
        this.eOX = 1;
    }

    public void aQh() {
        this.ePb = false;
        aQk();
        this.axH.setText(e.j.address_locate_failed_tryagain);
        this.ePa.setVisibility(8);
        this.eOX = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.eOZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOY.getLayoutMode().setNightMode(z);
        this.eOY.getLayoutMode().onModeChanged(this.mView);
        this.eOZ.startLoad(c.a(this.eOY.getActivity(), c.ePd, z), 29, false);
        aQk();
    }

    private void aQk() {
        if (this.ePb) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.axH.setCompoundDrawables(drawable, null, null, null);
            al.c(this.axH, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.axH.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.axH, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eOY.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        if (this.mIndex != this.ePc) {
            return this.eOY.getPageContext().getString(e.j.next_step);
        }
        return this.eOY.getPageContext().getString(e.j.group_create_step_done_tip);
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
