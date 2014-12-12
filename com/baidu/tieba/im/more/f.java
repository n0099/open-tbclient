package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.core.dialog.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements l {
    final /* synthetic */ SecretSettingActivity biA;
    private final /* synthetic */ String biD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.biA = secretSettingActivity;
        this.biD = str;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        this.biA.showProgressBar();
        switch (i) {
            case 0:
                this.biA.P(this.biD, 1);
                break;
            case 1:
                this.biA.P(this.biD, 2);
                break;
            case 2:
                this.biA.P(this.biD, 3);
                break;
        }
        iVar.dismiss();
    }
}
