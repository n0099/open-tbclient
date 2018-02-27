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
    private GroupCardActivity eGi;
    private LinearLayout eGn;
    private LinearLayout eGo;
    private LinearLayout eGp;
    private View eGq;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eGn = null;
        this.eGo = null;
        this.eGp = null;
        this.eGq = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.eGi = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eGi.setContentView(d.h.group_card_activity);
        this.mParent = this.eGi.findViewById(d.g.parent);
        this.eGn = (LinearLayout) this.eGi.findViewById(d.g.groud_card_save);
        this.eGn.setOnClickListener(this.eGi);
        this.eGo = (LinearLayout) this.eGi.findViewById(d.g.group_card_share);
        if (e.bc(this.eGi.getPageContext().getContext())) {
            this.eGo.setOnClickListener(this.eGi);
        } else {
            this.eGo.setVisibility(8);
        }
        this.eGp = (LinearLayout) this.eGi.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eGi.findViewById(d.g.progress);
        this.mImageView = (ImageView) this.eGi.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eGi.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eGi.getResources().getString(d.j.group_card_name));
        this.eGq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGq.setOnClickListener(this.eGi);
    }

    public void g(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.mImageView);
        }
    }

    public void N(int i, String str) {
        if (str != null) {
            l.showToast(this.eGi.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eGi.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void azS() {
        this.progressBar.setVisibility(8);
    }

    public void aJJ() {
        this.mImageView.setVisibility(0);
    }

    public View aJK() {
        return this.eGn;
    }

    public View aJL() {
        return this.eGo;
    }

    public View aJM() {
        return this.eGq;
    }

    public View aJN() {
        return this.mNavigationBar;
    }

    public LinearLayout aJO() {
        return this.eGp;
    }

    public void onChangeSkinType(int i) {
        this.eGi.getLayoutMode().aQ(i == 1);
        this.eGi.getLayoutMode().aM(this.mParent);
        aj.o(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eGi.getPageContext(), i);
    }
}
