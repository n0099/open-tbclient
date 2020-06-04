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
    CreateGroupStepActivity iwR;
    TbImageView iwS;
    private ImageView iwT;
    private int iwV;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iwQ = 3;
    private boolean iwU = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwR = null;
        this.mView = null;
        this.iwS = null;
        this.mTipView = null;
        this.iwT = null;
        this.iwR = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.iwS = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.iwT = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iwV = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckl() {
        return this.mIndex;
    }

    public View ckm() {
        return this.mTipView;
    }

    public int ckn() {
        return this.iwQ;
    }

    public void cko() {
        this.iwT.setVisibility(0);
        this.iwU = false;
        ckt();
        this.mTipView.setText(R.string.location_loading);
        this.iwQ = 3;
    }

    public void setBusiness(String str) {
        this.iwT.setVisibility(0);
        this.iwU = true;
        ckt();
        this.mTipView.setText(str);
        this.iwQ = 0;
    }

    public void setAddress(String str) {
        this.iwT.setVisibility(8);
        this.iwU = true;
        ckt();
        this.mTipView.setText(str);
        this.iwQ = 4;
    }

    public void ckp() {
        this.iwT.setVisibility(0);
        this.iwU = false;
        ckt();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iwQ = 1;
    }

    public void ckq() {
        this.iwU = false;
        ckt();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.iwT.setVisibility(8);
        this.iwQ = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckr() {
        this.iwS.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cks() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwR.getLayoutMode().setNightMode(z);
        this.iwR.getLayoutMode().onModeChanged(this.mView);
        this.iwS.startLoad(c.a(this.iwR.getActivity(), c.iwW, z), 29, false);
        ckt();
    }

    private void ckt() {
        if (this.iwU) {
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
        return String.format(this.iwR.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cku() {
        if (this.mIndex != this.iwV) {
            return this.iwR.getPageContext().getString(R.string.next_step);
        }
        return this.iwR.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckv() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckw() {
        return true;
    }
}
