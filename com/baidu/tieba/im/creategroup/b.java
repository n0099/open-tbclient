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
/* loaded from: classes5.dex */
public class b implements o {
    CreateGroupStepActivity gCY;
    TbImageView gCZ;
    private ImageView gDa;
    private int gDc;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int gCX = 3;
    private boolean gDb = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCY = null;
        this.mView = null;
        this.gCZ = null;
        this.mTipView = null;
        this.gDa = null;
        this.gCY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gCZ = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gDa = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.gDc = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byL() {
        return this.mIndex;
    }

    public View byM() {
        return this.mTipView;
    }

    public int byN() {
        return this.gCX;
    }

    public void byO() {
        this.gDa.setVisibility(0);
        this.gDb = false;
        byT();
        this.mTipView.setText(R.string.location_loading);
        this.gCX = 3;
    }

    public void setBusiness(String str) {
        this.gDa.setVisibility(0);
        this.gDb = true;
        byT();
        this.mTipView.setText(str);
        this.gCX = 0;
    }

    public void setAddress(String str) {
        this.gDa.setVisibility(8);
        this.gDb = true;
        byT();
        this.mTipView.setText(str);
        this.gCX = 4;
    }

    public void byP() {
        this.gDa.setVisibility(0);
        this.gDb = false;
        byT();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.gCX = 1;
    }

    public void byQ() {
        this.gDb = false;
        byT();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.gDa.setVisibility(8);
        this.gCX = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byR() {
        this.gCZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byS() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCY.getLayoutMode().setNightMode(z);
        this.gCY.getLayoutMode().onModeChanged(this.mView);
        this.gCZ.startLoad(c.a(this.gCY.getActivity(), c.gDd, z), 29, false);
        byT();
    }

    private void byT() {
        if (this.gDb) {
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
        return String.format(this.gCY.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byU() {
        if (this.mIndex != this.gDc) {
            return this.gCY.getPageContext().getString(R.string.next_step);
        }
        return this.gCY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byV() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byW() {
        return true;
    }
}
