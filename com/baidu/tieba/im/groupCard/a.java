package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity hAN;
    private LinearLayout hAS;
    private LinearLayout hAT;
    private LinearLayout hAU;
    private View hAV;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hAS = null;
        this.hAT = null;
        this.hAU = null;
        this.hAV = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hAN = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hAN.setContentView(R.layout.group_card_activity);
        this.mParent = this.hAN.findViewById(R.id.parent);
        this.hAS = (LinearLayout) this.hAN.findViewById(R.id.groud_card_save);
        this.hAS.setOnClickListener(this.hAN);
        this.hAT = (LinearLayout) this.hAN.findViewById(R.id.group_card_share);
        if (e.dQ(this.hAN.getPageContext().getContext())) {
            this.hAT.setOnClickListener(this.hAN);
        } else {
            this.hAT.setVisibility(8);
        }
        this.hAU = (LinearLayout) this.hAN.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hAN.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hAN.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hAN.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hAN.getResources().getString(R.string.group_card_name));
        this.hAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hAV.setOnClickListener(this.hAN);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aJ(int i, String str) {
        if (str != null) {
            l.showToast(this.hAN.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hAN.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bIj() {
        this.progressBar.setVisibility(8);
    }

    public void bUr() {
        this.mImageView.setVisibility(0);
    }

    public View bUs() {
        return this.hAS;
    }

    public View bUt() {
        return this.hAT;
    }

    public View bUu() {
        return this.hAV;
    }

    public View bUv() {
        return this.mNavigationBar;
    }

    public LinearLayout bUw() {
        return this.hAU;
    }

    public void onChangeSkinType(int i) {
        this.hAN.getLayoutMode().setNightMode(i == 1);
        this.hAN.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hAN.getPageContext(), i);
    }
}
