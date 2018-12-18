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
    private ImageView bmP;
    private GroupCardActivity eSo;
    private LinearLayout eSt;
    private LinearLayout eSu;
    private LinearLayout eSv;
    private View eSw;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.eSt = null;
        this.eSu = null;
        this.eSv = null;
        this.eSw = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.bmP = null;
        this.eSo = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.eSo.setContentView(e.h.group_card_activity);
        this.mParent = this.eSo.findViewById(e.g.parent);
        this.eSt = (LinearLayout) this.eSo.findViewById(e.g.groud_card_save);
        this.eSt.setOnClickListener(this.eSo);
        this.eSu = (LinearLayout) this.eSo.findViewById(e.g.group_card_share);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.eSo.getPageContext().getContext())) {
            this.eSu.setOnClickListener(this.eSo);
        } else {
            this.eSu.setVisibility(8);
        }
        this.eSv = (LinearLayout) this.eSo.findViewById(e.g.group_card_setting);
        this.progressBar = (ProgressBar) this.eSo.findViewById(e.g.progress);
        this.bmP = (ImageView) this.eSo.findViewById(e.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.eSo.findViewById(e.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eSo.getResources().getString(e.j.group_card_name));
        this.eSw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSw.setOnClickListener(this.eSo);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.bmP);
        }
    }

    public void R(int i, String str) {
        if (str != null) {
            l.showToast(this.eSo.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.eSo.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void aGO() {
        this.progressBar.setVisibility(8);
    }

    public void aRX() {
        this.bmP.setVisibility(0);
    }

    public View aRY() {
        return this.eSt;
    }

    public View aRZ() {
        return this.eSu;
    }

    public View aSa() {
        return this.eSw;
    }

    public View aSb() {
        return this.mNavigationBar;
    }

    public LinearLayout aSc() {
        return this.eSv;
    }

    public void onChangeSkinType(int i) {
        this.eSo.getLayoutMode().setNightMode(i == 1);
        this.eSo.getLayoutMode().onModeChanged(this.mParent);
        al.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.eSo.getPageContext(), i);
    }
}
