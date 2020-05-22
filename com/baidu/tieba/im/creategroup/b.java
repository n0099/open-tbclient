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
    CreateGroupStepActivity iwe;
    TbImageView iwf;
    private ImageView iwg;
    private int iwi;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int iwd = 3;
    private boolean iwh = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwe = null;
        this.mView = null;
        this.iwf = null;
        this.mTipView = null;
        this.iwg = null;
        this.iwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.iwf = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.iwg = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.iwi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckc() {
        return this.mIndex;
    }

    public View ckd() {
        return this.mTipView;
    }

    public int cke() {
        return this.iwd;
    }

    public void ckf() {
        this.iwg.setVisibility(0);
        this.iwh = false;
        ckk();
        this.mTipView.setText(R.string.location_loading);
        this.iwd = 3;
    }

    public void setBusiness(String str) {
        this.iwg.setVisibility(0);
        this.iwh = true;
        ckk();
        this.mTipView.setText(str);
        this.iwd = 0;
    }

    public void setAddress(String str) {
        this.iwg.setVisibility(8);
        this.iwh = true;
        ckk();
        this.mTipView.setText(str);
        this.iwd = 4;
    }

    public void ckg() {
        this.iwg.setVisibility(0);
        this.iwh = false;
        ckk();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.iwd = 1;
    }

    public void ckh() {
        this.iwh = false;
        ckk();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.iwg.setVisibility(8);
        this.iwd = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cki() {
        this.iwf.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwe.getLayoutMode().setNightMode(z);
        this.iwe.getLayoutMode().onModeChanged(this.mView);
        this.iwf.startLoad(c.a(this.iwe.getActivity(), c.iwj, z), 29, false);
        ckk();
    }

    private void ckk() {
        if (this.iwh) {
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
        return String.format(this.iwe.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String ckl() {
        if (this.mIndex != this.iwi) {
            return this.iwe.getPageContext().getString(R.string.next_step);
        }
        return this.iwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckm() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckn() {
        return true;
    }
}
