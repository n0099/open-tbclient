package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    private final /* synthetic */ PopupWindow aFU;
    final /* synthetic */ r aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar, PopupWindow popupWindow) {
        this.aGk = rVar;
        this.aFU = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        this.aFU.dismiss();
        activity = this.aGk.aBF;
        String string = activity.getResources().getString(com.baidu.tieba.y.experion_speed);
        activity2 = this.aGk.aBF;
        TbWebViewActivity.startActivity(activity2, string, String.valueOf(com.baidu.tieba.data.e.ajt) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, false, true, true, null);
    }
}
