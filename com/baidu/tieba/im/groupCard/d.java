package com.baidu.tieba.im.groupCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.i;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends f {
    private ProgressBar aTH;
    private GroupCardActivity aZE;
    private LinearLayout aZJ;
    private LinearLayout aZK;
    private LinearLayout aZL;
    private View aZM;
    private ImageView aZN;
    private ImageView aZO;
    private ImageView aZP;
    private ImageView aZQ;
    private View agA;
    private NavigationBar mNavigationBar;
    private ImageView rK;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
        this.agA = null;
        this.aZJ = null;
        this.aZK = null;
        this.aZL = null;
        this.aZM = null;
        this.aTH = null;
        this.mNavigationBar = null;
        this.rK = null;
        this.aZN = null;
        this.aZO = null;
        this.aZP = null;
        this.aZQ = null;
        this.aZE = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.aZE.setContentView(w.group_card_activity);
        this.agA = this.aZE.findViewById(v.parent);
        this.aZJ = (LinearLayout) this.aZE.findViewById(v.groud_card_save);
        this.aZJ.setOnClickListener(this.aZE);
        this.aZK = (LinearLayout) this.aZE.findViewById(v.group_card_share);
        if (i.y(this.aZE)) {
            this.aZK.setOnClickListener(this.aZE);
        } else {
            this.aZK.setVisibility(8);
        }
        this.aZL = (LinearLayout) this.aZE.findViewById(v.group_card_setting);
        this.aTH = (ProgressBar) this.aZE.findViewById(v.progress);
        this.rK = (ImageView) this.aZE.findViewById(v.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.aZE.findViewById(v.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.aZE.getResources().getString(y.group_card_name));
        this.aZM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZM.setOnClickListener(this.aZE);
    }

    public void f(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.rK);
        }
    }

    public void showErr(int i, String str) {
        if (str != null) {
            m.showToast(this.aZE, str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            m.showToast(this.aZE, errMsg);
        }
    }

    public void showProgress() {
        this.aTH.setVisibility(0);
    }

    public void hideProgress() {
        this.aTH.setVisibility(8);
    }

    public void Os() {
        this.rK.setVisibility(0);
    }

    public View Ot() {
        return this.aZJ;
    }

    public View Ou() {
        return this.aZK;
    }

    public View Ov() {
        return this.aZM;
    }

    public View Ow() {
        return this.mNavigationBar;
    }

    public LinearLayout Ox() {
        return this.aZL;
    }

    public void onChangeSkinType(int i) {
        this.aZE.getLayoutMode().L(i == 1);
        this.aZE.getLayoutMode().h(this.agA);
        aw.d(this.agA, i);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
