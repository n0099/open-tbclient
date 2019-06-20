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
    private ImageView cGs;
    private GroupCardActivity gDe;
    private LinearLayout gDj;
    private LinearLayout gDk;
    private LinearLayout gDl;
    private View gDm;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gDj = null;
        this.gDk = null;
        this.gDl = null;
        this.gDm = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cGs = null;
        this.gDe = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gDe.setContentView(R.layout.group_card_activity);
        this.mParent = this.gDe.findViewById(R.id.parent);
        this.gDj = (LinearLayout) this.gDe.findViewById(R.id.groud_card_save);
        this.gDj.setOnClickListener(this.gDe);
        this.gDk = (LinearLayout) this.gDe.findViewById(R.id.group_card_share);
        if (f.cI(this.gDe.getPageContext().getContext())) {
            this.gDk.setOnClickListener(this.gDe);
        } else {
            this.gDk.setVisibility(8);
        }
        this.gDl = (LinearLayout) this.gDe.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gDe.findViewById(R.id.progress);
        this.cGs = (ImageView) this.gDe.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gDe.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gDe.getResources().getString(R.string.group_card_name));
        this.gDm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gDm.setOnClickListener(this.gDe);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cGs);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gDe.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gDe.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bpI() {
        this.progressBar.setVisibility(8);
    }

    public void bBD() {
        this.cGs.setVisibility(0);
    }

    public View bBE() {
        return this.gDj;
    }

    public View bBF() {
        return this.gDk;
    }

    public View bBG() {
        return this.gDm;
    }

    public View bBH() {
        return this.mNavigationBar;
    }

    public LinearLayout bBI() {
        return this.gDl;
    }

    public void onChangeSkinType(int i) {
        this.gDe.getLayoutMode().setNightMode(i == 1);
        this.gDe.getLayoutMode().onModeChanged(this.mParent);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gDe.getPageContext(), i);
    }
}
