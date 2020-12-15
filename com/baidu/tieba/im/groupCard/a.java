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
    private GroupCardActivity kwp;
    private LinearLayout kwu;
    private LinearLayout kwv;
    private LinearLayout kww;
    private View kwx;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.kwu = null;
        this.kwv = null;
        this.kww = null;
        this.kwx = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.kwp = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.kwp.setContentView(R.layout.group_card_activity);
        this.mParent = this.kwp.findViewById(R.id.parent);
        this.kwu = (LinearLayout) this.kwp.findViewById(R.id.groud_card_save);
        this.kwu.setOnClickListener(this.kwp);
        this.kwv = (LinearLayout) this.kwp.findViewById(R.id.group_card_share);
        if (g.eM(this.kwp.getPageContext().getContext())) {
            this.kwv.setOnClickListener(this.kwp);
        } else {
            this.kwv.setVisibility(8);
        }
        this.kww = (LinearLayout) this.kwp.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.kwp.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.kwp.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.kwp.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kwp.getResources().getString(R.string.group_card_name));
        this.kwx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kwx.setOnClickListener(this.kwp);
    }

    public void h(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bx(int i, String str) {
        if (str != null) {
            l.showToast(this.kwp.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.kwp.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cJM() {
        this.progressBar.setVisibility(8);
    }

    public void cXP() {
        this.mImageView.setVisibility(0);
    }

    public View cXQ() {
        return this.kwu;
    }

    public View cXR() {
        return this.kwv;
    }

    public View cXS() {
        return this.kwx;
    }

    public View cXT() {
        return this.mNavigationBar;
    }

    public LinearLayout cXU() {
        return this.kww;
    }

    public void onChangeSkinType(int i) {
        this.kwp.getLayoutMode().setNightMode(i == 1);
        this.kwp.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.kwp.getPageContext(), i);
    }
}
