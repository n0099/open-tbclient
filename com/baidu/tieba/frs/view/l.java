package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aGd;
    private final /* synthetic */ PopupWindow aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.aGd = frsHeaderView;
        this.aGe = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        this.aGe.dismiss();
        activity = this.aGd.aBP;
        String string = activity.getResources().getString(com.baidu.tieba.y.experion_speed);
        activity2 = this.aGd.aBP;
        TbWebViewActivity.startActivity(activity2, string, String.valueOf(com.baidu.tieba.data.e.ajC) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, false, true, true, null);
    }
}
