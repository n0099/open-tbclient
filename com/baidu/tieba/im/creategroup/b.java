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
    private int Nk;
    TextView bOn;
    CreateGroupStepActivity gCp;
    TbImageView gCq;
    private ImageView gCr;
    private int gCt;
    private int mIndex;
    View mView;
    private int gCo = 3;
    private boolean gCs = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCp = null;
        this.mView = null;
        this.gCq = null;
        this.bOn = null;
        this.gCr = null;
        this.gCp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gCq = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bOn = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gCr = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Nk = i2;
        this.gCt = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bAY() {
        return this.mIndex;
    }

    public View bAZ() {
        return this.bOn;
    }

    public int bBa() {
        return this.gCo;
    }

    public void bBb() {
        this.gCr.setVisibility(0);
        this.gCs = false;
        bBg();
        this.bOn.setText(R.string.location_loading);
        this.gCo = 3;
    }

    public void setBusiness(String str) {
        this.gCr.setVisibility(0);
        this.gCs = true;
        bBg();
        this.bOn.setText(str);
        this.gCo = 0;
    }

    public void setAddress(String str) {
        this.gCr.setVisibility(8);
        this.gCs = true;
        bBg();
        this.bOn.setText(str);
        this.gCo = 4;
    }

    public void bBc() {
        this.gCr.setVisibility(0);
        this.gCs = false;
        bBg();
        this.bOn.setText(R.string.address_locate_failed_opengps);
        this.gCo = 1;
    }

    public void bBd() {
        this.gCs = false;
        bBg();
        this.bOn.setText(R.string.address_locate_failed_tryagain);
        this.gCr.setVisibility(8);
        this.gCo = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBe() {
        this.gCq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCp.getLayoutMode().setNightMode(z);
        this.gCp.getLayoutMode().onModeChanged(this.mView);
        this.gCq.startLoad(c.a(this.gCp.getActivity(), c.gCu, z), 29, false);
        bBg();
    }

    private void bBg() {
        if (this.gCs) {
            Drawable drawable = am.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bOn.setCompoundDrawables(drawable, null, null, null);
            am.f(this.bOn, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bOn.setCompoundDrawables(drawable2, null, null, null);
        am.f(this.bOn, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCp.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBh() {
        if (this.mIndex != this.gCt) {
            return this.gCp.getPageContext().getString(R.string.next_step);
        }
        return this.gCp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBi() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBj() {
        return true;
    }
}
