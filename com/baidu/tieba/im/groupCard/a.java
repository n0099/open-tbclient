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
    private ImageView cHT;
    private GroupCardActivity gKg;
    private LinearLayout gKl;
    private LinearLayout gKm;
    private LinearLayout gKn;
    private View gKo;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gKl = null;
        this.gKm = null;
        this.gKn = null;
        this.gKo = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cHT = null;
        this.gKg = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gKg.setContentView(R.layout.group_card_activity);
        this.mParent = this.gKg.findViewById(R.id.parent);
        this.gKl = (LinearLayout) this.gKg.findViewById(R.id.groud_card_save);
        this.gKl.setOnClickListener(this.gKg);
        this.gKm = (LinearLayout) this.gKg.findViewById(R.id.group_card_share);
        if (f.cJ(this.gKg.getPageContext().getContext())) {
            this.gKm.setOnClickListener(this.gKg);
        } else {
            this.gKm.setVisibility(8);
        }
        this.gKn = (LinearLayout) this.gKg.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gKg.findViewById(R.id.progress);
        this.cHT = (ImageView) this.gKg.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gKg.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gKg.getResources().getString(R.string.group_card_name));
        this.gKo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gKo.setOnClickListener(this.gKg);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cHT);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gKg.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gKg.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void brW() {
        this.progressBar.setVisibility(8);
    }

    public void bEy() {
        this.cHT.setVisibility(0);
    }

    public View bEz() {
        return this.gKl;
    }

    public View bEA() {
        return this.gKm;
    }

    public View bEB() {
        return this.gKo;
    }

    public View bEC() {
        return this.mNavigationBar;
    }

    public LinearLayout bED() {
        return this.gKn;
    }

    public void onChangeSkinType(int i) {
        this.gKg.getLayoutMode().setNightMode(i == 1);
        this.gKg.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gKg.getPageContext(), i);
    }
}
