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
    CreateGroupStepActivity iVb;
    TbImageView iVc;
    private ImageView iVd;
    private int iVf;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iVa = 3;
    private boolean iVe = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iVb = null;
        this.mView = null;
        this.iVc = null;
        this.mTipView = null;
        this.iVd = null;
        this.iVb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.iVc = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.iVd = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iVf = i3;
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
        return this.iVa;
    }

    public void crJ() {
        this.iVd.setVisibility(0);
        this.iVe = false;
        crO();
        this.mTipView.setText(R.string.location_loading);
        this.iVa = 3;
    }

    public void setBusiness(String str) {
        this.iVd.setVisibility(0);
        this.iVe = true;
        crO();
        this.mTipView.setText(str);
        this.iVa = 0;
    }

    public void setAddress(String str) {
        this.iVd.setVisibility(8);
        this.iVe = true;
        crO();
        this.mTipView.setText(str);
        this.iVa = 4;
    }

    public void crK() {
        this.iVd.setVisibility(0);
        this.iVe = false;
        crO();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iVa = 1;
    }

    public void crL() {
        this.iVe = false;
        crO();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.iVd.setVisibility(8);
        this.iVa = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iVb.getLayoutMode().setNightMode(z);
        this.iVb.getLayoutMode().onModeChanged(this.mView);
        this.iVc.startLoad(c.a(this.iVb.getActivity(), c.iVg, z), 29, false);
        crO();
    }

    private void crO() {
        if (this.iVe) {
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
        return String.format(this.iVb.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVf) {
            return this.iVb.getPageContext().getString(R.string.next_step);
        }
        return this.iVb.getPageContext().getString(R.string.group_create_step_done_tip);
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
