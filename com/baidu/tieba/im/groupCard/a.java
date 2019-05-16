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
    private GroupCardActivity gDb;
    private LinearLayout gDg;
    private LinearLayout gDh;
    private LinearLayout gDi;
    private View gDj;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gDg = null;
        this.gDh = null;
        this.gDi = null;
        this.gDj = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cGr = null;
        this.gDb = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gDb.setContentView(R.layout.group_card_activity);
        this.mParent = this.gDb.findViewById(R.id.parent);
        this.gDg = (LinearLayout) this.gDb.findViewById(R.id.groud_card_save);
        this.gDg.setOnClickListener(this.gDb);
        this.gDh = (LinearLayout) this.gDb.findViewById(R.id.group_card_share);
        if (f.cI(this.gDb.getPageContext().getContext())) {
            this.gDh.setOnClickListener(this.gDb);
        } else {
            this.gDh.setVisibility(8);
        }
        this.gDi = (LinearLayout) this.gDb.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gDb.findViewById(R.id.progress);
        this.cGr = (ImageView) this.gDb.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gDb.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gDb.getResources().getString(R.string.group_card_name));
        this.gDj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gDj.setOnClickListener(this.gDb);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cGr);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gDb.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gDb.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bpD() {
        this.progressBar.setVisibility(8);
    }

    public void bBz() {
        this.cGr.setVisibility(0);
    }

    public View bBA() {
        return this.gDg;
    }

    public View bBB() {
        return this.gDh;
    }

    public View bBC() {
        return this.gDj;
    }

    public View bBD() {
        return this.mNavigationBar;
    }

    public LinearLayout bBE() {
        return this.gDi;
    }

    public void onChangeSkinType(int i) {
        this.gDb.getLayoutMode().setNightMode(i == 1);
        this.gDb.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gDb.getPageContext(), i);
    }
}
