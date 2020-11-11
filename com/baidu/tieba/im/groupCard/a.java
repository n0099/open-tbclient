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
    private GroupCardActivity kih;
    private LinearLayout kim;
    private LinearLayout kin;
    private LinearLayout kio;
    private View kip;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.kim = null;
        this.kin = null;
        this.kio = null;
        this.kip = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.kih = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.kih.setContentView(R.layout.group_card_activity);
        this.mParent = this.kih.findViewById(R.id.parent);
        this.kim = (LinearLayout) this.kih.findViewById(R.id.groud_card_save);
        this.kim.setOnClickListener(this.kih);
        this.kin = (LinearLayout) this.kih.findViewById(R.id.group_card_share);
        if (g.eh(this.kih.getPageContext().getContext())) {
            this.kin.setOnClickListener(this.kih);
        } else {
            this.kin.setVisibility(8);
        }
        this.kio = (LinearLayout) this.kih.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.kih.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.kih.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.kih.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kih.getResources().getString(R.string.group_card_name));
        this.kip = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kip.setOnClickListener(this.kih);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bz(int i, String str) {
        if (str != null) {
            l.showToast(this.kih.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.kih.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void cET() {
        this.progressBar.setVisibility(8);
    }

    public void cSW() {
        this.mImageView.setVisibility(0);
    }

    public View cSX() {
        return this.kim;
    }

    public View cSY() {
        return this.kin;
    }

    public View cSZ() {
        return this.kip;
    }

    public View cTa() {
        return this.mNavigationBar;
    }

    public LinearLayout cTb() {
        return this.kio;
    }

    public void onChangeSkinType(int i) {
        this.kih.getLayoutMode().setNightMode(i == 1);
        this.kih.getLayoutMode().onModeChanged(this.mParent);
        ap.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.kih.getPageContext(), i);
    }
}
