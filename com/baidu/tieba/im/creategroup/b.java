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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b implements o {
    private int MU;
    TextView bNl;
    CreateGroupStepActivity gwb;
    TbImageView gwc;
    private ImageView gwd;
    private int gwf;
    private int mIndex;
    View mView;
    private int gwa = 3;
    private boolean gwe = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwb = null;
        this.mView = null;
        this.gwc = null;
        this.bNl = null;
        this.gwd = null;
        this.gwb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gwc = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bNl = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gwd = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.MU = i2;
        this.gwf = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byq() {
        return this.mIndex;
    }

    public View byr() {
        return this.bNl;
    }

    public int bys() {
        return this.gwa;
    }

    public void byt() {
        this.gwd.setVisibility(0);
        this.gwe = false;
        byy();
        this.bNl.setText(R.string.location_loading);
        this.gwa = 3;
    }

    public void setBusiness(String str) {
        this.gwd.setVisibility(0);
        this.gwe = true;
        byy();
        this.bNl.setText(str);
        this.gwa = 0;
    }

    public void setAddress(String str) {
        this.gwd.setVisibility(8);
        this.gwe = true;
        byy();
        this.bNl.setText(str);
        this.gwa = 4;
    }

    public void byu() {
        this.gwd.setVisibility(0);
        this.gwe = false;
        byy();
        this.bNl.setText(R.string.address_locate_failed_opengps);
        this.gwa = 1;
    }

    public void byv() {
        this.gwe = false;
        byy();
        this.bNl.setText(R.string.address_locate_failed_tryagain);
        this.gwd.setVisibility(8);
        this.gwa = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byw() {
        this.gwc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwb.getLayoutMode().setNightMode(z);
        this.gwb.getLayoutMode().onModeChanged(this.mView);
        this.gwc.startLoad(c.a(this.gwb.getActivity(), c.gwg, z), 29, false);
        byy();
    }

    private void byy() {
        if (this.gwe) {
            Drawable drawable = al.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bNl.setCompoundDrawables(drawable, null, null, null);
            al.f(this.bNl, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bNl.setCompoundDrawables(drawable2, null, null, null);
        al.f(this.bNl, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwb.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byz() {
        if (this.mIndex != this.gwf) {
            return this.gwb.getPageContext().getString(R.string.next_step);
        }
        return this.gwb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byB() {
        return true;
    }
}
