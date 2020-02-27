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
    CreateGroupStepActivity hvO;
    TbImageView hvP;
    private ImageView hvQ;
    private int hvS;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int hvN = 3;
    private boolean hvR = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvO = null;
        this.mView = null;
        this.hvP = null;
        this.mTipView = null;
        this.hvQ = null;
        this.hvO = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.hvP = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.hvQ = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.hvS = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSK() {
        return this.mIndex;
    }

    public View bSL() {
        return this.mTipView;
    }

    public int bSM() {
        return this.hvN;
    }

    public void bSN() {
        this.hvQ.setVisibility(0);
        this.hvR = false;
        bSS();
        this.mTipView.setText(R.string.location_loading);
        this.hvN = 3;
    }

    public void setBusiness(String str) {
        this.hvQ.setVisibility(0);
        this.hvR = true;
        bSS();
        this.mTipView.setText(str);
        this.hvN = 0;
    }

    public void setAddress(String str) {
        this.hvQ.setVisibility(8);
        this.hvR = true;
        bSS();
        this.mTipView.setText(str);
        this.hvN = 4;
    }

    public void bSO() {
        this.hvQ.setVisibility(0);
        this.hvR = false;
        bSS();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.hvN = 1;
    }

    public void bSP() {
        this.hvR = false;
        bSS();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.hvQ.setVisibility(8);
        this.hvN = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSQ() {
        this.hvP.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSR() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvO.getLayoutMode().setNightMode(z);
        this.hvO.getLayoutMode().onModeChanged(this.mView);
        this.hvP.startLoad(c.a(this.hvO.getActivity(), c.hvT, z), 29, false);
        bSS();
    }

    private void bSS() {
        if (this.hvR) {
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
        return String.format(this.hvO.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bST() {
        if (this.mIndex != this.hvS) {
            return this.hvO.getPageContext().getString(R.string.next_step);
        }
        return this.hvO.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSU() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSV() {
        return true;
    }
}
