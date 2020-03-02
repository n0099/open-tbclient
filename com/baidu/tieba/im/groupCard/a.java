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
    private GroupCardActivity hCO;
    private LinearLayout hCT;
    private LinearLayout hCU;
    private LinearLayout hCV;
    private View hCW;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hCT = null;
        this.hCU = null;
        this.hCV = null;
        this.hCW = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hCO = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hCO.setContentView(R.layout.group_card_activity);
        this.mParent = this.hCO.findViewById(R.id.parent);
        this.hCT = (LinearLayout) this.hCO.findViewById(R.id.groud_card_save);
        this.hCT.setOnClickListener(this.hCO);
        this.hCU = (LinearLayout) this.hCO.findViewById(R.id.group_card_share);
        if (f.dU(this.hCO.getPageContext().getContext())) {
            this.hCU.setOnClickListener(this.hCO);
        } else {
            this.hCU.setVisibility(8);
        }
        this.hCV = (LinearLayout) this.hCO.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hCO.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hCO.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hCO.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hCO.getResources().getString(R.string.group_card_name));
        this.hCW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hCW.setOnClickListener(this.hCO);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aJ(int i, String str) {
        if (str != null) {
            l.showToast(this.hCO.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hCO.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bJN() {
        this.progressBar.setVisibility(8);
    }

    public void bVU() {
        this.mImageView.setVisibility(0);
    }

    public View bVV() {
        return this.hCT;
    }

    public View bVW() {
        return this.hCU;
    }

    public View bVX() {
        return this.hCW;
    }

    public View bVY() {
        return this.mNavigationBar;
    }

    public LinearLayout bVZ() {
        return this.hCV;
    }

    public void onChangeSkinType(int i) {
        this.hCO.getLayoutMode().setNightMode(i == 1);
        this.hCO.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hCO.getPageContext(), i);
    }
}
