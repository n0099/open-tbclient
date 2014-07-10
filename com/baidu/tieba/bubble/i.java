package com.baidu.tieba.bubble;

import android.app.Activity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Activity activity) {
        this.a = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbWebViewActivity.startActivityForResult(this.a, TbadkApplication.m252getInst().getString(y.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion(), true, false, true, true, null, 23004);
        aVar.c();
    }
}
