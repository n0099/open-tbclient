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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b implements o {
    CreateGroupStepActivity ihv;
    TbImageView ihw;
    private ImageView ihx;
    private int ihz;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int ihu = 3;
    private boolean ihy = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihv = null;
        this.mView = null;
        this.ihw = null;
        this.mTipView = null;
        this.ihx = null;
        this.ihv = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.ihw = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.ihx = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.ihz = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdE() {
        return this.mIndex;
    }

    public View cdF() {
        return this.mTipView;
    }

    public int cdG() {
        return this.ihu;
    }

    public void cdH() {
        this.ihx.setVisibility(0);
        this.ihy = false;
        cdM();
        this.mTipView.setText(R.string.location_loading);
        this.ihu = 3;
    }

    public void setBusiness(String str) {
        this.ihx.setVisibility(0);
        this.ihy = true;
        cdM();
        this.mTipView.setText(str);
        this.ihu = 0;
    }

    public void setAddress(String str) {
        this.ihx.setVisibility(8);
        this.ihy = true;
        cdM();
        this.mTipView.setText(str);
        this.ihu = 4;
    }

    public void cdI() {
        this.ihx.setVisibility(0);
        this.ihy = false;
        cdM();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.ihu = 1;
    }

    public void cdJ() {
        this.ihy = false;
        cdM();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.ihx.setVisibility(8);
        this.ihu = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdK() {
        this.ihw.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihv.getLayoutMode().setNightMode(z);
        this.ihv.getLayoutMode().onModeChanged(this.mView);
        this.ihw.startLoad(c.a(this.ihv.getActivity(), c.ihA, z), 29, false);
        cdM();
    }

    private void cdM() {
        if (this.ihy) {
            Drawable drawable = am.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            am.setViewTextColor(this.mTipView, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        am.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihv.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdN() {
        if (this.mIndex != this.ihz) {
            return this.ihv.getPageContext().getString(R.string.next_step);
        }
        return this.ihv.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdO() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return true;
    }
}
