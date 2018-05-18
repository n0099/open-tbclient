package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private GroupCardActivity ech;
    private LinearLayout ecm;
    private LinearLayout ecn;
    private LinearLayout eco;
    private View ecp;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.ecm = null;
        this.ecn = null;
        this.eco = null;
        this.ecp = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.ech = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.ech.setContentView(d.i.group_card_activity);
        this.mParent = this.ech.findViewById(d.g.parent);
        this.ecm = (LinearLayout) this.ech.findViewById(d.g.groud_card_save);
        this.ecm.setOnClickListener(this.ech);
        this.ecn = (LinearLayout) this.ech.findViewById(d.g.group_card_share);
        if (e.aN(this.ech.getPageContext().getContext())) {
            this.ecn.setOnClickListener(this.ech);
        } else {
            this.ecn.setVisibility(8);
        }
        this.eco = (LinearLayout) this.ech.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.ech.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.ech.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.ech.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ech.getResources().getString(d.k.group_card_name));
        this.ecp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecp.setOnClickListener(this.ech);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void W(int i, String str) {
        if (str != null) {
            l.showToast(this.ech.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.ech.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void auK() {
        this.progressBar.setVisibility(8);
    }

    public void aEF() {
        this.mImageView.setVisibility(0);
    }

    public View aEG() {
        return this.ecm;
    }

    public View aEH() {
        return this.ecn;
    }

    public View aEI() {
        return this.ecp;
    }

    public View aEJ() {
        return this.mNavigationBar;
    }

    public LinearLayout aEK() {
        return this.eco;
    }

    public void onChangeSkinType(int i) {
        this.ech.getLayoutMode().setNightMode(i == 1);
        this.ech.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.ech.getPageContext(), i);
    }
}
