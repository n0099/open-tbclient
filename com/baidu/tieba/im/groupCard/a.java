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
    private GroupCardActivity ioq;
    private LinearLayout iov;
    private LinearLayout iow;
    private LinearLayout iox;
    private View ioy;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.iov = null;
        this.iow = null;
        this.iox = null;
        this.ioy = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.ioq = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.ioq.setContentView(R.layout.group_card_activity);
        this.mParent = this.ioq.findViewById(R.id.parent);
        this.iov = (LinearLayout) this.ioq.findViewById(R.id.groud_card_save);
        this.iov.setOnClickListener(this.ioq);
        this.iow = (LinearLayout) this.ioq.findViewById(R.id.group_card_share);
        if (f.dH(this.ioq.getPageContext().getContext())) {
            this.iow.setOnClickListener(this.ioq);
        } else {
            this.iow.setVisibility(8);
        }
        this.iox = (LinearLayout) this.ioq.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.ioq.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.ioq.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.ioq.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ioq.getResources().getString(R.string.group_card_name));
        this.ioy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ioy.setOnClickListener(this.ioq);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aY(int i, String str) {
        if (str != null) {
            l.showToast(this.ioq.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.ioq.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bUy() {
        this.progressBar.setVisibility(8);
    }

    public void cgO() {
        this.mImageView.setVisibility(0);
    }

    public View cgP() {
        return this.iov;
    }

    public View cgQ() {
        return this.iow;
    }

    public View cgR() {
        return this.ioy;
    }

    public View cgS() {
        return this.mNavigationBar;
    }

    public LinearLayout cgT() {
        return this.iox;
    }

    public void onChangeSkinType(int i) {
        this.ioq.getLayoutMode().setNightMode(i == 1);
        this.ioq.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.ioq.getPageContext(), i);
    }
}
