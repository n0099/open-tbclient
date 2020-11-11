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
    CreateGroupStepActivity kac;
    TbImageView kad;
    private ImageView kae;
    private int kag;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int kab = 3;
    private boolean kaf = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kac = null;
        this.mView = null;
        this.kad = null;
        this.mTipView = null;
        this.kae = null;
        this.kac = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.kad = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.kae = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.kag = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPw() {
        return this.mIndex;
    }

    public View cPx() {
        return this.mTipView;
    }

    public int cPy() {
        return this.kab;
    }

    public void cPz() {
        this.kae.setVisibility(0);
        this.kaf = false;
        cPE();
        this.mTipView.setText(R.string.location_loading);
        this.kab = 3;
    }

    public void setBusiness(String str) {
        this.kae.setVisibility(0);
        this.kaf = true;
        cPE();
        this.mTipView.setText(str);
        this.kab = 0;
    }

    public void setAddress(String str) {
        this.kae.setVisibility(8);
        this.kaf = true;
        cPE();
        this.mTipView.setText(str);
        this.kab = 4;
    }

    public void cPA() {
        this.kae.setVisibility(0);
        this.kaf = false;
        cPE();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.kab = 1;
    }

    public void cPB() {
        this.kaf = false;
        cPE();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.kae.setVisibility(8);
        this.kab = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPC() {
        this.kad.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kac.getLayoutMode().setNightMode(z);
        this.kac.getLayoutMode().onModeChanged(this.mView);
        this.kad.startLoad(c.a(this.kac.getActivity(), c.kah, z), 29, false);
        cPE();
    }

    private void cPE() {
        if (this.kaf) {
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
        return String.format(this.kac.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPF() {
        if (this.mIndex != this.kag) {
            return this.kac.getPageContext().getString(R.string.next_step);
        }
        return this.kac.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPG() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPH() {
        return true;
    }
}
