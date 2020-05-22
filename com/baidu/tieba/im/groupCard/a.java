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
    private GroupCardActivity iDc;
    private LinearLayout iDh;
    private LinearLayout iDi;
    private LinearLayout iDj;
    private View iDk;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.iDh = null;
        this.iDi = null;
        this.iDj = null;
        this.iDk = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.iDc = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.iDc.setContentView(R.layout.group_card_activity);
        this.mParent = this.iDc.findViewById(R.id.parent);
        this.iDh = (LinearLayout) this.iDc.findViewById(R.id.groud_card_save);
        this.iDh.setOnClickListener(this.iDc);
        this.iDi = (LinearLayout) this.iDc.findViewById(R.id.group_card_share);
        if (f.dM(this.iDc.getPageContext().getContext())) {
            this.iDi.setOnClickListener(this.iDc);
        } else {
            this.iDi.setVisibility(8);
        }
        this.iDj = (LinearLayout) this.iDc.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.iDc.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.iDc.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.iDc.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iDc.getResources().getString(R.string.group_card_name));
        this.iDk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iDk.setOnClickListener(this.iDc);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bd(int i, String str) {
        if (str != null) {
            l.showToast(this.iDc.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.iDc.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void caU() {
        this.progressBar.setVisibility(8);
    }

    public void cnk() {
        this.mImageView.setVisibility(0);
    }

    public View cnl() {
        return this.iDh;
    }

    public View cnm() {
        return this.iDi;
    }

    public View cnn() {
        return this.iDk;
    }

    public View cno() {
        return this.mNavigationBar;
    }

    public LinearLayout cnp() {
        return this.iDj;
    }

    public void onChangeSkinType(int i) {
        this.iDc.getLayoutMode().setNightMode(i == 1);
        this.iDc.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.iDc.getPageContext(), i);
    }
}
