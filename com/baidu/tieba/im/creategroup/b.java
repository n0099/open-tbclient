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
    CreateGroupStepActivity jUg;
    TbImageView jUh;
    private ImageView jUi;
    private int jUk;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int jUf = 3;
    private boolean jUj = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jUg = null;
        this.mView = null;
        this.jUh = null;
        this.mTipView = null;
        this.jUi = null;
        this.jUg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.jUh = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.jUi = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.jUk = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cMV() {
        return this.mIndex;
    }

    public View cMW() {
        return this.mTipView;
    }

    public int cMX() {
        return this.jUf;
    }

    public void cMY() {
        this.jUi.setVisibility(0);
        this.jUj = false;
        cNd();
        this.mTipView.setText(R.string.location_loading);
        this.jUf = 3;
    }

    public void setBusiness(String str) {
        this.jUi.setVisibility(0);
        this.jUj = true;
        cNd();
        this.mTipView.setText(str);
        this.jUf = 0;
    }

    public void setAddress(String str) {
        this.jUi.setVisibility(8);
        this.jUj = true;
        cNd();
        this.mTipView.setText(str);
        this.jUf = 4;
    }

    public void cMZ() {
        this.jUi.setVisibility(0);
        this.jUj = false;
        cNd();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.jUf = 1;
    }

    public void cNa() {
        this.jUj = false;
        cNd();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.jUi.setVisibility(8);
        this.jUf = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNb() {
        this.jUh.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jUg.getLayoutMode().setNightMode(z);
        this.jUg.getLayoutMode().onModeChanged(this.mView);
        this.jUh.startLoad(c.a(this.jUg.getActivity(), c.jUl, z), 29, false);
        cNd();
    }

    private void cNd() {
        if (this.jUj) {
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
        return String.format(this.jUg.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cNe() {
        if (this.mIndex != this.jUk) {
            return this.jUg.getPageContext().getString(R.string.next_step);
        }
        return this.jUg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNf() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNg() {
        return true;
    }
}
