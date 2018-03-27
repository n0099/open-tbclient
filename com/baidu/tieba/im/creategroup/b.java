package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements p {
    TextView aSa;
    private int avb;
    CreateGroupStepActivity ezB;
    TbImageView ezC;
    private ImageView ezD;
    private int ezF;
    private int mIndex;
    View mView;
    private int ezA = 3;
    private boolean ezE = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezB = null;
        this.mView = null;
        this.ezC = null;
        this.aSa = null;
        this.ezD = null;
        this.ezB = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.ezC = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.aSa = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.ezD = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.avb = i2;
        this.ezF = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    public View aGz() {
        return this.aSa;
    }

    public int aGA() {
        return this.ezA;
    }

    public void aGB() {
        this.ezD.setVisibility(0);
        this.ezE = false;
        aGG();
        this.aSa.setText(d.j.location_loading);
        this.ezA = 3;
    }

    public void setBusiness(String str) {
        this.ezD.setVisibility(0);
        this.ezE = true;
        aGG();
        this.aSa.setText(str);
        this.ezA = 0;
    }

    public void setAddress(String str) {
        this.ezD.setVisibility(8);
        this.ezE = true;
        aGG();
        this.aSa.setText(str);
        this.ezA = 4;
    }

    public void aGC() {
        this.ezD.setVisibility(0);
        this.ezE = false;
        aGG();
        this.aSa.setText(d.j.address_locate_failed_opengps);
        this.ezA = 1;
    }

    public void aGD() {
        this.ezE = false;
        aGG();
        this.aSa.setText(d.j.address_locate_failed_tryagain);
        this.ezD.setVisibility(8);
        this.ezA = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezC.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezB.getLayoutMode().aQ(z);
        this.ezB.getLayoutMode().aM(this.mView);
        this.ezC.startLoad(c.a(this.ezB.getActivity(), c.ezG, z), 29, false);
        aGG();
    }

    private void aGG() {
        if (this.ezE) {
            Drawable drawable = aj.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.aSa.setCompoundDrawables(drawable, null, null, null);
            aj.e(this.aSa, d.C0141d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.aSa.setCompoundDrawables(drawable2, null, null, null);
        aj.e(this.aSa, d.C0141d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezB.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.avb));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezF) {
            return this.ezB.getPageContext().getString(d.j.next_step);
        }
        return this.ezB.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}
