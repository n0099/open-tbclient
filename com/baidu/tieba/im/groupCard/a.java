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
/* loaded from: classes7.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity hxk;
    private LinearLayout hxp;
    private LinearLayout hxq;
    private LinearLayout hxr;
    private View hxs;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hxp = null;
        this.hxq = null;
        this.hxr = null;
        this.hxs = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hxk = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hxk.setContentView(R.layout.group_card_activity);
        this.mParent = this.hxk.findViewById(R.id.parent);
        this.hxp = (LinearLayout) this.hxk.findViewById(R.id.groud_card_save);
        this.hxp.setOnClickListener(this.hxk);
        this.hxq = (LinearLayout) this.hxk.findViewById(R.id.group_card_share);
        if (e.dQ(this.hxk.getPageContext().getContext())) {
            this.hxq.setOnClickListener(this.hxk);
        } else {
            this.hxq.setVisibility(8);
        }
        this.hxr = (LinearLayout) this.hxk.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hxk.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hxk.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hxk.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hxk.getResources().getString(R.string.group_card_name));
        this.hxs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hxs.setOnClickListener(this.hxk);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aD(int i, String str) {
        if (str != null) {
            l.showToast(this.hxk.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hxk.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bHh() {
        this.progressBar.setVisibility(8);
    }

    public void bTi() {
        this.mImageView.setVisibility(0);
    }

    public View bTj() {
        return this.hxp;
    }

    public View bTk() {
        return this.hxq;
    }

    public View bTl() {
        return this.hxs;
    }

    public View bTm() {
        return this.mNavigationBar;
    }

    public LinearLayout bTn() {
        return this.hxr;
    }

    public void onChangeSkinType(int i) {
        this.hxk.getLayoutMode().setNightMode(i == 1);
        this.hxk.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hxk.getPageContext(), i);
    }
}
