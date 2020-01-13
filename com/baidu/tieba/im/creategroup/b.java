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
/* loaded from: classes8.dex */
public class b implements o {
    CreateGroupStepActivity htP;
    TbImageView htQ;
    private ImageView htR;
    private int htT;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int htO = 3;
    private boolean htS = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.htP = null;
        this.mView = null;
        this.htQ = null;
        this.mTipView = null;
        this.htR = null;
        this.htP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.htQ = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.htR = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.htT = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bRj() {
        return this.mIndex;
    }

    public View bRk() {
        return this.mTipView;
    }

    public int bRl() {
        return this.htO;
    }

    public void bRm() {
        this.htR.setVisibility(0);
        this.htS = false;
        bRr();
        this.mTipView.setText(R.string.location_loading);
        this.htO = 3;
    }

    public void setBusiness(String str) {
        this.htR.setVisibility(0);
        this.htS = true;
        bRr();
        this.mTipView.setText(str);
        this.htO = 0;
    }

    public void setAddress(String str) {
        this.htR.setVisibility(8);
        this.htS = true;
        bRr();
        this.mTipView.setText(str);
        this.htO = 4;
    }

    public void bRn() {
        this.htR.setVisibility(0);
        this.htS = false;
        bRr();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.htO = 1;
    }

    public void bRo() {
        this.htS = false;
        bRr();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.htR.setVisibility(8);
        this.htO = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRp() {
        this.htQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRq() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.htP.getLayoutMode().setNightMode(z);
        this.htP.getLayoutMode().onModeChanged(this.mView);
        this.htQ.startLoad(c.a(this.htP.getActivity(), c.htU, z), 29, false);
        bRr();
    }

    private void bRr() {
        if (this.htS) {
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
        return String.format(this.htP.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bRs() {
        if (this.mIndex != this.htT) {
            return this.htP.getPageContext().getString(R.string.next_step);
        }
        return this.htP.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRt() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRu() {
        return true;
    }
}
