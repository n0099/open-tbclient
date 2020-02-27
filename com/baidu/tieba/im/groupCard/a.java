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
    private GroupCardActivity hCM;
    private LinearLayout hCR;
    private LinearLayout hCS;
    private LinearLayout hCT;
    private View hCU;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hCR = null;
        this.hCS = null;
        this.hCT = null;
        this.hCU = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hCM = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hCM.setContentView(R.layout.group_card_activity);
        this.mParent = this.hCM.findViewById(R.id.parent);
        this.hCR = (LinearLayout) this.hCM.findViewById(R.id.groud_card_save);
        this.hCR.setOnClickListener(this.hCM);
        this.hCS = (LinearLayout) this.hCM.findViewById(R.id.group_card_share);
        if (f.dU(this.hCM.getPageContext().getContext())) {
            this.hCS.setOnClickListener(this.hCM);
        } else {
            this.hCS.setVisibility(8);
        }
        this.hCT = (LinearLayout) this.hCM.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hCM.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hCM.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hCM.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hCM.getResources().getString(R.string.group_card_name));
        this.hCU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hCU.setOnClickListener(this.hCM);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aJ(int i, String str) {
        if (str != null) {
            l.showToast(this.hCM.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hCM.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bJL() {
        this.progressBar.setVisibility(8);
    }

    public void bVS() {
        this.mImageView.setVisibility(0);
    }

    public View bVT() {
        return this.hCR;
    }

    public View bVU() {
        return this.hCS;
    }

    public View bVV() {
        return this.hCU;
    }

    public View bVW() {
        return this.mNavigationBar;
    }

    public LinearLayout bVX() {
        return this.hCT;
    }

    public void onChangeSkinType(int i) {
        this.hCM.getLayoutMode().setNightMode(i == 1);
        this.hCM.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hCM.getPageContext(), i);
    }
}
