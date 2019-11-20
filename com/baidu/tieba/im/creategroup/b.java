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
    CreateGroupStepActivity gCh;
    TbImageView gCi;
    private ImageView gCj;
    private int gCl;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int gCg = 3;
    private boolean gCk = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCh = null;
        this.mView = null;
        this.gCi = null;
        this.mTipView = null;
        this.gCj = null;
        this.gCh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.gCi = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.gCj = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.gCl = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byJ() {
        return this.mIndex;
    }

    public View byK() {
        return this.mTipView;
    }

    public int byL() {
        return this.gCg;
    }

    public void byM() {
        this.gCj.setVisibility(0);
        this.gCk = false;
        byR();
        this.mTipView.setText(R.string.location_loading);
        this.gCg = 3;
    }

    public void setBusiness(String str) {
        this.gCj.setVisibility(0);
        this.gCk = true;
        byR();
        this.mTipView.setText(str);
        this.gCg = 0;
    }

    public void setAddress(String str) {
        this.gCj.setVisibility(8);
        this.gCk = true;
        byR();
        this.mTipView.setText(str);
        this.gCg = 4;
    }

    public void byN() {
        this.gCj.setVisibility(0);
        this.gCk = false;
        byR();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.gCg = 1;
    }

    public void byO() {
        this.gCk = false;
        byR();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.gCj.setVisibility(8);
        this.gCg = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byP() {
        this.gCi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byQ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCh.getLayoutMode().setNightMode(z);
        this.gCh.getLayoutMode().onModeChanged(this.mView);
        this.gCi.startLoad(c.a(this.gCh.getActivity(), c.gCm, z), 29, false);
        byR();
    }

    private void byR() {
        if (this.gCk) {
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
        return String.format(this.gCh.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byS() {
        if (this.mIndex != this.gCl) {
            return this.gCh.getPageContext().getString(R.string.next_step);
        }
        return this.gCh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byT() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byU() {
        return true;
    }
}
