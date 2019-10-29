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
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity gJX;
    private LinearLayout gKc;
    private LinearLayout gKd;
    private LinearLayout gKe;
    private View gKf;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gKc = null;
        this.gKd = null;
        this.gKe = null;
        this.gKf = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.gJX = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gJX.setContentView(R.layout.group_card_activity);
        this.mParent = this.gJX.findViewById(R.id.parent);
        this.gKc = (LinearLayout) this.gJX.findViewById(R.id.groud_card_save);
        this.gKc.setOnClickListener(this.gJX);
        this.gKd = (LinearLayout) this.gJX.findViewById(R.id.group_card_share);
        if (f.cv(this.gJX.getPageContext().getContext())) {
            this.gKd.setOnClickListener(this.gJX);
        } else {
            this.gKd.setVisibility(8);
        }
        this.gKe = (LinearLayout) this.gJX.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gJX.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.gJX.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gJX.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gJX.getResources().getString(R.string.group_card_name));
        this.gKf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gKf.setOnClickListener(this.gJX);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gJX.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gJX.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bpN() {
        this.progressBar.setVisibility(8);
    }

    public void bBX() {
        this.mImageView.setVisibility(0);
    }

    public View bBY() {
        return this.gKc;
    }

    public View bBZ() {
        return this.gKd;
    }

    public View bCa() {
        return this.gKf;
    }

    public View bCb() {
        return this.mNavigationBar;
    }

    public LinearLayout bCc() {
        return this.gKe;
    }

    public void onChangeSkinType(int i) {
        this.gJX.getLayoutMode().setNightMode(i == 1);
        this.gJX.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gJX.getPageContext(), i);
    }
}
