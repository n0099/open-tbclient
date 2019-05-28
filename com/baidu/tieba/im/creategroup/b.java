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
    CreateGroupStepActivity gwc;
    TbImageView gwd;
    private ImageView gwe;
    private int gwg;
    private int mIndex;
    View mView;
    private int gwb = 3;
    private boolean gwf = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwc = null;
        this.mView = null;
        this.gwd = null;
        this.bNl = null;
        this.gwe = null;
        this.gwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gwd = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bNl = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gwe = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.MU = i2;
        this.gwg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byt() {
        return this.mIndex;
    }

    public View byu() {
        return this.bNl;
    }

    public int byv() {
        return this.gwb;
    }

    public void byw() {
        this.gwe.setVisibility(0);
        this.gwf = false;
        byB();
        this.bNl.setText(R.string.location_loading);
        this.gwb = 3;
    }

    public void setBusiness(String str) {
        this.gwe.setVisibility(0);
        this.gwf = true;
        byB();
        this.bNl.setText(str);
        this.gwb = 0;
    }

    public void setAddress(String str) {
        this.gwe.setVisibility(8);
        this.gwf = true;
        byB();
        this.bNl.setText(str);
        this.gwb = 4;
    }

    public void byx() {
        this.gwe.setVisibility(0);
        this.gwf = false;
        byB();
        this.bNl.setText(R.string.address_locate_failed_opengps);
        this.gwb = 1;
    }

    public void byy() {
        this.gwf = false;
        byB();
        this.bNl.setText(R.string.address_locate_failed_tryagain);
        this.gwe.setVisibility(8);
        this.gwb = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byz() {
        this.gwd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwc.getLayoutMode().setNightMode(z);
        this.gwc.getLayoutMode().onModeChanged(this.mView);
        this.gwd.startLoad(c.a(this.gwc.getActivity(), c.gwh, z), 29, false);
        byB();
    }

    private void byB() {
        if (this.gwf) {
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
        return String.format(this.gwc.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byC() {
        if (this.mIndex != this.gwg) {
            return this.gwc.getPageContext().getString(R.string.next_step);
        }
        return this.gwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byD() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }
}
