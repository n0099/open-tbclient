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
    private GroupCardActivity jdf;
    private LinearLayout jdk;
    private LinearLayout jdl;
    private LinearLayout jdm;
    private View jdn;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jdk = null;
        this.jdl = null;
        this.jdm = null;
        this.jdn = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jdf = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jdf.setContentView(R.layout.group_card_activity);
        this.mParent = this.jdf.findViewById(R.id.parent);
        this.jdk = (LinearLayout) this.jdf.findViewById(R.id.groud_card_save);
        this.jdk.setOnClickListener(this.jdf);
        this.jdl = (LinearLayout) this.jdf.findViewById(R.id.group_card_share);
        if (g.dS(this.jdf.getPageContext().getContext())) {
            this.jdl.setOnClickListener(this.jdf);
        } else {
            this.jdl.setVisibility(8);
        }
        this.jdm = (LinearLayout) this.jdf.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jdf.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jdf.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jdf.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jdf.getResources().getString(R.string.group_card_name));
        this.jdn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdn.setOnClickListener(this.jdf);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bj(int i, String str) {
        if (str != null) {
            l.showToast(this.jdf.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jdf.getPageContext().getContext(), errMsg);
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
        return this.jdk;
    }

    public View cvj() {
        return this.jdl;
    }

    public View cvk() {
        return this.jdn;
    }

    public View cvl() {
        return this.mNavigationBar;
    }

    public LinearLayout cvm() {
        return this.jdm;
    }

    public void onChangeSkinType(int i) {
        this.jdf.getLayoutMode().setNightMode(i == 1);
        this.jdf.getLayoutMode().onModeChanged(this.mParent);
        ao.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jdf.getPageContext(), i);
    }
}
