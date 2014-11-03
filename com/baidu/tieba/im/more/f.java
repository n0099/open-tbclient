package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.core.dialog.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements l {
    final /* synthetic */ SecretSettingActivity bfh;
    private final /* synthetic */ String bfk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.bfh = secretSettingActivity;
        this.bfk = str;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        this.bfh.showProgressBar();
        switch (i) {
            case 0:
                this.bfh.I(this.bfk, 1);
                break;
            case 1:
                this.bfh.I(this.bfk, 2);
                break;
            case 2:
                this.bfh.I(this.bfk, 3);
                break;
        }
        iVar.dismiss();
    }
}
