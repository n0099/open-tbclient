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
/* loaded from: classes17.dex */
public class b implements o {
    CreateGroupStepActivity jkg;
    TbImageView jkh;
    private ImageView jki;
    private int jkk;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int jkf = 3;
    private boolean jkj = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jkg = null;
        this.mView = null;
        this.jkh = null;
        this.mTipView = null;
        this.jki = null;
        this.jkg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.jkh = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.jki = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.jkk = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCz() {
        return this.mIndex;
    }

    public View cCA() {
        return this.mTipView;
    }

    public int cCB() {
        return this.jkf;
    }

    public void cCC() {
        this.jki.setVisibility(0);
        this.jkj = false;
        cCH();
        this.mTipView.setText(R.string.location_loading);
        this.jkf = 3;
    }

    public void setBusiness(String str) {
        this.jki.setVisibility(0);
        this.jkj = true;
        cCH();
        this.mTipView.setText(str);
        this.jkf = 0;
    }

    public void setAddress(String str) {
        this.jki.setVisibility(8);
        this.jkj = true;
        cCH();
        this.mTipView.setText(str);
        this.jkf = 4;
    }

    public void cCD() {
        this.jki.setVisibility(0);
        this.jkj = false;
        cCH();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.jkf = 1;
    }

    public void cCE() {
        this.jkj = false;
        cCH();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.jki.setVisibility(8);
        this.jkf = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jkh.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCG() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jkg.getLayoutMode().setNightMode(z);
        this.jkg.getLayoutMode().onModeChanged(this.mView);
        this.jkh.startLoad(c.a(this.jkg.getActivity(), c.jkl, z), 29, false);
        cCH();
    }

    private void cCH() {
        if (this.jkj) {
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
        return String.format(this.jkg.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCI() {
        if (this.mIndex != this.jkk) {
            return this.jkg.getPageContext().getString(R.string.next_step);
        }
        return this.jkg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCK() {
        return true;
    }
}
