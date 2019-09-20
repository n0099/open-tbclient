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
    private int Nl;
    TextView bOT;
    CreateGroupStepActivity gEY;
    TbImageView gEZ;
    private ImageView gFa;
    private int gFc;
    private int mIndex;
    View mView;
    private int gEX = 3;
    private boolean gFb = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gEY = null;
        this.mView = null;
        this.gEZ = null;
        this.bOT = null;
        this.gFa = null;
        this.gEY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gEZ = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.bOT = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gFa = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.Nl = i2;
        this.gFc = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bCa() {
        return this.mIndex;
    }

    public View bCb() {
        return this.bOT;
    }

    public int bCc() {
        return this.gEX;
    }

    public void bCd() {
        this.gFa.setVisibility(0);
        this.gFb = false;
        bCi();
        this.bOT.setText(R.string.location_loading);
        this.gEX = 3;
    }

    public void setBusiness(String str) {
        this.gFa.setVisibility(0);
        this.gFb = true;
        bCi();
        this.bOT.setText(str);
        this.gEX = 0;
    }

    public void setAddress(String str) {
        this.gFa.setVisibility(8);
        this.gFb = true;
        bCi();
        this.bOT.setText(str);
        this.gEX = 4;
    }

    public void bCe() {
        this.gFa.setVisibility(0);
        this.gFb = false;
        bCi();
        this.bOT.setText(R.string.address_locate_failed_opengps);
        this.gEX = 1;
    }

    public void bCf() {
        this.gFb = false;
        bCi();
        this.bOT.setText(R.string.address_locate_failed_tryagain);
        this.gFa.setVisibility(8);
        this.gEX = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCg() {
        this.gEZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gEY.getLayoutMode().setNightMode(z);
        this.gEY.getLayoutMode().onModeChanged(this.mView);
        this.gEZ.startLoad(c.a(this.gEY.getActivity(), c.gFd, z), 29, false);
        bCi();
    }

    private void bCi() {
        if (this.gFb) {
            Drawable drawable = am.getDrawable(R.drawable.icon_jq_lbs_s);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bOT.setCompoundDrawables(drawable, null, null, null);
            am.f(this.bOT, R.color.cp_cont_b, 1);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.icon_jq_lbs_n);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.bOT.setCompoundDrawables(drawable2, null, null, null);
        am.f(this.bOT, R.color.common_color_10077, 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gEY.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.Nl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bCj() {
        if (this.mIndex != this.gFc) {
            return this.gEY.getPageContext().getString(R.string.next_step);
        }
        return this.gEY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCk() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCl() {
        return true;
    }
}
