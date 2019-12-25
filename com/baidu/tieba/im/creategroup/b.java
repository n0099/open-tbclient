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
/* loaded from: classes7.dex */
public class b implements o {
    CreateGroupStepActivity hqm;
    TbImageView hqn;
    private ImageView hqo;
    private int hqq;
    private int mIndex;
    private int mStep;
    TextView mTipView;
    View mView;
    private int hql = 3;
    private boolean hqp = false;

    public b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hqm = null;
        this.mView = null;
        this.hqn = null;
        this.mTipView = null;
        this.hqo = null;
        this.hqm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step4_view, (ViewGroup) null);
        this.hqn = (TbImageView) this.mView.findViewById(R.id.step4_img_bg);
        this.mTipView = (TextView) this.mView.findViewById(R.id.txt_tip_view);
        this.hqo = (ImageView) this.mView.findViewById(R.id.create_group_address_rightarrwow);
        this.mIndex = i;
        this.mStep = i2;
        this.hqq = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bQa() {
        return this.mIndex;
    }

    public View bQb() {
        return this.mTipView;
    }

    public int bQc() {
        return this.hql;
    }

    public void bQd() {
        this.hqo.setVisibility(0);
        this.hqp = false;
        bQi();
        this.mTipView.setText(R.string.location_loading);
        this.hql = 3;
    }

    public void setBusiness(String str) {
        this.hqo.setVisibility(0);
        this.hqp = true;
        bQi();
        this.mTipView.setText(str);
        this.hql = 0;
    }

    public void setAddress(String str) {
        this.hqo.setVisibility(8);
        this.hqp = true;
        bQi();
        this.mTipView.setText(str);
        this.hql = 4;
    }

    public void bQe() {
        this.hqo.setVisibility(0);
        this.hqp = false;
        bQi();
        this.mTipView.setText(R.string.address_locate_failed_opengps);
        this.hql = 1;
    }

    public void bQf() {
        this.hqp = false;
        bQi();
        this.mTipView.setText(R.string.address_locate_failed_tryagain);
        this.hqo.setVisibility(8);
        this.hql = 2;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQg() {
        this.hqn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hqm.getLayoutMode().setNightMode(z);
        this.hqm.getLayoutMode().onModeChanged(this.mView);
        this.hqn.startLoad(c.a(this.hqm.getActivity(), c.hqr, z), 29, false);
        bQi();
    }

    private void bQi() {
        if (this.hqp) {
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
        return String.format(this.hqm.getPageContext().getString(R.string.group_create_step_address), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bQj() {
        if (this.mIndex != this.hqq) {
            return this.hqm.getPageContext().getString(R.string.next_step);
        }
        return this.hqm.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQk() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQl() {
        return true;
    }
}
