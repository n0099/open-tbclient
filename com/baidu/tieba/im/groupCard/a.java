package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity kcj;
    private LinearLayout kco;
    private LinearLayout kcp;
    private LinearLayout kcq;
    private View kcr;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.kco = null;
        this.kcp = null;
        this.kcq = null;
        this.kcr = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.kcj = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.kcj.setContentView(R.layout.group_card_activity);
        this.mParent = this.kcj.findViewById(R.id.parent);
        this.kco = (LinearLayout) this.kcj.findViewById(R.id.groud_card_save);
        this.kco.setOnClickListener(this.kcj);
        this.kcp = (LinearLayout) this.kcj.findViewById(R.id.group_card_share);
        if (g.eh(this.kcj.getPageContext().getContext())) {
            this.kcp.setOnClickListener(this.kcj);
        } else {
            this.kcp.setVisibility(8);
        }
        this.kcq = (LinearLayout) this.kcj.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.kcj.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.kcj.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.kcj.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kcj.getResources().getString(R.string.group_card_name));
        this.kcr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kcr.setOnClickListener(this.kcj);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bv(int i, String str) {
        if (str != null) {
            l.showToast(this.kcj.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.kcj.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cCs() {
        this.progressBar.setVisibility(8);
    }

    public void cQv() {
        this.mImageView.setVisibility(0);
    }

    public View cQw() {
        return this.kco;
    }

    public View cQx() {
        return this.kcp;
    }

    public View cQy() {
        return this.kcr;
    }

    public View cQz() {
        return this.mNavigationBar;
    }

    public LinearLayout cQA() {
        return this.kcq;
    }

    public void onChangeSkinType(int i) {
        this.kcj.getLayoutMode().setNightMode(i == 1);
        this.kcj.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.kcj.getPageContext(), i);
    }
}
