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
    private ImageView bmS;
    private GroupCardActivity eVf;
    private LinearLayout eVk;
    private LinearLayout eVl;
    private LinearLayout eVm;
    private View eVn;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eVk = null;
        this.eVl = null;
        this.eVm = null;
        this.eVn = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bmS = null;
        this.eVf = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eVf.setContentView(e.h.group_card_activity);
        this.mParent = this.eVf.findViewById(e.g.parent);
        this.eVk = (LinearLayout) this.eVf.findViewById(e.g.groud_card_save);
        this.eVk.setOnClickListener(this.eVf);
        this.eVl = (LinearLayout) this.eVf.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eVf.getPageContext().getContext())) {
            this.eVl.setOnClickListener(this.eVf);
        } else {
            this.eVl.setVisibility(8);
        }
        this.eVm = (LinearLayout) this.eVf.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eVf.findViewById(e.g.progress);
        this.bmS = (ImageView) this.eVf.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eVf.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eVf.getResources().getString(e.j.group_card_name));
        this.eVn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eVn.setOnClickListener(this.eVf);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bmS);
        }
    }

    public void S(int i, String str) {
        if (str != null) {
            l.showToast(this.eVf.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eVf.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aHD() {
        this.progressBar.setVisibility(8);
    }

    public void aSL() {
        this.bmS.setVisibility(0);
    }

    public View aSM() {
        return this.eVk;
    }

    public View aSN() {
        return this.eVl;
    }

    public View aSO() {
        return this.eVn;
    }

    public View aSP() {
        return this.mNavigationBar;
    }

    public LinearLayout aSQ() {
        return this.eVm;
    }

    public void onChangeSkinType(int i) {
        this.eVf.getLayoutMode().setNightMode(i == 1);
        this.eVf.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eVf.getPageContext(), i);
    }
}
