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
    CreateGroupStepActivity kor;
    TbImageView kos;
    private ImageView kot;
    private int kov;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int koq = 3;
    private boolean kou = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kor = null;
        this.mView = null;
        this.kos = null;
        this.mTipView = null;
        this.kot = null;
        this.kor = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.kos = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.kot = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.kov = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUq() {
        return this.mIndex;
    }

    public View cUr() {
        return this.mTipView;
    }

    public int cUs() {
        return this.koq;
    }

    public void cUt() {
        this.kot.setVisibility(0);
        this.kou = false;
        cUy();
        this.mTipView.setText(R.string.location_loading);
        this.koq = 3;
    }

    public void setBusiness(String str) {
        this.kot.setVisibility(0);
        this.kou = true;
        cUy();
        this.mTipView.setText(str);
        this.koq = 0;
    }

    public void setAddress(String str) {
        this.kot.setVisibility(8);
        this.kou = true;
        cUy();
        this.mTipView.setText(str);
        this.koq = 4;
    }

    public void cUu() {
        this.kot.setVisibility(0);
        this.kou = false;
        cUy();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.koq = 1;
    }

    public void cUv() {
        this.kou = false;
        cUy();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.kot.setVisibility(8);
        this.koq = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUw() {
        this.kos.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kor.getLayoutMode().setNightMode(z);
        this.kor.getLayoutMode().onModeChanged(this.mView);
        this.kos.startLoad(c.a(this.kor.getActivity(), c.kow, z), 29, false);
        cUy();
    }

    private void cUy() {
        if (this.kou) {
            Drawable drawable = ap.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mTipView.setCompoundDrawables(drawable, null, null, null);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0105, 1);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.mTipView.setCompoundDrawables(drawable2, null, null, null);
        ap.setViewTextColor(this.mTipView, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kor.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUz() {
        if (this.mIndex != this.kov) {
            return this.kor.getPageContext().getString(R.string.next_step);
        }
        return this.kor.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUA() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return true;
    }
}
