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
    private int MT;
    TextView bNm;
    CreateGroupStepActivity gwe;
    TbImageView gwf;
    private ImageView gwg;
    private int gwi;
    private int mIndex;
    View mView;
    private int gwd = 3;
    private boolean gwh = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwe = null;
        this.mView = null;
        this.gwf = null;
        this.bNm = null;
        this.gwg = null;
        this.gwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gwf = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bNm = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gwg = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.MT = i2;
        this.gwi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byu() {
        return this.mIndex;
    }

    public View byv() {
        return this.bNm;
    }

    public int byw() {
        return this.gwd;
    }

    public void byx() {
        this.gwg.setVisibility(0);
        this.gwh = false;
        byC();
        this.bNm.setText(R.string.location_loading);
        this.gwd = 3;
    }

    public void setBusiness(String str) {
        this.gwg.setVisibility(0);
        this.gwh = true;
        byC();
        this.bNm.setText(str);
        this.gwd = 0;
    }

    public void setAddress(String str) {
        this.gwg.setVisibility(8);
        this.gwh = true;
        byC();
        this.bNm.setText(str);
        this.gwd = 4;
    }

    public void byy() {
        this.gwg.setVisibility(0);
        this.gwh = false;
        byC();
        this.bNm.setText(R.string.address_locate_failed_opengps);
        this.gwd = 1;
    }

    public void byz() {
        this.gwh = false;
        byC();
        this.bNm.setText(R.string.address_locate_failed_tryagain);
        this.gwg.setVisibility(8);
        this.gwd = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwf.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byB() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwe.getLayoutMode().setNightMode(z);
        this.gwe.getLayoutMode().onModeChanged(this.mView);
        this.gwf.startLoad(c.a(this.gwe.getActivity(), c.gwj, z), 29, false);
        byC();
    }

    private void byC() {
        if (this.gwh) {
            Drawable drawable = al.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bNm.setCompoundDrawables(drawable, null, null, null);
            al.f(this.bNm, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = al.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bNm.setCompoundDrawables(drawable2, null, null, null);
        al.f(this.bNm, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwe.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.MT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byD() {
        if (this.mIndex != this.gwi) {
            return this.gwe.getPageContext().getString(R.string.next_step);
        }
        return this.gwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byF() {
        return true;
    }
}
