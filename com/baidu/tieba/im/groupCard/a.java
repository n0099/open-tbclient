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
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends c<GroupCardActivity> {
    private ImageView cGr;
    private GroupCardActivity gDc;
    private LinearLayout gDh;
    private LinearLayout gDi;
    private LinearLayout gDj;
    private View gDk;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gDh = null;
        this.gDi = null;
        this.gDj = null;
        this.gDk = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cGr = null;
        this.gDc = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gDc.setContentView(R.layout.group_card_activity);
        this.mParent = this.gDc.findViewById(R.id.parent);
        this.gDh = (LinearLayout) this.gDc.findViewById(R.id.groud_card_save);
        this.gDh.setOnClickListener(this.gDc);
        this.gDi = (LinearLayout) this.gDc.findViewById(R.id.group_card_share);
        if (f.cI(this.gDc.getPageContext().getContext())) {
            this.gDi.setOnClickListener(this.gDc);
        } else {
            this.gDi.setVisibility(8);
        }
        this.gDj = (LinearLayout) this.gDc.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gDc.findViewById(R.id.progress);
        this.cGr = (ImageView) this.gDc.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gDc.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gDc.getResources().getString(R.string.group_card_name));
        this.gDk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gDk.setOnClickListener(this.gDc);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cGr);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gDc.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gDc.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bpG() {
        this.progressBar.setVisibility(8);
    }

    public void bBC() {
        this.cGr.setVisibility(0);
    }

    public View bBD() {
        return this.gDh;
    }

    public View bBE() {
        return this.gDi;
    }

    public View bBF() {
        return this.gDk;
    }

    public View bBG() {
        return this.mNavigationBar;
    }

    public LinearLayout bBH() {
        return this.gDj;
    }

    public void onChangeSkinType(int i) {
        this.gDc.getLayoutMode().setNightMode(i == 1);
        this.gDc.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gDc.getPageContext(), i);
    }
}
