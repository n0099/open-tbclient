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
    private GroupCardActivity hDa;
    private LinearLayout hDf;
    private LinearLayout hDg;
    private LinearLayout hDh;
    private View hDi;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.hDf = null;
        this.hDg = null;
        this.hDh = null;
        this.hDi = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.hDa = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.hDa.setContentView(R.layout.group_card_activity);
        this.mParent = this.hDa.findViewById(R.id.parent);
        this.hDf = (LinearLayout) this.hDa.findViewById(R.id.groud_card_save);
        this.hDf.setOnClickListener(this.hDa);
        this.hDg = (LinearLayout) this.hDa.findViewById(R.id.group_card_share);
        if (f.dU(this.hDa.getPageContext().getContext())) {
            this.hDg.setOnClickListener(this.hDa);
        } else {
            this.hDg.setVisibility(8);
        }
        this.hDh = (LinearLayout) this.hDa.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.hDa.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.hDa.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.hDa.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hDa.getResources().getString(R.string.group_card_name));
        this.hDi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hDi.setOnClickListener(this.hDa);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void aJ(int i, String str) {
        if (str != null) {
            l.showToast(this.hDa.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.hDa.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bJO() {
        this.progressBar.setVisibility(8);
    }

    public void bVV() {
        this.mImageView.setVisibility(0);
    }

    public View bVW() {
        return this.hDf;
    }

    public View bVX() {
        return this.hDg;
    }

    public View bVY() {
        return this.hDi;
    }

    public View bVZ() {
        return this.mNavigationBar;
    }

    public LinearLayout bWa() {
        return this.hDh;
    }

    public void onChangeSkinType(int i) {
        this.hDa.getLayoutMode().setNightMode(i == 1);
        this.hDa.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.hDa.getPageContext(), i);
    }
}
