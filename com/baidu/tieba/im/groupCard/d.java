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
    private ProgressBar aTV;
    private GroupCardActivity aZR;
    private LinearLayout aZW;
    private LinearLayout aZX;
    private LinearLayout aZY;
    private View aZZ;
    private View agI;
    private ImageView baa;
    private ImageView bab;
    private ImageView bac;
    private ImageView bad;
    private NavigationBar mNavigationBar;
    private ImageView rK;

    public d(GroupCardActivity groupCardActivity, View.OnClickListener onClickListener) {
        super(groupCardActivity);
        this.agI = null;
        this.aZW = null;
        this.aZX = null;
        this.aZY = null;
        this.aZZ = null;
        this.aTV = null;
        this.mNavigationBar = null;
        this.rK = null;
        this.baa = null;
        this.bab = null;
        this.bac = null;
        this.bad = null;
        this.aZR = groupCardActivity;
        initUI();
    }

    private void initUI() {
        this.aZR.setContentView(w.group_card_activity);
        this.agI = this.aZR.findViewById(v.parent);
        this.aZW = (LinearLayout) this.aZR.findViewById(v.groud_card_save);
        this.aZW.setOnClickListener(this.aZR);
        this.aZX = (LinearLayout) this.aZR.findViewById(v.group_card_share);
        if (i.y(this.aZR)) {
            this.aZX.setOnClickListener(this.aZR);
        } else {
            this.aZX.setVisibility(8);
        }
        this.aZY = (LinearLayout) this.aZR.findViewById(v.group_card_setting);
        this.aTV = (ProgressBar) this.aZR.findViewById(v.progress);
        this.rK = (ImageView) this.aZR.findViewById(v.group_card_inner_image);
        this.mNavigationBar = (NavigationBar) this.aZR.findViewById(v.group_card_topbar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.aZR.getResources().getString(y.group_card_name));
        this.aZZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZZ.setOnClickListener(this.aZR);
    }

    public void f(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.rK);
        }
    }

    public void showErr(int i, String str) {
        if (str != null) {
            m.showToast(this.aZR, str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            m.showToast(this.aZR, errMsg);
        }
    }

    public void showProgress() {
        this.aTV.setVisibility(0);
    }

    public void hideProgress() {
        this.aTV.setVisibility(8);
    }

    public void Ov() {
        this.rK.setVisibility(0);
    }

    public View Ow() {
        return this.aZW;
    }

    public View Ox() {
        return this.aZX;
    }

    public View Oy() {
        return this.aZZ;
    }

    public View Oz() {
        return this.mNavigationBar;
    }

    public LinearLayout OA() {
        return this.aZY;
    }

    public void onChangeSkinType(int i) {
        this.aZR.getLayoutMode().L(i == 1);
        this.aZR.getLayoutMode().h(this.agI);
        aw.d(this.agI, i);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
