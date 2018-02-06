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
    TextView aSj;
    private int avj;
    private int ezB;
    CreateGroupStepActivity ezx;
    TbImageView ezy;
    private ImageView ezz;
    private int mIndex;
    View mView;
    private int ezw = 3;
    private boolean ezA = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezx = null;
        this.mView = null;
        this.ezy = null;
        this.aSj = null;
        this.ezz = null;
        this.ezx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.ezy = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.aSj = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.ezz = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.avj = i2;
        this.ezB = i3;
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
        return this.aSj;
    }

    public int aGA() {
        return this.ezw;
    }

    public void aGB() {
        this.ezz.setVisibility(0);
        this.ezA = false;
        aGG();
        this.aSj.setText(d.j.location_loading);
        this.ezw = 3;
    }

    public void setBusiness(String str) {
        this.ezz.setVisibility(0);
        this.ezA = true;
        aGG();
        this.aSj.setText(str);
        this.ezw = 0;
    }

    public void setAddress(String str) {
        this.ezz.setVisibility(8);
        this.ezA = true;
        aGG();
        this.aSj.setText(str);
        this.ezw = 4;
    }

    public void aGC() {
        this.ezz.setVisibility(0);
        this.ezA = false;
        aGG();
        this.aSj.setText(d.j.address_locate_failed_opengps);
        this.ezw = 1;
    }

    public void aGD() {
        this.ezA = false;
        aGG();
        this.aSj.setText(d.j.address_locate_failed_tryagain);
        this.ezz.setVisibility(8);
        this.ezw = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezy.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezx.getLayoutMode().aQ(z);
        this.ezx.getLayoutMode().aM(this.mView);
        this.ezy.startLoad(c.a(this.ezx.getActivity(), c.ezC, z), 29, false);
        aGG();
    }

    private void aGG() {
        if (this.ezA) {
            Drawable drawable = aj.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.aSj.setCompoundDrawables(drawable, null, null, null);
            aj.e(this.aSj, d.C0140d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.aSj.setCompoundDrawables(drawable2, null, null, null);
        aj.e(this.aSj, d.C0140d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezx.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.avj));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezB) {
            return this.ezx.getPageContext().getString(d.j.next_step);
        }
        return this.ezx.getPageContext().getString(d.j.group_create_step_done_tip);
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
