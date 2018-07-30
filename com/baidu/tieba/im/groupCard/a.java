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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private ImageView baU;
    private GroupCardActivity evi;
    private LinearLayout evn;
    private LinearLayout evo;
    private LinearLayout evp;
    private View evq;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.evn = null;
        this.evo = null;
        this.evp = null;
        this.evq = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.baU = null;
        this.evi = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.evi.setContentView(d.h.group_card_activity);
        this.mParent = this.evi.findViewById(d.g.parent);
        this.evn = (LinearLayout) this.evi.findViewById(d.g.groud_card_save);
        this.evn.setOnClickListener(this.evi);
        this.evo = (LinearLayout) this.evi.findViewById(d.g.group_card_share);
        if (e.aY(this.evi.getPageContext().getContext())) {
            this.evo.setOnClickListener(this.evi);
        } else {
            this.evo.setVisibility(8);
        }
        this.evp = (LinearLayout) this.evi.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.evi.findViewById(d.g.progress);
        this.baU = (ImageView) this.evi.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.evi.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.evi.getResources().getString(d.j.group_card_name));
        this.evq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evq.setOnClickListener(this.evi);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.baU);
        }
    }

    public void V(int i, String str) {
        if (str != null) {
            l.showToast(this.evi.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.evi.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aAh() {
        this.progressBar.setVisibility(8);
    }

    public void aLi() {
        this.baU.setVisibility(0);
    }

    public View aLj() {
        return this.evn;
    }

    public View aLk() {
        return this.evo;
    }

    public View aLl() {
        return this.evq;
    }

    public View aLm() {
        return this.mNavigationBar;
    }

    public LinearLayout aLn() {
        return this.evp;
    }

    public void onChangeSkinType(int i) {
        this.evi.getLayoutMode().setNightMode(i == 1);
        this.evi.getLayoutMode().onModeChanged(this.mParent);
        am.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.evi.getPageContext(), i);
    }
}
