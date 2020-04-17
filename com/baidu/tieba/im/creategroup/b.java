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
    CreateGroupStepActivity ihp;
    TbImageView ihq;
    private ImageView ihr;
    private int iht;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iho = 3;
    private boolean ihs = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihp = null;
        this.mView = null;
        this.ihq = null;
        this.mTipView = null;
        this.ihr = null;
        this.ihp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.ihq = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.ihr = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iht = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdF() {
        return this.mIndex;
    }

    public View cdG() {
        return this.mTipView;
    }

    public int cdH() {
        return this.iho;
    }

    public void cdI() {
        this.ihr.setVisibility(0);
        this.ihs = false;
        cdN();
        this.mTipView.setText(R.string.location_loading);
        this.iho = 3;
    }

    public void setBusiness(String str) {
        this.ihr.setVisibility(0);
        this.ihs = true;
        cdN();
        this.mTipView.setText(str);
        this.iho = 0;
    }

    public void setAddress(String str) {
        this.ihr.setVisibility(8);
        this.ihs = true;
        cdN();
        this.mTipView.setText(str);
        this.iho = 4;
    }

    public void cdJ() {
        this.ihr.setVisibility(0);
        this.ihs = false;
        cdN();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iho = 1;
    }

    public void cdK() {
        this.ihs = false;
        cdN();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.ihr.setVisibility(8);
        this.iho = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        this.ihq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdM() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihp.getLayoutMode().setNightMode(z);
        this.ihp.getLayoutMode().onModeChanged(this.mView);
        this.ihq.startLoad(c.a(this.ihp.getActivity(), c.ihu, z), 29, false);
        cdN();
    }

    private void cdN() {
        if (this.ihs) {
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
        return String.format(this.ihp.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdO() {
        if (this.mIndex != this.iht) {
            return this.ihp.getPageContext().getString(R.string.next_step);
        }
        return this.ihp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdQ() {
        return true;
    }
}
