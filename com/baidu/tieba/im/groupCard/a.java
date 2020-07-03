package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity iUT;
    private LinearLayout iUY;
    private LinearLayout iUZ;
    private LinearLayout iVa;
    private View iVb;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.iUY = null;
        this.iUZ = null;
        this.iVa = null;
        this.iVb = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.iUT = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.iUT.setContentView(R.layout.group_card_activity);
        this.mParent = this.iUT.findViewById(R.id.parent);
        this.iUY = (LinearLayout) this.iUT.findViewById(R.id.groud_card_save);
        this.iUY.setOnClickListener(this.iUT);
        this.iUZ = (LinearLayout) this.iUT.findViewById(R.id.group_card_share);
        if (f.dN(this.iUT.getPageContext().getContext())) {
            this.iUZ.setOnClickListener(this.iUT);
        } else {
            this.iUZ.setVisibility(8);
        }
        this.iVa = (LinearLayout) this.iUT.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.iUT.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.iUT.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.iUT.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iUT.getResources().getString(R.string.group_card_name));
        this.iVb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVb.setOnClickListener(this.iUT);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void bh(int i, String str) {
        if (str != null) {
            l.showToast(this.iUT.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.iUT.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void ceu() {
        this.progressBar.setVisibility(8);
    }

    public void cri() {
        this.mImageView.setVisibility(0);
    }

    public View crj() {
        return this.iUY;
    }

    public View crk() {
        return this.iUZ;
    }

    public View crl() {
        return this.iVb;
    }

    public View crm() {
        return this.mNavigationBar;
    }

    public LinearLayout crn() {
        return this.iVa;
    }

    public void onChangeSkinType(int i) {
        this.iUT.getLayoutMode().setNightMode(i == 1);
        this.iUT.getLayoutMode().onModeChanged(this.mParent);
        an.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.iUT.getPageContext(), i);
    }
}
