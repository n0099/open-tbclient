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
    private GroupCardActivity eba;
    private LinearLayout ebf;
    private LinearLayout ebg;
    private LinearLayout ebh;
    private View ebi;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.ebf = null;
        this.ebg = null;
        this.ebh = null;
        this.ebi = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.eba = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eba.setContentView(d.i.group_card_activity);
        this.mParent = this.eba.findViewById(d.g.parent);
        this.ebf = (LinearLayout) this.eba.findViewById(d.g.groud_card_save);
        this.ebf.setOnClickListener(this.eba);
        this.ebg = (LinearLayout) this.eba.findViewById(d.g.group_card_share);
        if (e.aN(this.eba.getPageContext().getContext())) {
            this.ebg.setOnClickListener(this.eba);
        } else {
            this.ebg.setVisibility(8);
        }
        this.ebh = (LinearLayout) this.eba.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eba.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.eba.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eba.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eba.getResources().getString(d.k.group_card_name));
        this.ebi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ebi.setOnClickListener(this.eba);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void W(int i, String str) {
        if (str != null) {
            l.showToast(this.eba.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eba.getPageContext().getContext(), errMsg);
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
        return this.ebf;
    }

    public View aEJ() {
        return this.ebg;
    }

    public View aEK() {
        return this.ebi;
    }

    public View aEL() {
        return this.mNavigationBar;
    }

    public LinearLayout aEM() {
        return this.ebh;
    }

    public void onChangeSkinType(int i) {
        this.eba.getLayoutMode().setNightMode(i == 1);
        this.eba.getLayoutMode().u(this.mParent);
        ak.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eba.getPageContext(), i);
    }
}
