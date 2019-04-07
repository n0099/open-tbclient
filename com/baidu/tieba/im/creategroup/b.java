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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b implements o {
    private int Pl;
    TextView bFK;
    CreateGroupStepActivity geP;
    TbImageView geQ;
    private ImageView geR;
    private int geT;
    private int mIndex;
    View mView;
    private int geO = 3;
    private boolean geS = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.geP = null;
        this.mView = null;
        this.geQ = null;
        this.bFK = null;
        this.geR = null;
        this.geP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.geQ = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.bFK = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.geR = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Pl = i2;
        this.geT = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqE() {
        return this.mIndex;
    }

    public View bqF() {
        return this.bFK;
    }

    public int bqG() {
        return this.geO;
    }

    public void bqH() {
        this.geR.setVisibility(0);
        this.geS = false;
        bqM();
        this.bFK.setText(d.j.location_loading);
        this.geO = 3;
    }

    public void setBusiness(String str) {
        this.geR.setVisibility(0);
        this.geS = true;
        bqM();
        this.bFK.setText(str);
        this.geO = 0;
    }

    public void setAddress(String str) {
        this.geR.setVisibility(8);
        this.geS = true;
        bqM();
        this.bFK.setText(str);
        this.geO = 4;
    }

    public void bqI() {
        this.geR.setVisibility(0);
        this.geS = false;
        bqM();
        this.bFK.setText(d.j.address_locate_failed_opengps);
        this.geO = 1;
    }

    public void bqJ() {
        this.geS = false;
        bqM();
        this.bFK.setText(d.j.address_locate_failed_tryagain);
        this.geR.setVisibility(8);
        this.geO = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqK() {
        this.geQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.geP.getLayoutMode().setNightMode(z);
        this.geP.getLayoutMode().onModeChanged(this.mView);
        this.geQ.startLoad(c.a(this.geP.getActivity(), c.geU, z), 29, false);
        bqM();
    }

    private void bqM() {
        if (this.geS) {
            Drawable drawable = al.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bFK.setCompoundDrawables(drawable, null, null, null);
            al.d(this.bFK, d.C0277d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bFK.setCompoundDrawables(drawable2, null, null, null);
        al.d(this.bFK, d.C0277d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.geP.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqN() {
        if (this.mIndex != this.geT) {
            return this.geP.getPageContext().getString(d.j.next_step);
        }
        return this.geP.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqO() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqP() {
        return true;
    }
}
