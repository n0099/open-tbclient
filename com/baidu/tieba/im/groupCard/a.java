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
    private GroupCardActivity kiR;
    private LinearLayout kiW;
    private LinearLayout kiX;
    private LinearLayout kiY;
    private View kiZ;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.kiW = null;
        this.kiX = null;
        this.kiY = null;
        this.kiZ = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.kiR = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.kiR.setContentView(R.layout.group_card_activity);
        this.mParent = this.kiR.findViewById(R.id.parent);
        this.kiW = (LinearLayout) this.kiR.findViewById(R.id.groud_card_save);
        this.kiW.setOnClickListener(this.kiR);
        this.kiX = (LinearLayout) this.kiR.findViewById(R.id.group_card_share);
        if (g.eh(this.kiR.getPageContext().getContext())) {
            this.kiX.setOnClickListener(this.kiR);
        } else {
            this.kiX.setVisibility(8);
        }
        this.kiY = (LinearLayout) this.kiR.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.kiR.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.kiR.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.kiR.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kiR.getResources().getString(R.string.group_card_name));
        this.kiZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kiZ.setOnClickListener(this.kiR);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bx(int i, String str) {
        if (str != null) {
            l.showToast(this.kiR.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.kiR.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cEy() {
        this.progressBar.setVisibility(8);
    }

    public void cSC() {
        this.mImageView.setVisibility(0);
    }

    public View cSD() {
        return this.kiW;
    }

    public View cSE() {
        return this.kiX;
    }

    public View cSF() {
        return this.kiZ;
    }

    public View cSG() {
        return this.mNavigationBar;
    }

    public LinearLayout cSH() {
        return this.kiY;
    }

    public void onChangeSkinType(int i) {
        this.kiR.getLayoutMode().setNightMode(i == 1);
        this.kiR.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.kiR.getPageContext(), i);
    }
}
