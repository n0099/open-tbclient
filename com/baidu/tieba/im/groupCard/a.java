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
    private ImageView cHM;
    private GroupCardActivity gJo;
    private LinearLayout gJt;
    private LinearLayout gJu;
    private LinearLayout gJv;
    private View gJw;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gJt = null;
        this.gJu = null;
        this.gJv = null;
        this.gJw = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.cHM = null;
        this.gJo = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gJo.setContentView(R.layout.group_card_activity);
        this.mParent = this.gJo.findViewById(R.id.parent);
        this.gJt = (LinearLayout) this.gJo.findViewById(R.id.groud_card_save);
        this.gJt.setOnClickListener(this.gJo);
        this.gJu = (LinearLayout) this.gJo.findViewById(R.id.group_card_share);
        if (f.cJ(this.gJo.getPageContext().getContext())) {
            this.gJu.setOnClickListener(this.gJo);
        } else {
            this.gJu.setVisibility(8);
        }
        this.gJv = (LinearLayout) this.gJo.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gJo.findViewById(R.id.progress);
        this.cHM = (ImageView) this.gJo.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gJo.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gJo.getResources().getString(R.string.group_card_name));
        this.gJw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJw.setOnClickListener(this.gJo);
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.a(this.cHM);
        }
    }

    public void ap(int i, String str) {
        if (str != null) {
            l.showToast(this.gJo.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gJo.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void brJ() {
        this.progressBar.setVisibility(8);
    }

    public void bEk() {
        this.cHM.setVisibility(0);
    }

    public View bEl() {
        return this.gJt;
    }

    public View bEm() {
        return this.gJu;
    }

    public View bEn() {
        return this.gJw;
    }

    public View bEo() {
        return this.mNavigationBar;
    }

    public LinearLayout bEp() {
        return this.gJv;
    }

    public void onChangeSkinType(int i) {
        this.gJo.getLayoutMode().setNightMode(i == 1);
        this.gJo.getLayoutMode().onModeChanged(this.mParent);
        am.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gJo.getPageContext(), i);
    }
}
