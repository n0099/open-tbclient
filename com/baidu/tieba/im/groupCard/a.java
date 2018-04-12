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
    private GroupCardActivity ebd;
    private LinearLayout ebi;
    private LinearLayout ebj;
    private LinearLayout ebk;
    private View ebl;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.ebi = null;
        this.ebj = null;
        this.ebk = null;
        this.ebl = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.ebd = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.ebd.setContentView(d.i.group_card_activity);
        this.mParent = this.ebd.findViewById(d.g.parent);
        this.ebi = (LinearLayout) this.ebd.findViewById(d.g.groud_card_save);
        this.ebi.setOnClickListener(this.ebd);
        this.ebj = (LinearLayout) this.ebd.findViewById(d.g.group_card_share);
        if (e.aN(this.ebd.getPageContext().getContext())) {
            this.ebj.setOnClickListener(this.ebd);
        } else {
            this.ebj.setVisibility(8);
        }
        this.ebk = (LinearLayout) this.ebd.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.ebd.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.ebd.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.ebd.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ebd.getResources().getString(d.k.group_card_name));
        this.ebl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ebl.setOnClickListener(this.ebd);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void W(int i, String str) {
        if (str != null) {
            l.showToast(this.ebd.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.ebd.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void auL() {
        this.progressBar.setVisibility(8);
    }

    public void aEH() {
        this.mImageView.setVisibility(0);
    }

    public View aEI() {
        return this.ebi;
    }

    public View aEJ() {
        return this.ebj;
    }

    public View aEK() {
        return this.ebl;
    }

    public View aEL() {
        return this.mNavigationBar;
    }

    public LinearLayout aEM() {
        return this.ebk;
    }

    public void onChangeSkinType(int i) {
        this.ebd.getLayoutMode().setNightMode(i == 1);
        this.ebd.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.ebd.getPageContext(), i);
    }
}
