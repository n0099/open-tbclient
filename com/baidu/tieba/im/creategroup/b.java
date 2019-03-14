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
    TextView bFI;
    CreateGroupStepActivity gfb;
    TbImageView gfc;
    private ImageView gfd;
    private int gff;
    private int mIndex;
    View mView;
    private int gfa = 3;
    private boolean gfe = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gfb = null;
        this.mView = null;
        this.gfc = null;
        this.bFI = null;
        this.gfd = null;
        this.gfb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step4_view, (ViewGroup) null);
        this.gfc = (TbImageView) this.mView.findViewById(d.g.step4_img_bg);
        this.bFI = (TextView) this.mView.findViewById(d.g.txt_tip_view);
        this.gfd = (ImageView) this.mView.findViewById(d.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Pl = i2;
        this.gff = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqH() {
        return this.mIndex;
    }

    public View bqI() {
        return this.bFI;
    }

    public int bqJ() {
        return this.gfa;
    }

    public void bqK() {
        this.gfd.setVisibility(0);
        this.gfe = false;
        bqP();
        this.bFI.setText(d.j.location_loading);
        this.gfa = 3;
    }

    public void setBusiness(String str) {
        this.gfd.setVisibility(0);
        this.gfe = true;
        bqP();
        this.bFI.setText(str);
        this.gfa = 0;
    }

    public void setAddress(String str) {
        this.gfd.setVisibility(8);
        this.gfe = true;
        bqP();
        this.bFI.setText(str);
        this.gfa = 4;
    }

    public void bqL() {
        this.gfd.setVisibility(0);
        this.gfe = false;
        bqP();
        this.bFI.setText(d.j.address_locate_failed_opengps);
        this.gfa = 1;
    }

    public void bqM() {
        this.gfe = false;
        bqP();
        this.bFI.setText(d.j.address_locate_failed_tryagain);
        this.gfd.setVisibility(8);
        this.gfa = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqN() {
        this.gfc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqO() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gfb.getLayoutMode().setNightMode(z);
        this.gfb.getLayoutMode().onModeChanged(this.mView);
        this.gfc.startLoad(c.a(this.gfb.getActivity(), c.gfg, z), 29, false);
        bqP();
    }

    private void bqP() {
        if (this.gfe) {
            Drawable drawable = al.getDrawable(d.f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bFI.setCompoundDrawables(drawable, null, null, null);
            al.d(this.bFI, d.C0277d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(d.f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bFI.setCompoundDrawables(drawable2, null, null, null);
        al.d(this.bFI, d.C0277d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gfb.getPageContext().getString(d.j.group_create_step_address), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqQ() {
        if (this.mIndex != this.gff) {
            return this.gfb.getPageContext().getString(d.j.next_step);
        }
        return this.gfb.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqR() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqS() {
        return true;
    }
}
