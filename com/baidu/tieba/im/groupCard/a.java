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
    private ImageView biG;
    private GroupCardActivity eKh;
    private LinearLayout eKm;
    private LinearLayout eKn;
    private LinearLayout eKo;
    private View eKp;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eKm = null;
        this.eKn = null;
        this.eKo = null;
        this.eKp = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.biG = null;
        this.eKh = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eKh.setContentView(e.h.group_card_activity);
        this.mParent = this.eKh.findViewById(e.g.parent);
        this.eKm = (LinearLayout) this.eKh.findViewById(e.g.groud_card_save);
        this.eKm.setOnClickListener(this.eKh);
        this.eKn = (LinearLayout) this.eKh.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eKh.getPageContext().getContext())) {
            this.eKn.setOnClickListener(this.eKh);
        } else {
            this.eKn.setVisibility(8);
        }
        this.eKo = (LinearLayout) this.eKh.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eKh.findViewById(e.g.progress);
        this.biG = (ImageView) this.eKh.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eKh.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eKh.getResources().getString(e.j.group_card_name));
        this.eKp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKp.setOnClickListener(this.eKh);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.biG);
        }
    }

    public void V(int i, String str) {
        if (str != null) {
            l.showToast(this.eKh.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eKh.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aFG() {
        this.progressBar.setVisibility(8);
    }

    public void aQJ() {
        this.biG.setVisibility(0);
    }

    public View aQK() {
        return this.eKm;
    }

    public View aQL() {
        return this.eKn;
    }

    public View aQM() {
        return this.eKp;
    }

    public View aQN() {
        return this.mNavigationBar;
    }

    public LinearLayout aQO() {
        return this.eKo;
    }

    public void onChangeSkinType(int i) {
        this.eKh.getLayoutMode().setNightMode(i == 1);
        this.eKh.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eKh.getPageContext(), i);
    }
}
