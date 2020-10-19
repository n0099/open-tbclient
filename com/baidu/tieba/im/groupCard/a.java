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
    private GroupCardActivity jPK;
    private LinearLayout jPP;
    private LinearLayout jPQ;
    private LinearLayout jPR;
    private View jPS;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.jPP = null;
        this.jPQ = null;
        this.jPR = null;
        this.jPS = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.jPK = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.jPK.setContentView(R.layout.group_card_activity);
        this.mParent = this.jPK.findViewById(R.id.parent);
        this.jPP = (LinearLayout) this.jPK.findViewById(R.id.groud_card_save);
        this.jPP.setOnClickListener(this.jPK);
        this.jPQ = (LinearLayout) this.jPK.findViewById(R.id.group_card_share);
        if (g.eh(this.jPK.getPageContext().getContext())) {
            this.jPQ.setOnClickListener(this.jPK);
        } else {
            this.jPQ.setVisibility(8);
        }
        this.jPR = (LinearLayout) this.jPK.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.jPK.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.jPK.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.jPK.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jPK.getResources().getString(R.string.group_card_name));
        this.jPS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jPS.setOnClickListener(this.jPK);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bu(int i, String str) {
        if (str != null) {
            l.showToast(this.jPK.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.jPK.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void czl() {
        this.progressBar.setVisibility(8);
    }

    public void cNo() {
        this.mImageView.setVisibility(0);
    }

    public View cNp() {
        return this.jPP;
    }

    public View cNq() {
        return this.jPQ;
    }

    public View cNr() {
        return this.jPS;
    }

    public View cNs() {
        return this.mNavigationBar;
    }

    public LinearLayout cNt() {
        return this.jPR;
    }

    public void onChangeSkinType(int i) {
        this.jPK.getLayoutMode().setNightMode(i == 1);
        this.jPK.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.jPK.getPageContext(), i);
    }
}
