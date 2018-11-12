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
    TextView atD;
    CreateGroupStepActivity eEF;
    TbImageView eEG;
    private ImageView eEH;
    private int eEJ;
    private int mIndex;
    View mView;
    private int eEE = 3;
    private boolean eEI = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eEF = null;
        this.mView = null;
        this.eEG = null;
        this.atD = null;
        this.eEH = null;
        this.eEF = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.eEG = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.atD = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.eEH = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.OH = i2;
        this.eEJ = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aMX() {
        return this.mIndex;
    }

    public View aMY() {
        return this.atD;
    }

    public int aMZ() {
        return this.eEE;
    }

    public void aNa() {
        this.eEH.setVisibility(0);
        this.eEI = false;
        aNf();
        this.atD.setText(e.j.location_loading);
        this.eEE = 3;
    }

    public void setBusiness(String str) {
        this.eEH.setVisibility(0);
        this.eEI = true;
        aNf();
        this.atD.setText(str);
        this.eEE = 0;
    }

    public void setAddress(String str) {
        this.eEH.setVisibility(8);
        this.eEI = true;
        aNf();
        this.atD.setText(str);
        this.eEE = 4;
    }

    public void aNb() {
        this.eEH.setVisibility(0);
        this.eEI = false;
        aNf();
        this.atD.setText(e.j.address_locate_failed_opengps);
        this.eEE = 1;
    }

    public void aNc() {
        this.eEI = false;
        aNf();
        this.atD.setText(e.j.address_locate_failed_tryagain);
        this.eEH.setVisibility(8);
        this.eEE = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNd() {
        this.eEG.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNe() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eEF.getLayoutMode().setNightMode(z);
        this.eEF.getLayoutMode().onModeChanged(this.mView);
        this.eEG.startLoad(c.a(this.eEF.getActivity(), c.eEK, z), 29, false);
        aNf();
    }

    private void aNf() {
        if (this.eEI) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.atD.setCompoundDrawables(drawable, null, null, null);
            al.c(this.atD, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.atD.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.atD, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eEF.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNg() {
        if (this.mIndex != this.eEJ) {
            return this.eEF.getPageContext().getString(e.j.next_step);
        }
        return this.eEF.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNh() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNi() {
        return true;
    }
}
