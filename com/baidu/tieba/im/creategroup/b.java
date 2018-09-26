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
    private int Or;
    TextView anY;
    private int evB;
    CreateGroupStepActivity evx;
    TbImageView evy;
    private ImageView evz;
    private int mIndex;
    View mView;
    private int evw = 3;
    private boolean evA = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.evx = null;
        this.mView = null;
        this.evy = null;
        this.anY = null;
        this.evz = null;
        this.evx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step4_view, (ViewGroup) null);
        this.evy = (TbImageView) this.mView.findViewById(e.g.step4_img_bg);
        this.anY = (TextView) this.mView.findViewById(e.g.txt_tip_view);
        this.evz = (ImageView) this.mView.findViewById(e.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Or = i2;
        this.evB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aKk() {
        return this.mIndex;
    }

    public View aKl() {
        return this.anY;
    }

    public int aKm() {
        return this.evw;
    }

    public void aKn() {
        this.evz.setVisibility(0);
        this.evA = false;
        aKs();
        this.anY.setText(e.j.location_loading);
        this.evw = 3;
    }

    public void setBusiness(String str) {
        this.evz.setVisibility(0);
        this.evA = true;
        aKs();
        this.anY.setText(str);
        this.evw = 0;
    }

    public void setAddress(String str) {
        this.evz.setVisibility(8);
        this.evA = true;
        aKs();
        this.anY.setText(str);
        this.evw = 4;
    }

    public void aKo() {
        this.evz.setVisibility(0);
        this.evA = false;
        aKs();
        this.anY.setText(e.j.address_locate_failed_opengps);
        this.evw = 1;
    }

    public void aKp() {
        this.evA = false;
        aKs();
        this.anY.setText(e.j.address_locate_failed_tryagain);
        this.evz.setVisibility(8);
        this.evw = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKq() {
        this.evy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKr() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.evx.getLayoutMode().setNightMode(z);
        this.evx.getLayoutMode().onModeChanged(this.mView);
        this.evy.startLoad(c.a(this.evx.getActivity(), c.evC, z), 29, false);
        aKs();
    }

    private void aKs() {
        if (this.evA) {
            Drawable drawable = al.getDrawable(e.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.anY.setCompoundDrawables(drawable, null, null, null);
            al.c(this.anY, e.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.anY.setCompoundDrawables(drawable2, null, null, null);
        al.c(this.anY, e.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.evx.getPageContext().getString(e.j.group_create_step_address), Integer.valueOf(this.Or));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aKt() {
        if (this.mIndex != this.evB) {
            return this.evx.getPageContext().getString(e.j.next_step);
        }
        return this.evx.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKu() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKv() {
        return true;
    }
}
