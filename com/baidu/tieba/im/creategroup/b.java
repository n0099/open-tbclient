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
    CreateGroupStepActivity jsK;
    TbImageView jsL;
    private ImageView jsM;
    private int jsO;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int jsJ = 3;
    private boolean jsN = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jsK = null;
        this.mView = null;
        this.jsL = null;
        this.mTipView = null;
        this.jsM = null;
        this.jsK = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.jsL = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.jsM = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.jsO = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cGf() {
        return this.mIndex;
    }

    public View cGg() {
        return this.mTipView;
    }

    public int cGh() {
        return this.jsJ;
    }

    public void cGi() {
        this.jsM.setVisibility(0);
        this.jsN = false;
        cGn();
        this.mTipView.setText(R.string.location_loading);
        this.jsJ = 3;
    }

    public void setBusiness(String str) {
        this.jsM.setVisibility(0);
        this.jsN = true;
        cGn();
        this.mTipView.setText(str);
        this.jsJ = 0;
    }

    public void setAddress(String str) {
        this.jsM.setVisibility(8);
        this.jsN = true;
        cGn();
        this.mTipView.setText(str);
        this.jsJ = 4;
    }

    public void cGj() {
        this.jsM.setVisibility(0);
        this.jsN = false;
        cGn();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.jsJ = 1;
    }

    public void cGk() {
        this.jsN = false;
        cGn();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.jsM.setVisibility(8);
        this.jsJ = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGl() {
        this.jsL.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jsK.getLayoutMode().setNightMode(z);
        this.jsK.getLayoutMode().onModeChanged(this.mView);
        this.jsL.startLoad(c.a(this.jsK.getActivity(), c.jsP, z), 29, false);
        cGn();
    }

    private void cGn() {
        if (this.jsN) {
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
        return String.format(this.jsK.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cGo() {
        if (this.mIndex != this.jsO) {
            return this.jsK.getPageContext().getString(R.string.next_step);
        }
        return this.jsK.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGp() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGq() {
        return true;
    }
}
