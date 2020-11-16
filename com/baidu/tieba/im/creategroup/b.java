package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b implements o {
    CreateGroupStepActivity kaN;
    TbImageView kaO;
    private ImageView kaP;
    private int kaR;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int kaM = 3;
    private boolean kaQ = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kaN = null;
        this.mView = null;
        this.kaO = null;
        this.mTipView = null;
        this.kaP = null;
        this.kaN = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.kaO = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.kaP = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.kaR = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPc() {
        return this.mIndex;
    }

    public View cPd() {
        return this.mTipView;
    }

    public int cPe() {
        return this.kaM;
    }

    public void cPf() {
        this.kaP.setVisibility(0);
        this.kaQ = false;
        cPk();
        this.mTipView.setText(R.string.location_loading);
        this.kaM = 3;
    }

    public void setBusiness(String str) {
        this.kaP.setVisibility(0);
        this.kaQ = true;
        cPk();
        this.mTipView.setText(str);
        this.kaM = 0;
    }

    public void setAddress(String str) {
        this.kaP.setVisibility(8);
        this.kaQ = true;
        cPk();
        this.mTipView.setText(str);
        this.kaM = 4;
    }

    public void cPg() {
        this.kaP.setVisibility(0);
        this.kaQ = false;
        cPk();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.kaM = 1;
    }

    public void cPh() {
        this.kaQ = false;
        cPk();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.kaP.setVisibility(8);
        this.kaM = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPi() {
        this.kaO.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kaN.getLayoutMode().setNightMode(z);
        this.kaN.getLayoutMode().onModeChanged(this.mView);
        this.kaO.startLoad(c.a(this.kaN.getActivity(), c.kaS, z), 29, false);
        cPk();
    }

    private void cPk() {
        if (this.kaQ) {
            Drawable drawable = ap.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0105, 1);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        ap.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kaN.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPl() {
        if (this.mIndex != this.kaR) {
            return this.kaN.getPageContext().getString(R.string.next_step);
        }
        return this.kaN.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPn() {
        return true;
    }
}
