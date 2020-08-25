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
    private GroupCardActivity jsf;
    private LinearLayout jsk;
    private LinearLayout jsl;
    private LinearLayout jsm;
    private View jsn;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jsk = null;
        this.jsl = null;
        this.jsm = null;
        this.jsn = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jsf = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jsf.setContentView(R.layout.group_card_activity);
        this.mParent = this.jsf.findViewById(R.id.parent);
        this.jsk = (LinearLayout) this.jsf.findViewById(R.id.groud_card_save);
        this.jsk.setOnClickListener(this.jsf);
        this.jsl = (LinearLayout) this.jsf.findViewById(R.id.group_card_share);
        if (g.eb(this.jsf.getPageContext().getContext())) {
            this.jsl.setOnClickListener(this.jsf);
        } else {
            this.jsl.setVisibility(8);
        }
        this.jsm = (LinearLayout) this.jsf.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jsf.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jsf.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jsf.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jsf.getResources().getString(R.string.group_card_name));
        this.jsn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jsn.setOnClickListener(this.jsf);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bh(int i, String str) {
        if (str != null) {
            l.showToast(this.jsf.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jsf.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void csy() {
        this.progressBar.setVisibility(8);
    }

    public void cFY() {
        this.mImageView.setVisibility(0);
    }

    public View cFZ() {
        return this.jsk;
    }

    public View cGa() {
        return this.jsl;
    }

    public View cGb() {
        return this.jsn;
    }

    public View cGc() {
        return this.mNavigationBar;
    }

    public LinearLayout cGd() {
        return this.jsm;
    }

    public void onChangeSkinType(int i) {
        this.jsf.getLayoutMode().setNightMode(i == 1);
        this.jsf.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jsf.getPageContext(), i);
    }
}
