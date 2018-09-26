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
    private ImageView bem;
    private LinearLayout eCC;
    private LinearLayout eCD;
    private LinearLayout eCE;
    private View eCF;
    private GroupCardActivity eCx;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eCC = null;
        this.eCD = null;
        this.eCE = null;
        this.eCF = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bem = null;
        this.eCx = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eCx.setContentView(e.h.group_card_activity);
        this.mParent = this.eCx.findViewById(e.g.parent);
        this.eCC = (LinearLayout) this.eCx.findViewById(e.g.groud_card_save);
        this.eCC.setOnClickListener(this.eCx);
        this.eCD = (LinearLayout) this.eCx.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bD(this.eCx.getPageContext().getContext())) {
            this.eCD.setOnClickListener(this.eCx);
        } else {
            this.eCD.setVisibility(8);
        }
        this.eCE = (LinearLayout) this.eCx.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eCx.findViewById(e.g.progress);
        this.bem = (ImageView) this.eCx.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eCx.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eCx.getResources().getString(e.j.group_card_name));
        this.eCF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCF.setOnClickListener(this.eCx);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bem);
        }
    }

    public void V(int i, String str) {
        if (str != null) {
            l.showToast(this.eCx.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eCx.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aCn() {
        this.progressBar.setVisibility(8);
    }

    public void aNu() {
        this.bem.setVisibility(0);
    }

    public View aNv() {
        return this.eCC;
    }

    public View aNw() {
        return this.eCD;
    }

    public View aNx() {
        return this.eCF;
    }

    public View aNy() {
        return this.mNavigationBar;
    }

    public LinearLayout aNz() {
        return this.eCE;
    }

    public void onChangeSkinType(int i) {
        this.eCx.getLayoutMode().setNightMode(i == 1);
        this.eCx.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eCx.getPageContext(), i);
    }
}
