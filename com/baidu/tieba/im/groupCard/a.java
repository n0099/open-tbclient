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
    private ImageView cyi;
    private GroupCardActivity glO;
    private LinearLayout glT;
    private LinearLayout glU;
    private LinearLayout glV;
    private View glW;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.glT = null;
        this.glU = null;
        this.glV = null;
        this.glW = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cyi = null;
        this.glO = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.glO.setContentView(d.h.group_card_activity);
        this.mParent = this.glO.findViewById(d.g.parent);
        this.glT = (LinearLayout) this.glO.findViewById(d.g.groud_card_save);
        this.glT.setOnClickListener(this.glO);
        this.glU = (LinearLayout) this.glO.findViewById(d.g.group_card_share);
        if (e.dc(this.glO.getPageContext().getContext())) {
            this.glU.setOnClickListener(this.glO);
        } else {
            this.glU.setVisibility(8);
        }
        this.glV = (LinearLayout) this.glO.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.glO.findViewById(d.g.progress);
        this.cyi = (ImageView) this.glO.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.glO.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.glO.getResources().getString(d.j.group_card_name));
        this.glW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.glW.setOnClickListener(this.glO);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cyi);
        }
    }

    public void am(int i, String str) {
        if (str != null) {
            l.showToast(this.glO.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.glO.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bin() {
        this.progressBar.setVisibility(8);
    }

    public void btN() {
        this.cyi.setVisibility(0);
    }

    public View btO() {
        return this.glT;
    }

    public View btP() {
        return this.glU;
    }

    public View btQ() {
        return this.glW;
    }

    public View btR() {
        return this.mNavigationBar;
    }

    public LinearLayout btS() {
        return this.glV;
    }

    public void onChangeSkinType(int i) {
        this.glO.getLayoutMode().setNightMode(i == 1);
        this.glO.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.glO.getPageContext(), i);
    }
}
