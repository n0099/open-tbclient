package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.core.dialog.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements l {
    final /* synthetic */ SecretSettingActivity beT;
    private final /* synthetic */ String beW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.beT = secretSettingActivity;
        this.beW = str;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        this.beT.showProgressBar();
        switch (i) {
            case 0:
                this.beT.I(this.beW, 1);
                break;
            case 1:
                this.beT.I(this.beW, 2);
                break;
            case 2:
                this.beT.I(this.beW, 3);
                break;
        }
        iVar.dismiss();
    }
}
