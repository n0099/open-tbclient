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
    private GroupCardActivity gJg;
    private LinearLayout gJl;
    private LinearLayout gJm;
    private LinearLayout gJn;
    private View gJo;
    private ImageView mImageView;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ProgressBar progressBar;

    public a(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity.getPageContext());
        this.mParent = null;
        this.gJl = null;
        this.gJm = null;
        this.gJn = null;
        this.gJo = null;
        this.progressBar = null;
        this.mNavigationBar = null;
        this.mImageView = null;
        this.gJg = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.gJg.setContentView(R.layout.group_card_activity);
        this.mParent = this.gJg.findViewById(R.id.parent);
        this.gJl = (LinearLayout) this.gJg.findViewById(R.id.groud_card_save);
        this.gJl.setOnClickListener(this.gJg);
        this.gJm = (LinearLayout) this.gJg.findViewById(R.id.group_card_share);
        if (f.cv(this.gJg.getPageContext().getContext())) {
            this.gJm.setOnClickListener(this.gJg);
        } else {
            this.gJm.setVisibility(8);
        }
        this.gJn = (LinearLayout) this.gJg.findViewById(R.id.group_card_setting);
        this.progressBar = (ProgressBar) this.gJg.findViewById(R.id.progress);
        this.mImageView = (ImageView) this.gJg.findViewById(R.id.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.gJg.findViewById(R.id.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gJg.getResources().getString(R.string.group_card_name));
        this.gJo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJo.setOnClickListener(this.gJg);
    }

    public void i(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.drawImageTo(this.mImageView);
        }
    }

    public void ao(int i, String str) {
        if (str != null) {
            l.showToast(this.gJg.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            l.showToast(this.gJg.getPageContext().getContext(), errMsg);
        }
    }

    public void showProgress() {
        this.progressBar.setVisibility(0);
    }

    public void bpL() {
        this.progressBar.setVisibility(8);
    }

    public void bBV() {
        this.mImageView.setVisibility(0);
    }

    public View bBW() {
        return this.gJl;
    }

    public View bBX() {
        return this.gJm;
    }

    public View bBY() {
        return this.gJo;
    }

    public View bBZ() {
        return this.mNavigationBar;
    }

    public LinearLayout bCa() {
        return this.gJn;
    }

    public void onChangeSkinType(int i) {
        this.gJg.getLayoutMode().setNightMode(i == 1);
        this.gJg.getLayoutMode().onModeChanged(this.mParent);
        am.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(this.gJg.getPageContext(), i);
    }
}
