package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private ImageView bnH;
    private GroupCardActivity eVT;
    private LinearLayout eVY;
    private LinearLayout eVZ;
    private LinearLayout eWa;
    private View eWb;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eVY = null;
        this.eVZ = null;
        this.eWa = null;
        this.eWb = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bnH = null;
        this.eVT = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eVT.setContentView(e.h.group_card_activity);
        this.mParent = this.eVT.findViewById(e.g.parent);
        this.eVY = (LinearLayout) this.eVT.findViewById(e.g.groud_card_save);
        this.eVY.setOnClickListener(this.eVT);
        this.eVZ = (LinearLayout) this.eVT.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eVT.getPageContext().getContext())) {
            this.eVZ.setOnClickListener(this.eVT);
        } else {
            this.eVZ.setVisibility(8);
        }
        this.eWa = (LinearLayout) this.eVT.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eVT.findViewById(e.g.progress);
        this.bnH = (ImageView) this.eVT.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eVT.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eVT.getResources().getString(e.j.group_card_name));
        this.eWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWb.setOnClickListener(this.eVT);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bnH);
        }
    }

    public void U(int i, String str) {
        if (str != null) {
            l.showToast(this.eVT.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eVT.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aIa() {
        this.progressBar.setVisibility(8);
    }

    public void aTl() {
        this.bnH.setVisibility(0);
    }

    public View aTm() {
        return this.eVY;
    }

    public View aTn() {
        return this.eVZ;
    }

    public View aTo() {
        return this.eWb;
    }

    public View aTp() {
        return this.mNavigationBar;
    }

    public LinearLayout aTq() {
        return this.eWa;
    }

    public void onChangeSkinType(int i) {
        this.eVT.getLayoutMode().setNightMode(i == 1);
        this.eVT.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eVT.getPageContext(), i);
    }
}
