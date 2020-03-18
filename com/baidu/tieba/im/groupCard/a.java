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
    private GroupCardActivity hEA;
    private LinearLayout hEF;
    private LinearLayout hEG;
    private LinearLayout hEH;
    private View hEI;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hEF = null;
        this.hEG = null;
        this.hEH = null;
        this.hEI = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hEA = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hEA.setContentView(R.layout.group_card_activity);
        this.mParent = this.hEA.findViewById(R.id.parent);
        this.hEF = (LinearLayout) this.hEA.findViewById(R.id.groud_card_save);
        this.hEF.setOnClickListener(this.hEA);
        this.hEG = (LinearLayout) this.hEA.findViewById(R.id.group_card_share);
        if (f.dT(this.hEA.getPageContext().getContext())) {
            this.hEG.setOnClickListener(this.hEA);
        } else {
            this.hEG.setVisibility(8);
        }
        this.hEH = (LinearLayout) this.hEA.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hEA.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hEA.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hEA.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hEA.getResources().getString(R.string.group_card_name));
        this.hEI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEI.setOnClickListener(this.hEA);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aJ(int i, String str) {
        if (str != null) {
            l.showToast(this.hEA.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hEA.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bKb() {
        this.progressBar.setVisibility(8);
    }

    public void bWn() {
        this.mImageView.setVisibility(0);
    }

    public View bWo() {
        return this.hEF;
    }

    public View bWp() {
        return this.hEG;
    }

    public View bWq() {
        return this.hEI;
    }

    public View bWr() {
        return this.mNavigationBar;
    }

    public LinearLayout bWs() {
        return this.hEH;
    }

    public void onChangeSkinType(int i) {
        this.hEA.getLayoutMode().setNightMode(i == 1);
        this.hEA.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hEA.getPageContext(), i);
    }
}
