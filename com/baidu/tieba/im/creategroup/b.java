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
    CreateGroupStepActivity jka;
    TbImageView jkb;
    private ImageView jkc;
    private int jke;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int jjZ = 3;
    private boolean jkd = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jka = null;
        this.mView = null;
        this.jkb = null;
        this.mTipView = null;
        this.jkc = null;
        this.jka = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.jkb = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.jkc = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.jke = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCy() {
        return this.mIndex;
    }

    public View cCz() {
        return this.mTipView;
    }

    public int cCA() {
        return this.jjZ;
    }

    public void cCB() {
        this.jkc.setVisibility(0);
        this.jkd = false;
        cCG();
        this.mTipView.setText(R.string.location_loading);
        this.jjZ = 3;
    }

    public void setBusiness(String str) {
        this.jkc.setVisibility(0);
        this.jkd = true;
        cCG();
        this.mTipView.setText(str);
        this.jjZ = 0;
    }

    public void setAddress(String str) {
        this.jkc.setVisibility(8);
        this.jkd = true;
        cCG();
        this.mTipView.setText(str);
        this.jjZ = 4;
    }

    public void cCC() {
        this.jkc.setVisibility(0);
        this.jkd = false;
        cCG();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.jjZ = 1;
    }

    public void cCD() {
        this.jkd = false;
        cCG();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.jkc.setVisibility(8);
        this.jjZ = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCE() {
        this.jkb.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jka.getLayoutMode().setNightMode(z);
        this.jka.getLayoutMode().onModeChanged(this.mView);
        this.jkb.startLoad(c.a(this.jka.getActivity(), c.jkf, z), 29, false);
        cCG();
    }

    private void cCG() {
        if (this.jkd) {
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
        return String.format(this.jka.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCH() {
        if (this.mIndex != this.jke) {
            return this.jka.getPageContext().getString(R.string.next_step);
        }
        return this.jka.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }
}
