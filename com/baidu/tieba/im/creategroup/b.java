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
    TextView bOs;
    CreateGroupStepActivity gDh;
    TbImageView gDi;
    private ImageView gDj;
    private int gDl;
    private int mIndex;
    View mView;
    private int gDg = 3;
    private boolean gDk = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gDh = null;
        this.mView = null;
        this.gDi = null;
        this.bOs = null;
        this.gDj = null;
        this.gDh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gDi = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bOs = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gDj = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Nk = i2;
        this.gDl = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bBm() {
        return this.mIndex;
    }

    public View bBn() {
        return this.bOs;
    }

    public int bBo() {
        return this.gDg;
    }

    public void bBp() {
        this.gDj.setVisibility(0);
        this.gDk = false;
        bBu();
        this.bOs.setText(R.string.location_loading);
        this.gDg = 3;
    }

    public void setBusiness(String str) {
        this.gDj.setVisibility(0);
        this.gDk = true;
        bBu();
        this.bOs.setText(str);
        this.gDg = 0;
    }

    public void setAddress(String str) {
        this.gDj.setVisibility(8);
        this.gDk = true;
        bBu();
        this.bOs.setText(str);
        this.gDg = 4;
    }

    public void bBq() {
        this.gDj.setVisibility(0);
        this.gDk = false;
        bBu();
        this.bOs.setText(R.string.address_locate_failed_opengps);
        this.gDg = 1;
    }

    public void bBr() {
        this.gDk = false;
        bBu();
        this.bOs.setText(R.string.address_locate_failed_tryagain);
        this.gDj.setVisibility(8);
        this.gDg = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBs() {
        this.gDi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBt() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gDh.getLayoutMode().setNightMode(z);
        this.gDh.getLayoutMode().onModeChanged(this.mView);
        this.gDi.startLoad(c.a(this.gDh.getActivity(), c.gDm, z), 29, false);
        bBu();
    }

    private void bBu() {
        if (this.gDk) {
            Drawable drawable = am.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bOs.setCompoundDrawables(drawable, null, null, null);
            am.f(this.bOs, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bOs.setCompoundDrawables(drawable2, null, null, null);
        am.f(this.bOs, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gDh.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBv() {
        if (this.mIndex != this.gDl) {
            return this.gDh.getPageContext().getString(R.string.next_step);
        }
        return this.gDh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBw() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBx() {
        return true;
    }
}
