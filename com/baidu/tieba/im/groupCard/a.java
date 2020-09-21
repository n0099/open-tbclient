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
/* loaded from: classes22.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity jAN;
    private LinearLayout jAS;
    private LinearLayout jAT;
    private LinearLayout jAU;
    private View jAV;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jAS = null;
        this.jAT = null;
        this.jAU = null;
        this.jAV = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jAN = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jAN.setContentView(R.layout.group_card_activity);
        this.mParent = this.jAN.findViewById(R.id.parent);
        this.jAS = (LinearLayout) this.jAN.findViewById(R.id.groud_card_save);
        this.jAS.setOnClickListener(this.jAN);
        this.jAT = (LinearLayout) this.jAN.findViewById(R.id.group_card_share);
        if (g.ea(this.jAN.getPageContext().getContext())) {
            this.jAT.setOnClickListener(this.jAN);
        } else {
            this.jAT.setVisibility(8);
        }
        this.jAU = (LinearLayout) this.jAN.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jAN.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jAN.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jAN.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jAN.getResources().getString(R.string.group_card_name));
        this.jAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jAV.setOnClickListener(this.jAN);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bk(int i, String str) {
        if (str != null) {
            l.showToast(this.jAN.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jAN.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cvO() {
        this.progressBar.setVisibility(8);
    }

    public void cJF() {
        this.mImageView.setVisibility(0);
    }

    public View cJG() {
        return this.jAS;
    }

    public View cJH() {
        return this.jAT;
    }

    public View cJI() {
        return this.jAV;
    }

    public View cJJ() {
        return this.mNavigationBar;
    }

    public LinearLayout cJK() {
        return this.jAU;
    }

    public void onChangeSkinType(int i) {
        this.jAN.getLayoutMode().setNightMode(i == 1);
        this.jAN.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jAN.getPageContext(), i);
    }
}
