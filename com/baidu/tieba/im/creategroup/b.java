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
    CreateGroupStepActivity hxC;
    TbImageView hxD;
    private ImageView hxE;
    private int hxG;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int hxB = 3;
    private boolean hxF = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hxC = null;
        this.mView = null;
        this.hxD = null;
        this.mTipView = null;
        this.hxE = null;
        this.hxC = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.hxD = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.hxE = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.hxG = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bTf() {
        return this.mIndex;
    }

    public View bTg() {
        return this.mTipView;
    }

    public int bTh() {
        return this.hxB;
    }

    public void bTi() {
        this.hxE.setVisibility(0);
        this.hxF = false;
        bTn();
        this.mTipView.setText(R.string.location_loading);
        this.hxB = 3;
    }

    public void setBusiness(String str) {
        this.hxE.setVisibility(0);
        this.hxF = true;
        bTn();
        this.mTipView.setText(str);
        this.hxB = 0;
    }

    public void setAddress(String str) {
        this.hxE.setVisibility(8);
        this.hxF = true;
        bTn();
        this.mTipView.setText(str);
        this.hxB = 4;
    }

    public void bTj() {
        this.hxE.setVisibility(0);
        this.hxF = false;
        bTn();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.hxB = 1;
    }

    public void bTk() {
        this.hxF = false;
        bTn();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.hxE.setVisibility(8);
        this.hxB = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTl() {
        this.hxD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hxC.getLayoutMode().setNightMode(z);
        this.hxC.getLayoutMode().onModeChanged(this.mView);
        this.hxD.startLoad(c.a(this.hxC.getActivity(), c.hxH, z), 29, false);
        bTn();
    }

    private void bTn() {
        if (this.hxF) {
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
        return String.format(this.hxC.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bTo() {
        if (this.mIndex != this.hxG) {
            return this.hxC.getPageContext().getString(R.string.next_step);
        }
        return this.hxC.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTp() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTq() {
        return true;
    }
}
