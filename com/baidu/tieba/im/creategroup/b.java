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
    CreateGroupStepActivity hvQ;
    TbImageView hvR;
    private ImageView hvS;
    private int hvU;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int hvP = 3;
    private boolean hvT = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvQ = null;
        this.mView = null;
        this.hvR = null;
        this.mTipView = null;
        this.hvS = null;
        this.hvQ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.hvR = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.hvS = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.hvU = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSM() {
        return this.mIndex;
    }

    public View bSN() {
        return this.mTipView;
    }

    public int bSO() {
        return this.hvP;
    }

    public void bSP() {
        this.hvS.setVisibility(0);
        this.hvT = false;
        bSU();
        this.mTipView.setText(R.string.location_loading);
        this.hvP = 3;
    }

    public void setBusiness(String str) {
        this.hvS.setVisibility(0);
        this.hvT = true;
        bSU();
        this.mTipView.setText(str);
        this.hvP = 0;
    }

    public void setAddress(String str) {
        this.hvS.setVisibility(8);
        this.hvT = true;
        bSU();
        this.mTipView.setText(str);
        this.hvP = 4;
    }

    public void bSQ() {
        this.hvS.setVisibility(0);
        this.hvT = false;
        bSU();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.hvP = 1;
    }

    public void bSR() {
        this.hvT = false;
        bSU();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.hvS.setVisibility(8);
        this.hvP = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSS() {
        this.hvR.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvQ.getLayoutMode().setNightMode(z);
        this.hvQ.getLayoutMode().onModeChanged(this.mView);
        this.hvR.startLoad(c.a(this.hvQ.getActivity(), c.hvV, z), 29, false);
        bSU();
    }

    private void bSU() {
        if (this.hvT) {
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
        return String.format(this.hvQ.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSV() {
        if (this.mIndex != this.hvU) {
            return this.hvQ.getPageContext().getString(R.string.next_step);
        }
        return this.hvQ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSW() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }
}
