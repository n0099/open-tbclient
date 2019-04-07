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
    private ImageView cyh;
    private GroupCardActivity glN;
    private LinearLayout glS;
    private LinearLayout glT;
    private LinearLayout glU;
    private View glV;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.glS = null;
        this.glT = null;
        this.glU = null;
        this.glV = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cyh = null;
        this.glN = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.glN.setContentView(d.h.group_card_activity);
        this.mParent = this.glN.findViewById(d.g.parent);
        this.glS = (LinearLayout) this.glN.findViewById(d.g.groud_card_save);
        this.glS.setOnClickListener(this.glN);
        this.glT = (LinearLayout) this.glN.findViewById(d.g.group_card_share);
        if (e.dc(this.glN.getPageContext().getContext())) {
            this.glT.setOnClickListener(this.glN);
        } else {
            this.glT.setVisibility(8);
        }
        this.glU = (LinearLayout) this.glN.findViewById(d.g.group_card_setting);
        this.progressBar = (ProgressBar) this.glN.findViewById(d.g.progress);
        this.cyh = (ImageView) this.glN.findViewById(d.g.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.glN.findViewById(d.g.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.glN.getResources().getString(d.j.group_card_name));
        this.glV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.glV.setOnClickListener(this.glN);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cyh);
        }
    }

    public void am(int i, String str) {
        if (str != null) {
            l.showToast(this.glN.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.glN.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bin() {
        this.progressBar.setVisibility(8);
    }

    public void btN() {
        this.cyh.setVisibility(0);
    }

    public View btO() {
        return this.glS;
    }

    public View btP() {
        return this.glT;
    }

    public View btQ() {
        return this.glV;
    }

    public View btR() {
        return this.mNavigationBar;
    }

    public LinearLayout btS() {
        return this.glU;
    }

    public void onChangeSkinType(int i) {
        this.glN.getLayoutMode().setNightMode(i == 1);
        this.glN.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.glN.getPageContext(), i);
    }
}
