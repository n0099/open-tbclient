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
    TextView aRY;
    private int ava;
    CreateGroupStepActivity ezl;
    TbImageView ezm;
    private ImageView ezn;
    private int ezp;
    private int mIndex;
    View mView;
    private int ezk = 3;
    private boolean ezo = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezl = null;
        this.mView = null;
        this.ezm = null;
        this.aRY = null;
        this.ezn = null;
        this.ezl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.ezm = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.aRY = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.ezn = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.ava = i2;
        this.ezp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGx() {
        return this.mIndex;
    }

    public View aGy() {
        return this.aRY;
    }

    public int aGz() {
        return this.ezk;
    }

    public void aGA() {
        this.ezn.setVisibility(0);
        this.ezo = false;
        aGF();
        this.aRY.setText(d.j.location_loading);
        this.ezk = 3;
    }

    public void setBusiness(String str) {
        this.ezn.setVisibility(0);
        this.ezo = true;
        aGF();
        this.aRY.setText(str);
        this.ezk = 0;
    }

    public void setAddress(String str) {
        this.ezn.setVisibility(8);
        this.ezo = true;
        aGF();
        this.aRY.setText(str);
        this.ezk = 4;
    }

    public void aGB() {
        this.ezn.setVisibility(0);
        this.ezo = false;
        aGF();
        this.aRY.setText(d.j.address_locate_failed_opengps);
        this.ezk = 1;
    }

    public void aGC() {
        this.ezo = false;
        aGF();
        this.aRY.setText(d.j.address_locate_failed_tryagain);
        this.ezn.setVisibility(8);
        this.ezk = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGD() {
        this.ezm.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezl.getLayoutMode().aQ(z);
        this.ezl.getLayoutMode().aM(this.mView);
        this.ezm.startLoad(c.a(this.ezl.getActivity(), c.ezq, z), 29, false);
        aGF();
    }

    private void aGF() {
        if (this.ezo) {
            Drawable drawable = aj.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.aRY.setCompoundDrawables(drawable, null, null, null);
            aj.e(this.aRY, d.C0141d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = aj.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.aRY.setCompoundDrawables(drawable2, null, null, null);
        aj.e(this.aRY, d.C0141d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezl.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.ava));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGG() {
        if (this.mIndex != this.ezp) {
            return this.ezl.getPageContext().getString(d.j.next_step);
        }
        return this.ezl.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGH() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }
}
