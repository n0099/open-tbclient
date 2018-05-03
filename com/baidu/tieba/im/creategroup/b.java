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
    private int FN;
    TextView adw;
    CreateGroupStepActivity dUc;
    TbImageView dUd;
    private ImageView dUe;
    private int dUg;
    private int mIndex;
    View mView;
    private int dUb = 3;
    private boolean dUf = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.dUc = null;
        this.mView = null;
        this.dUd = null;
        this.adw = null;
        this.dUe = null;
        this.dUc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step4_view, (ViewGroup) null);
        this.dUd = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.adw = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.dUe = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.FN = i2;
        this.dUg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    public View aBz() {
        return this.adw;
    }

    public int aBA() {
        return this.dUb;
    }

    public void aBB() {
        this.dUe.setVisibility(0);
        this.dUf = false;
        aBG();
        this.adw.setText(d.k.location_loading);
        this.dUb = 3;
    }

    public void setBusiness(String str) {
        this.dUe.setVisibility(0);
        this.dUf = true;
        aBG();
        this.adw.setText(str);
        this.dUb = 0;
    }

    public void setAddress(String str) {
        this.dUe.setVisibility(8);
        this.dUf = true;
        aBG();
        this.adw.setText(str);
        this.dUb = 4;
    }

    public void aBC() {
        this.dUe.setVisibility(0);
        this.dUf = false;
        aBG();
        this.adw.setText(d.k.address_locate_failed_opengps);
        this.dUb = 1;
    }

    public void aBD() {
        this.dUf = false;
        aBG();
        this.adw.setText(d.k.address_locate_failed_tryagain);
        this.dUe.setVisibility(8);
        this.dUb = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUc.getLayoutMode().setNightMode(z);
        this.dUc.getLayoutMode().u(this.mView);
        this.dUd.startLoad(c.a(this.dUc.getActivity(), c.dUh, z), 29, false);
        aBG();
    }

    private void aBG() {
        if (this.dUf) {
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
        return String.format(this.dUc.getPageContext().getString(d.k.group_create_step_address), Integer.valueOf(this.FN));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        if (this.mIndex != this.dUg) {
            return this.dUc.getPageContext().getString(d.k.next_step);
        }
        return this.dUc.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return true;
    }
}
