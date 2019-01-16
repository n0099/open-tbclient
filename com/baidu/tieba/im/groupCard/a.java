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
    private ImageView bnG;
    private GroupCardActivity eVS;
    private LinearLayout eVX;
    private LinearLayout eVY;
    private LinearLayout eVZ;
    private View eWa;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eVX = null;
        this.eVY = null;
        this.eVZ = null;
        this.eWa = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bnG = null;
        this.eVS = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eVS.setContentView(e.h.group_card_activity);
        this.mParent = this.eVS.findViewById(e.g.parent);
        this.eVX = (LinearLayout) this.eVS.findViewById(e.g.groud_card_save);
        this.eVX.setOnClickListener(this.eVS);
        this.eVY = (LinearLayout) this.eVS.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eVS.getPageContext().getContext())) {
            this.eVY.setOnClickListener(this.eVS);
        } else {
            this.eVY.setVisibility(8);
        }
        this.eVZ = (LinearLayout) this.eVS.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eVS.findViewById(e.g.progress);
        this.bnG = (ImageView) this.eVS.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eVS.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eVS.getResources().getString(e.j.group_card_name));
        this.eWa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWa.setOnClickListener(this.eVS);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bnG);
        }
    }

    public void U(int i, String str) {
        if (str != null) {
            l.showToast(this.eVS.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eVS.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aIa() {
        this.progressBar.setVisibility(8);
    }

    public void aTl() {
        this.bnG.setVisibility(0);
    }

    public View aTm() {
        return this.eVX;
    }

    public View aTn() {
        return this.eVY;
    }

    public View aTo() {
        return this.eWa;
    }

    public View aTp() {
        return this.mNavigationBar;
    }

    public LinearLayout aTq() {
        return this.eVZ;
    }

    public void onChangeSkinType(int i) {
        this.eVS.getLayoutMode().setNightMode(i == 1);
        this.eVS.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eVS.getPageContext(), i);
    }
}
