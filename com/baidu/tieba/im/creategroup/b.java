package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b implements o {
    private int LQ;
    TextView alt;
    CreateGroupStepActivity eod;
    TbImageView eoe;
    private ImageView eog;
    private int eoi;
    private int mIndex;
    View mView;
    private int eoc = 3;
    private boolean eoh = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eod = null;
        this.mView = null;
        this.eoe = null;
        this.alt = null;
        this.eog = null;
        this.eod = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(f.h.create_group_step4_view, (ViewGroup) null);
        this.eoe = (TbImageView) this.mView.findViewById(f.g.step4_img_bg);
        this.alt = (TextView) this.mView.findViewById(f.g.txt_tip_view);
        this.eog = (ImageView) this.mView.findViewById(f.g.create_group_address_rightarrwow);
        this.mIndex = i;
        this.LQ = i2;
        this.eoi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHV() {
        return this.mIndex;
    }

    public View aHW() {
        return this.alt;
    }

    public int aHX() {
        return this.eoc;
    }

    public void aHY() {
        this.eog.setVisibility(0);
        this.eoh = false;
        aId();
        this.alt.setText(f.j.location_loading);
        this.eoc = 3;
    }

    public void setBusiness(String str) {
        this.eog.setVisibility(0);
        this.eoh = true;
        aId();
        this.alt.setText(str);
        this.eoc = 0;
    }

    public void setAddress(String str) {
        this.eog.setVisibility(8);
        this.eoh = true;
        aId();
        this.alt.setText(str);
        this.eoc = 4;
    }

    public void aHZ() {
        this.eog.setVisibility(0);
        this.eoh = false;
        aId();
        this.alt.setText(f.j.address_locate_failed_opengps);
        this.eoc = 1;
    }

    public void aIa() {
        this.eoh = false;
        aId();
        this.alt.setText(f.j.address_locate_failed_tryagain);
        this.eog.setVisibility(8);
        this.eoc = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIb() {
        this.eoe.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eod.getLayoutMode().setNightMode(z);
        this.eod.getLayoutMode().onModeChanged(this.mView);
        this.eoe.startLoad(c.a(this.eod.getActivity(), c.eoj, z), 29, false);
        aId();
    }

    private void aId() {
        if (this.eoh) {
            Drawable drawable = am.getDrawable(f.C0146f.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.alt.setCompoundDrawables(drawable, null, null, null);
            am.c(this.alt, f.d.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(f.C0146f.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.alt.setCompoundDrawables(drawable2, null, null, null);
        am.c(this.alt, f.d.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eod.getPageContext().getString(f.j.group_create_step_address), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIe() {
        if (this.mIndex != this.eoi) {
            return this.eod.getPageContext().getString(f.j.next_step);
        }
        return this.eod.getPageContext().getString(f.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIf() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIg() {
        return true;
    }
}
