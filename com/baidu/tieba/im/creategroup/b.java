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
/* loaded from: classes23.dex */
public class b implements o {
    CreateGroupStepActivity jHH;
    TbImageView jHI;
    private ImageView jHJ;
    private int jHL;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int jHG = 3;
    private boolean jHK = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jHH = null;
        this.mView = null;
        this.jHI = null;
        this.mTipView = null;
        this.jHJ = null;
        this.jHH = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.jHI = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.jHJ = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.jHL = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cJO() {
        return this.mIndex;
    }

    public View cJP() {
        return this.mTipView;
    }

    public int cJQ() {
        return this.jHG;
    }

    public void cJR() {
        this.jHJ.setVisibility(0);
        this.jHK = false;
        cJW();
        this.mTipView.setText(R.string.location_loading);
        this.jHG = 3;
    }

    public void setBusiness(String str) {
        this.jHJ.setVisibility(0);
        this.jHK = true;
        cJW();
        this.mTipView.setText(str);
        this.jHG = 0;
    }

    public void setAddress(String str) {
        this.jHJ.setVisibility(8);
        this.jHK = true;
        cJW();
        this.mTipView.setText(str);
        this.jHG = 4;
    }

    public void cJS() {
        this.jHJ.setVisibility(0);
        this.jHK = false;
        cJW();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.jHG = 1;
    }

    public void cJT() {
        this.jHK = false;
        cJW();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.jHJ.setVisibility(8);
        this.jHG = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJU() {
        this.jHI.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJV() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jHH.getLayoutMode().setNightMode(z);
        this.jHH.getLayoutMode().onModeChanged(this.mView);
        this.jHI.startLoad(c.a(this.jHH.getActivity(), c.jHM, z), 29, false);
        cJW();
    }

    private void cJW() {
        if (this.jHK) {
            Drawable drawable = ap.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            ap.setViewTextColor(this.mTipView, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        ap.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jHH.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cJX() {
        if (this.mIndex != this.jHL) {
            return this.jHH.getPageContext().getString(R.string.next_step);
        }
        return this.jHH.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJY() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJZ() {
        return true;
    }
}
