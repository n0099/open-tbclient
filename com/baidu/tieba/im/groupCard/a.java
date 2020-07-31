package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity jdd;
    private LinearLayout jdi;
    private LinearLayout jdj;
    private LinearLayout jdk;
    private View jdl;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jdi = null;
        this.jdj = null;
        this.jdk = null;
        this.jdl = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jdd = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jdd.setContentView(R.layout.group_card_activity);
        this.mParent = this.jdd.findViewById(R.id.parent);
        this.jdi = (LinearLayout) this.jdd.findViewById(R.id.groud_card_save);
        this.jdi.setOnClickListener(this.jdd);
        this.jdj = (LinearLayout) this.jdd.findViewById(R.id.group_card_share);
        if (g.dS(this.jdd.getPageContext().getContext())) {
            this.jdj.setOnClickListener(this.jdd);
        } else {
            this.jdj.setVisibility(8);
        }
        this.jdk = (LinearLayout) this.jdd.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jdd.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jdd.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jdd.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jdd.getResources().getString(R.string.group_card_name));
        this.jdl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdl.setOnClickListener(this.jdd);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bj(int i, String str) {
        if (str != null) {
            l.showToast(this.jdd.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jdd.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void chU() {
        this.progressBar.setVisibility(8);
    }

    public void cvh() {
        this.mImageView.setVisibility(0);
    }

    public View cvi() {
        return this.jdi;
    }

    public View cvj() {
        return this.jdj;
    }

    public View cvk() {
        return this.jdl;
    }

    public View cvl() {
        return this.mNavigationBar;
    }

    public LinearLayout cvm() {
        return this.jdk;
    }

    public void onChangeSkinType(int i) {
        this.jdd.getLayoutMode().setNightMode(i == 1);
        this.jdd.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jdd.getPageContext(), i);
    }
}
