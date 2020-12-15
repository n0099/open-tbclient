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
    CreateGroupStepActivity kot;
    TbImageView kou;
    private ImageView kov;
    private int kox;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int kos = 3;
    private boolean kow = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kot = null;
        this.mView = null;
        this.kou = null;
        this.mTipView = null;
        this.kov = null;
        this.kot = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.kou = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.kov = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.kox = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUr() {
        return this.mIndex;
    }

    public View cUs() {
        return this.mTipView;
    }

    public int cUt() {
        return this.kos;
    }

    public void cUu() {
        this.kov.setVisibility(0);
        this.kow = false;
        cUz();
        this.mTipView.setText(R.string.location_loading);
        this.kos = 3;
    }

    public void setBusiness(String str) {
        this.kov.setVisibility(0);
        this.kow = true;
        cUz();
        this.mTipView.setText(str);
        this.kos = 0;
    }

    public void setAddress(String str) {
        this.kov.setVisibility(8);
        this.kow = true;
        cUz();
        this.mTipView.setText(str);
        this.kos = 4;
    }

    public void cUv() {
        this.kov.setVisibility(0);
        this.kow = false;
        cUz();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.kos = 1;
    }

    public void cUw() {
        this.kow = false;
        cUz();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.kov.setVisibility(8);
        this.kos = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        this.kou.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kot.getLayoutMode().setNightMode(z);
        this.kot.getLayoutMode().onModeChanged(this.mView);
        this.kou.startLoad(c.a(this.kot.getActivity(), c.koy, z), 29, false);
        cUz();
    }

    private void cUz() {
        if (this.kow) {
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
        return String.format(this.kot.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUA() {
        if (this.mIndex != this.kox) {
            return this.kot.getPageContext().getString(R.string.next_step);
        }
        return this.kot.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUC() {
        return true;
    }
}
