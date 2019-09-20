package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends c<GroupCardActivity> {
    private ImageView cIK;
    private ProgressBar gFM;
    private GroupCardActivity gLY;
    private LinearLayout gMd;
    private LinearLayout gMe;
    private LinearLayout gMf;
    private View gMg;
    private NavigationBar mNavigationBar;
    private View mParent;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gMd = null;
        this.gMe = null;
        this.gMf = null;
        this.gMg = null;
        this.gFM = null;
        this.mNavigationBar = null;
        this.cIK = null;
        this.gLY = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gLY.setContentView(R.layout.group_card_activity);
        this.mParent = this.gLY.findViewById(R.id.parent);
        this.gMd = (LinearLayout) this.gLY.findViewById(R.id.groud_card_save);
        this.gMd.setOnClickListener(this.gLY);
        this.gMe = (LinearLayout) this.gLY.findViewById(R.id.group_card_share);
        if (f.cJ(this.gLY.getPageContext().getContext())) {
            this.gMe.setOnClickListener(this.gLY);
        } else {
            this.gMe.setVisibility(8);
        }
        this.gMf = (LinearLayout) this.gLY.findViewById(R.id.group_card_setting);
        this.gFM = (ProgressBar) this.gLY.findViewById(R.id.progress);
        this.cIK = (ImageView) this.gLY.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gLY.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gLY.getResources().getString(R.string.group_card_name));
        this.gMg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gMg.setOnClickListener(this.gLY);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cIK);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gLY.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gLY.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.gFM.setVisibility(0);
    }

    public void bsJ() {
        this.gFM.setVisibility(8);
    }

    public void bFm() {
        this.cIK.setVisibility(0);
    }

    public View bFn() {
        return this.gMd;
    }

    public View bFo() {
        return this.gMe;
    }

    public View bFp() {
        return this.gMg;
    }

    public View bFq() {
        return this.mNavigationBar;
    }

    public LinearLayout bFr() {
        return this.gMf;
    }

    public void onChangeSkinType(int i) {
        this.gLY.getLayoutMode().setNightMode(i == 1);
        this.gLY.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gLY.getPageContext(), i);
    }
}
