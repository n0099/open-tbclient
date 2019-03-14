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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class a extends c<GroupCardActivity> {
    private ImageView cyf;
    private GroupCardActivity gma;
    private LinearLayout gmf;
    private LinearLayout gmg;
    private LinearLayout gmh;
    private View gmi;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gmf = null;
        this.gmg = null;
        this.gmh = null;
        this.gmi = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cyf = null;
        this.gma = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gma.setContentView(d.h.group_card_activity);
        this.mParent = this.gma.findViewById(d.g.parent);
        this.gmf = (LinearLayout) this.gma.findViewById(d.g.groud_card_save);
        this.gmf.setOnClickListener(this.gma);
        this.gmg = (LinearLayout) this.gma.findViewById(d.g.group_card_share);
        if (e.dc(this.gma.getPageContext().getContext())) {
            this.gmg.setOnClickListener(this.gma);
        } else {
            this.gmg.setVisibility(8);
        }
        this.gmh = (LinearLayout) this.gma.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.gma.findViewById(d.g.progress);
        this.cyf = (ImageView) this.gma.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gma.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gma.getResources().getString(d.j.group_card_name));
        this.gmi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gmi.setOnClickListener(this.gma);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cyf);
        }
    }

    public void ak(int i, String str) {
        if (str != null) {
            l.showToast(this.gma.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gma.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bip() {
        this.progressBar.setVisibility(8);
    }

    public void btQ() {
        this.cyf.setVisibility(0);
    }

    public View btR() {
        return this.gmf;
    }

    public View btS() {
        return this.gmg;
    }

    public View btT() {
        return this.gmi;
    }

    public View btU() {
        return this.mNavigationBar;
    }

    public LinearLayout btV() {
        return this.gmh;
    }

    public void onChangeSkinType(int i) {
        this.gma.getLayoutMode().setNightMode(i == 1);
        this.gma.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gma.getPageContext(), i);
    }
}
