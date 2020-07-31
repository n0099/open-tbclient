package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b implements o {
    CreateGroupStepActivity iUZ;
    TbImageView iVa;
    private ImageView iVb;
    private int iVd;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iUY = 3;
    private boolean iVc = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iUZ = null;
        this.mView = null;
        this.iVa = null;
        this.mTipView = null;
        this.iVb = null;
        this.iUZ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.iVa = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.iVb = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iVd = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    public View crH() {
        return this.mTipView;
    }

    public int crI() {
        return this.iUY;
    }

    public void crJ() {
        this.iVb.setVisibility(0);
        this.iVc = false;
        crO();
        this.mTipView.setText(R.string.location_loading);
        this.iUY = 3;
    }

    public void setBusiness(String str) {
        this.iVb.setVisibility(0);
        this.iVc = true;
        crO();
        this.mTipView.setText(str);
        this.iUY = 0;
    }

    public void setAddress(String str) {
        this.iVb.setVisibility(8);
        this.iVc = true;
        crO();
        this.mTipView.setText(str);
        this.iUY = 4;
    }

    public void crK() {
        this.iVb.setVisibility(0);
        this.iVc = false;
        crO();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iUY = 1;
    }

    public void crL() {
        this.iVc = false;
        crO();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.iVb.setVisibility(8);
        this.iUY = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVa.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iUZ.getLayoutMode().setNightMode(z);
        this.iUZ.getLayoutMode().onModeChanged(this.mView);
        this.iVa.startLoad(c.a(this.iUZ.getActivity(), c.iVe, z), 29, false);
        crO();
    }

    private void crO() {
        if (this.iVc) {
            Drawable drawable = ao.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            ao.setViewTextColor(this.mTipView, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        ao.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iUZ.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVd) {
            return this.iUZ.getPageContext().getString(R.string.next_step);
        }
        return this.iUZ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}
