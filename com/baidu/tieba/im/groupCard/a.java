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
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends c<GroupCardActivity> {
    private LinearLayout ioB;
    private LinearLayout ioC;
    private LinearLayout ioD;
    private View ioE;
    private GroupCardActivity iow;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.ioB = null;
        this.ioC = null;
        this.ioD = null;
        this.ioE = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.iow = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.iow.setContentView(R.layout.group_card_activity);
        this.mParent = this.iow.findViewById(R.id.parent);
        this.ioB = (LinearLayout) this.iow.findViewById(R.id.groud_card_save);
        this.ioB.setOnClickListener(this.iow);
        this.ioC = (LinearLayout) this.iow.findViewById(R.id.group_card_share);
        if (f.dv(this.iow.getPageContext().getContext())) {
            this.ioC.setOnClickListener(this.iow);
        } else {
            this.ioC.setVisibility(8);
        }
        this.ioD = (LinearLayout) this.iow.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.iow.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.iow.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.iow.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iow.getResources().getString(R.string.group_card_name));
        this.ioE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ioE.setOnClickListener(this.iow);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aY(int i, String str) {
        if (str != null) {
            l.showToast(this.iow.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.iow.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bUw() {
        this.progressBar.setVisibility(8);
    }

    public void cgM() {
        this.mImageView.setVisibility(0);
    }

    public View cgN() {
        return this.ioB;
    }

    public View cgO() {
        return this.ioC;
    }

    public View cgP() {
        return this.ioE;
    }

    public View cgQ() {
        return this.mNavigationBar;
    }

    public LinearLayout cgR() {
        return this.ioD;
    }

    public void onChangeSkinType(int i) {
        this.iow.getLayoutMode().setNightMode(i == 1);
        this.iow.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.iow.getPageContext(), i);
    }
}
