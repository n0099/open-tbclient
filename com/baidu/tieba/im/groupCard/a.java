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
    private LinearLayout eGA;
    private LinearLayout eGB;
    private View eGC;
    private GroupCardActivity eGu;
    private LinearLayout eGz;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eGz = null;
        this.eGA = null;
        this.eGB = null;
        this.eGC = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.eGu = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eGu.setContentView(d.h.group_card_activity);
        this.mParent = this.eGu.findViewById(d.g.parent);
        this.eGz = (LinearLayout) this.eGu.findViewById(d.g.groud_card_save);
        this.eGz.setOnClickListener(this.eGu);
        this.eGA = (LinearLayout) this.eGu.findViewById(d.g.group_card_share);
        if (e.bc(this.eGu.getPageContext().getContext())) {
            this.eGA.setOnClickListener(this.eGu);
        } else {
            this.eGA.setVisibility(8);
        }
        this.eGB = (LinearLayout) this.eGu.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eGu.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.eGu.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eGu.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eGu.getResources().getString(d.j.group_card_name));
        this.eGC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGC.setOnClickListener(this.eGu);
    }

    public void g(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void N(int i, String str) {
        if (str != null) {
            l.showToast(this.eGu.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eGu.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void azT() {
        this.progressBar.setVisibility(8);
    }

    public void aJK() {
        this.mImageView.setVisibility(0);
    }

    public View aJL() {
        return this.eGz;
    }

    public View aJM() {
        return this.eGA;
    }

    public View aJN() {
        return this.eGC;
    }

    public View aJO() {
        return this.mNavigationBar;
    }

    public LinearLayout aJP() {
        return this.eGB;
    }

    public void onChangeSkinType(int i) {
        this.eGu.getLayoutMode().aQ(i == 1);
        this.eGu.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eGu.getPageContext(), i);
    }
}
