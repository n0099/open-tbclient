package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<GroupCardActivity> {
    private LinearLayout eGD;
    private LinearLayout eGE;
    private LinearLayout eGF;
    private View eGG;
    private GroupCardActivity eGy;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eGD = null;
        this.eGE = null;
        this.eGF = null;
        this.eGG = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.eGy = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eGy.setContentView(d.h.group_card_activity);
        this.mParent = this.eGy.findViewById(d.g.parent);
        this.eGD = (LinearLayout) this.eGy.findViewById(d.g.groud_card_save);
        this.eGD.setOnClickListener(this.eGy);
        this.eGE = (LinearLayout) this.eGy.findViewById(d.g.group_card_share);
        if (e.bc(this.eGy.getPageContext().getContext())) {
            this.eGE.setOnClickListener(this.eGy);
        } else {
            this.eGE.setVisibility(8);
        }
        this.eGF = (LinearLayout) this.eGy.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eGy.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.eGy.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eGy.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eGy.getResources().getString(d.j.group_card_name));
        this.eGG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGG.setOnClickListener(this.eGy);
    }

    public void g(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void N(int i, String str) {
        if (str != null) {
            l.showToast(this.eGy.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eGy.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void azU() {
        this.progressBar.setVisibility(8);
    }

    public void aJK() {
        this.mImageView.setVisibility(0);
    }

    public View aJL() {
        return this.eGD;
    }

    public View aJM() {
        return this.eGE;
    }

    public View aJN() {
        return this.eGG;
    }

    public View aJO() {
        return this.mNavigationBar;
    }

    public LinearLayout aJP() {
        return this.eGF;
    }

    public void onChangeSkinType(int i) {
        this.eGy.getLayoutMode().aQ(i == 1);
        this.eGy.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eGy.getPageContext(), i);
    }
}
