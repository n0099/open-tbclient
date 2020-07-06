package com.baidu.tieba.im.creategroup;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b implements o {
    CreateGroupStepActivity iNW;
    TbImageView iNX;
    private ImageView iNY;
    private int iOa;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iNV = 3;
    private boolean iNZ = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iNW = null;
        this.mView = null;
        this.iNX = null;
        this.mTipView = null;
        this.iNY = null;
        this.iNW = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.iNX = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.iNY = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iOa = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cob() {
        return this.mIndex;
    }

    public View coc() {
        return this.mTipView;
    }

    public int cod() {
        return this.iNV;
    }

    public void coe() {
        this.iNY.setVisibility(0);
        this.iNZ = false;
        coj();
        this.mTipView.setText(R.string.location_loading);
        this.iNV = 3;
    }

    public void setBusiness(String str) {
        this.iNY.setVisibility(0);
        this.iNZ = true;
        coj();
        this.mTipView.setText(str);
        this.iNV = 0;
    }

    public void setAddress(String str) {
        this.iNY.setVisibility(8);
        this.iNZ = true;
        coj();
        this.mTipView.setText(str);
        this.iNV = 4;
    }

    public void cof() {
        this.iNY.setVisibility(0);
        this.iNZ = false;
        coj();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iNV = 1;
    }

    public void cog() {
        this.iNZ = false;
        coj();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.iNY.setVisibility(8);
        this.iNV = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coh() {
        this.iNX.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coi() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iNW.getLayoutMode().setNightMode(z);
        this.iNW.getLayoutMode().onModeChanged(this.mView);
        this.iNX.startLoad(c.a(this.iNW.getActivity(), c.iOb, z), 29, false);
        coj();
    }

    private void coj() {
        if (this.iNZ) {
            Drawable drawable = an.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            an.setViewTextColor(this.mTipView, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = an.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        an.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iNW.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cok() {
        if (this.mIndex != this.iOa) {
            return this.iNW.getPageContext().getString(R.string.next_step);
        }
        return this.iNW.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean col() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean com() {
        return true;
    }
}
