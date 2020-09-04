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
/* loaded from: classes17.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity jsl;
    private LinearLayout jsq;
    private LinearLayout jsr;
    private LinearLayout jss;
    private View jst;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jsq = null;
        this.jsr = null;
        this.jss = null;
        this.jst = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jsl = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jsl.setContentView(R.layout.group_card_activity);
        this.mParent = this.jsl.findViewById(R.id.parent);
        this.jsq = (LinearLayout) this.jsl.findViewById(R.id.groud_card_save);
        this.jsq.setOnClickListener(this.jsl);
        this.jsr = (LinearLayout) this.jsl.findViewById(R.id.group_card_share);
        if (g.eb(this.jsl.getPageContext().getContext())) {
            this.jsr.setOnClickListener(this.jsl);
        } else {
            this.jsr.setVisibility(8);
        }
        this.jss = (LinearLayout) this.jsl.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jsl.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jsl.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jsl.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jsl.getResources().getString(R.string.group_card_name));
        this.jst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jst.setOnClickListener(this.jsl);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bg(int i, String str) {
        if (str != null) {
            l.showToast(this.jsl.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jsl.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void csz() {
        this.progressBar.setVisibility(8);
    }

    public void cFZ() {
        this.mImageView.setVisibility(0);
    }

    public View cGa() {
        return this.jsq;
    }

    public View cGb() {
        return this.jsr;
    }

    public View cGc() {
        return this.jst;
    }

    public View cGd() {
        return this.mNavigationBar;
    }

    public LinearLayout cGe() {
        return this.jss;
    }

    public void onChangeSkinType(int i) {
        this.jsl.getLayoutMode().setNightMode(i == 1);
        this.jsl.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jsl.getPageContext(), i);
    }
}
