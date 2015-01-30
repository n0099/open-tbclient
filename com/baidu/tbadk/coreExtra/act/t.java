package com.baidu.tbadk.coreExtra.act;

import android.widget.Toast;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends AuthorizationListener {
    final /* synthetic */ FillUProfileActivity PU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FillUProfileActivity fillUProfileActivity) {
        this.PU = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        Toast.makeText(this.PU.getPageContext().getPageActivity(), "正常化成功", 0).show();
        this.PU.ro();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        Toast.makeText(this.PU.getPageContext().getPageActivity(), String.format("%s(%d)", str, Integer.valueOf(i)), 0).show();
        this.PU.finish();
    }
}
