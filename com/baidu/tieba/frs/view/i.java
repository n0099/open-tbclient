package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;
    private final /* synthetic */ PopupWindow b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.a = frsHeaderView;
        this.b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        this.b.dismiss();
        activity = this.a.E;
        String string = activity.getResources().getString(com.baidu.tieba.x.experion_speed);
        activity2 = this.a.E;
        TbWebViewActivity.startActivity(activity2, string, String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, false, true, true, null);
    }
}
