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
    private GroupCardActivity kwn;
    private LinearLayout kws;
    private LinearLayout kwt;
    private LinearLayout kwu;
    private View kwv;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.kws = null;
        this.kwt = null;
        this.kwu = null;
        this.kwv = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.kwn = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.kwn.setContentView(R.layout.group_card_activity);
        this.mParent = this.kwn.findViewById(R.id.parent);
        this.kws = (LinearLayout) this.kwn.findViewById(R.id.groud_card_save);
        this.kws.setOnClickListener(this.kwn);
        this.kwt = (LinearLayout) this.kwn.findViewById(R.id.group_card_share);
        if (g.eM(this.kwn.getPageContext().getContext())) {
            this.kwt.setOnClickListener(this.kwn);
        } else {
            this.kwt.setVisibility(8);
        }
        this.kwu = (LinearLayout) this.kwn.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.kwn.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.kwn.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.kwn.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kwn.getResources().getString(R.string.group_card_name));
        this.kwv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kwv.setOnClickListener(this.kwn);
    }

    public void h(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bx(int i, String str) {
        if (str != null) {
            l.showToast(this.kwn.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.kwn.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cJL() {
        this.progressBar.setVisibility(8);
    }

    public void cXO() {
        this.mImageView.setVisibility(0);
    }

    public View cXP() {
        return this.kws;
    }

    public View cXQ() {
        return this.kwt;
    }

    public View cXR() {
        return this.kwv;
    }

    public View cXS() {
        return this.mNavigationBar;
    }

    public LinearLayout cXT() {
        return this.kwu;
    }

    public void onChangeSkinType(int i) {
        this.kwn.getLayoutMode().setNightMode(i == 1);
        this.kwn.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.kwn.getPageContext(), i);
    }
}
