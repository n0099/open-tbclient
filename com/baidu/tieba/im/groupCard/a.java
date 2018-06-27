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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity erp;
    private LinearLayout erv;
    private LinearLayout erw;
    private LinearLayout erx;
    private View ery;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.erv = null;
        this.erw = null;
        this.erx = null;
        this.ery = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.erp = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.erp.setContentView(d.i.group_card_activity);
        this.mParent = this.erp.findViewById(d.g.parent);
        this.erv = (LinearLayout) this.erp.findViewById(d.g.groud_card_save);
        this.erv.setOnClickListener(this.erp);
        this.erw = (LinearLayout) this.erp.findViewById(d.g.group_card_share);
        if (e.aX(this.erp.getPageContext().getContext())) {
            this.erw.setOnClickListener(this.erp);
        } else {
            this.erw.setVisibility(8);
        }
        this.erx = (LinearLayout) this.erp.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.erp.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.erp.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.erp.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.erp.getResources().getString(d.k.group_card_name));
        this.ery = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ery.setOnClickListener(this.erp);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void T(int i, String str) {
        if (str != null) {
            l.showToast(this.erp.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.erp.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void azA() {
        this.progressBar.setVisibility(8);
    }

    public void aKh() {
        this.mImageView.setVisibility(0);
    }

    public View aKi() {
        return this.erv;
    }

    public View aKj() {
        return this.erw;
    }

    public View aKk() {
        return this.ery;
    }

    public View aKl() {
        return this.mNavigationBar;
    }

    public LinearLayout aKm() {
        return this.erx;
    }

    public void onChangeSkinType(int i) {
        this.erp.getLayoutMode().setNightMode(i == 1);
        this.erp.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.erp.getPageContext(), i);
    }
}
