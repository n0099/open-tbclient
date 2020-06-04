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
    private GroupCardActivity iDP;
    private LinearLayout iDU;
    private LinearLayout iDV;
    private LinearLayout iDW;
    private View iDX;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.iDU = null;
        this.iDV = null;
        this.iDW = null;
        this.iDX = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.iDP = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.iDP.setContentView(R.layout.group_card_activity);
        this.mParent = this.iDP.findViewById(R.id.parent);
        this.iDU = (LinearLayout) this.iDP.findViewById(R.id.groud_card_save);
        this.iDU.setOnClickListener(this.iDP);
        this.iDV = (LinearLayout) this.iDP.findViewById(R.id.group_card_share);
        if (f.dM(this.iDP.getPageContext().getContext())) {
            this.iDV.setOnClickListener(this.iDP);
        } else {
            this.iDV.setVisibility(8);
        }
        this.iDW = (LinearLayout) this.iDP.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.iDP.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.iDP.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.iDP.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iDP.getResources().getString(R.string.group_card_name));
        this.iDX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iDX.setOnClickListener(this.iDP);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bd(int i, String str) {
        if (str != null) {
            l.showToast(this.iDP.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.iDP.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cbc() {
        this.progressBar.setVisibility(8);
    }

    public void cnt() {
        this.mImageView.setVisibility(0);
    }

    public View cnu() {
        return this.iDU;
    }

    public View cnv() {
        return this.iDV;
    }

    public View cnw() {
        return this.iDX;
    }

    public View cnx() {
        return this.mNavigationBar;
    }

    public LinearLayout cny() {
        return this.iDW;
    }

    public void onChangeSkinType(int i) {
        this.iDP.getLayoutMode().setNightMode(i == 1);
        this.iDP.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.iDP.getPageContext(), i);
    }
}
