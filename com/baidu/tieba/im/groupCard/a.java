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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private ImageView baU;
    private GroupCardActivity eve;
    private LinearLayout evj;
    private LinearLayout evk;
    private LinearLayout evl;
    private View evm;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.evj = null;
        this.evk = null;
        this.evl = null;
        this.evm = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.baU = null;
        this.eve = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eve.setContentView(f.h.group_card_activity);
        this.mParent = this.eve.findViewById(f.g.parent);
        this.evj = (LinearLayout) this.eve.findViewById(f.g.groud_card_save);
        this.evj.setOnClickListener(this.eve);
        this.evk = (LinearLayout) this.eve.findViewById(f.g.group_card_share);
        if (e.aX(this.eve.getPageContext().getContext())) {
            this.evk.setOnClickListener(this.eve);
        } else {
            this.evk.setVisibility(8);
        }
        this.evl = (LinearLayout) this.eve.findViewById(f.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eve.findViewById(f.g.progress);
        this.baU = (ImageView) this.eve.findViewById(f.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eve.findViewById(f.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eve.getResources().getString(f.j.group_card_name));
        this.evm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evm.setOnClickListener(this.eve);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.baU);
        }
    }

    public void V(int i, String str) {
        if (str != null) {
            l.showToast(this.eve.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eve.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aAe() {
        this.progressBar.setVisibility(8);
    }

    public void aLf() {
        this.baU.setVisibility(0);
    }

    public View aLg() {
        return this.evj;
    }

    public View aLh() {
        return this.evk;
    }

    public View aLi() {
        return this.evm;
    }

    public View aLj() {
        return this.mNavigationBar;
    }

    public LinearLayout aLk() {
        return this.evl;
    }

    public void onChangeSkinType(int i) {
        this.eve.getLayoutMode().setNightMode(i == 1);
        this.eve.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eve.getPageContext(), i);
    }
}
