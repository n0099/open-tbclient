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
    private ImageView bjr;
    private LinearLayout eLE;
    private LinearLayout eLF;
    private LinearLayout eLG;
    private View eLH;
    private GroupCardActivity eLz;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eLE = null;
        this.eLF = null;
        this.eLG = null;
        this.eLH = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bjr = null;
        this.eLz = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eLz.setContentView(e.h.group_card_activity);
        this.mParent = this.eLz.findViewById(e.g.parent);
        this.eLE = (LinearLayout) this.eLz.findViewById(e.g.groud_card_save);
        this.eLE.setOnClickListener(this.eLz);
        this.eLF = (LinearLayout) this.eLz.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bI(this.eLz.getPageContext().getContext())) {
            this.eLF.setOnClickListener(this.eLz);
        } else {
            this.eLF.setVisibility(8);
        }
        this.eLG = (LinearLayout) this.eLz.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eLz.findViewById(e.g.progress);
        this.bjr = (ImageView) this.eLz.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eLz.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eLz.getResources().getString(e.j.group_card_name));
        this.eLH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLH.setOnClickListener(this.eLz);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bjr);
        }
    }

    public void R(int i, String str) {
        if (str != null) {
            l.showToast(this.eLz.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eLz.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aFc() {
        this.progressBar.setVisibility(8);
    }

    public void aQg() {
        this.bjr.setVisibility(0);
    }

    public View aQh() {
        return this.eLE;
    }

    public View aQi() {
        return this.eLF;
    }

    public View aQj() {
        return this.eLH;
    }

    public View aQk() {
        return this.mNavigationBar;
    }

    public LinearLayout aQl() {
        return this.eLG;
    }

    public void onChangeSkinType(int i) {
        this.eLz.getLayoutMode().setNightMode(i == 1);
        this.eLz.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eLz.getPageContext(), i);
    }
}
