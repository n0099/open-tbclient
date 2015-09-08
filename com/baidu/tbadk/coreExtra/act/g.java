package com.baidu.tbadk.coreExtra.act;

import android.widget.Toast;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends AuthorizationListener {
    final /* synthetic */ FillUProfileActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FillUProfileActivity fillUProfileActivity) {
        this.agE = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        Toast.makeText(this.agE.getPageContext().getPageActivity(), "正常化成功", 0).show();
        this.agE.wi();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        Toast.makeText(this.agE.getPageContext().getPageActivity(), String.format("%s(%d)", str, Integer.valueOf(i)), 0).show();
        this.agE.finish();
    }
}
