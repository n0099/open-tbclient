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
    private GroupCardActivity eKg;
    private LinearLayout eKl;
    private LinearLayout eKm;
    private LinearLayout eKn;
    private View eKo;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eKl = null;
        this.eKm = null;
        this.eKn = null;
        this.eKo = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.biG = null;
        this.eKg = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eKg.setContentView(e.h.group_card_activity);
        this.mParent = this.eKg.findViewById(e.g.parent);
        this.eKl = (LinearLayout) this.eKg.findViewById(e.g.groud_card_save);
        this.eKl.setOnClickListener(this.eKg);
        this.eKm = (LinearLayout) this.eKg.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eKg.getPageContext().getContext())) {
            this.eKm.setOnClickListener(this.eKg);
        } else {
            this.eKm.setVisibility(8);
        }
        this.eKn = (LinearLayout) this.eKg.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eKg.findViewById(e.g.progress);
        this.biG = (ImageView) this.eKg.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eKg.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eKg.getResources().getString(e.j.group_card_name));
        this.eKo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKo.setOnClickListener(this.eKg);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.biG);
        }
    }

    public void V(int i, String str) {
        if (str != null) {
            l.showToast(this.eKg.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eKg.getPageContext().getContext(), errMsg);
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
        return this.eKl;
    }

    public View aQL() {
        return this.eKm;
    }

    public View aQM() {
        return this.eKo;
    }

    public View aQN() {
        return this.mNavigationBar;
    }

    public LinearLayout aQO() {
        return this.eKn;
    }

    public void onChangeSkinType(int i) {
        this.eKg.getLayoutMode().setNightMode(i == 1);
        this.eKg.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eKg.getPageContext(), i);
    }
}
