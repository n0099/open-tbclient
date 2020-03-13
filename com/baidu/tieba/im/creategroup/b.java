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
    CreateGroupStepActivity hwc;
    TbImageView hwd;
    private ImageView hwe;
    private int hwg;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int hwb = 3;
    private boolean hwf = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hwc = null;
        this.mView = null;
        this.hwd = null;
        this.mTipView = null;
        this.hwe = null;
        this.hwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.hwd = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.hwe = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.hwg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSN() {
        return this.mIndex;
    }

    public View bSO() {
        return this.mTipView;
    }

    public int bSP() {
        return this.hwb;
    }

    public void bSQ() {
        this.hwe.setVisibility(0);
        this.hwf = false;
        bSV();
        this.mTipView.setText(R.string.location_loading);
        this.hwb = 3;
    }

    public void setBusiness(String str) {
        this.hwe.setVisibility(0);
        this.hwf = true;
        bSV();
        this.mTipView.setText(str);
        this.hwb = 0;
    }

    public void setAddress(String str) {
        this.hwe.setVisibility(8);
        this.hwf = true;
        bSV();
        this.mTipView.setText(str);
        this.hwb = 4;
    }

    public void bSR() {
        this.hwe.setVisibility(0);
        this.hwf = false;
        bSV();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.hwb = 1;
    }

    public void bSS() {
        this.hwf = false;
        bSV();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.hwe.setVisibility(8);
        this.hwb = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hwd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSU() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hwc.getLayoutMode().setNightMode(z);
        this.hwc.getLayoutMode().onModeChanged(this.mView);
        this.hwd.startLoad(c.a(this.hwc.getActivity(), c.hwh, z), 29, false);
        bSV();
    }

    private void bSV() {
        if (this.hwf) {
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
        return String.format(this.hwc.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSW() {
        if (this.mIndex != this.hwg) {
            return this.hwc.getPageContext().getString(R.string.next_step);
        }
        return this.hwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSY() {
        return true;
    }
}
