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
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private LinearLayout enA;
    private LinearLayout enB;
    private LinearLayout enC;
    private View enD;
    private GroupCardActivity env;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.enA = null;
        this.enB = null;
        this.enC = null;
        this.enD = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.env = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.env.setContentView(d.i.group_card_activity);
        this.mParent = this.env.findViewById(d.g.parent);
        this.enA = (LinearLayout) this.env.findViewById(d.g.groud_card_save);
        this.enA.setOnClickListener(this.env);
        this.enB = (LinearLayout) this.env.findViewById(d.g.group_card_share);
        if (e.aX(this.env.getPageContext().getContext())) {
            this.enB.setOnClickListener(this.env);
        } else {
            this.enB.setVisibility(8);
        }
        this.enC = (LinearLayout) this.env.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.env.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.env.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.env.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.env.getResources().getString(d.k.group_card_name));
        this.enD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.enD.setOnClickListener(this.env);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void W(int i, String str) {
        if (str != null) {
            l.showToast(this.env.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.env.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void ayU() {
        this.progressBar.setVisibility(8);
    }

    public void aJA() {
        this.mImageView.setVisibility(0);
    }

    public View aJB() {
        return this.enA;
    }

    public View aJC() {
        return this.enB;
    }

    public View aJD() {
        return this.enD;
    }

    public View aJE() {
        return this.mNavigationBar;
    }

    public LinearLayout aJF() {
        return this.enC;
    }

    public void onChangeSkinType(int i) {
        this.env.getLayoutMode().setNightMode(i == 1);
        this.env.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.env.getPageContext(), i);
    }
}
