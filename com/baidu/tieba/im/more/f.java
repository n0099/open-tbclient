package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.core.dialog.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements l {
    final /* synthetic */ SecretSettingActivity bjX;
    private final /* synthetic */ String bka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.bjX = secretSettingActivity;
        this.bka = str;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        this.bjX.showProgressBar();
        switch (i) {
            case 0:
                this.bjX.P(this.bka, 1);
                break;
            case 1:
                this.bjX.P(this.bka, 2);
                break;
            case 2:
                this.bjX.P(this.bka, 3);
                break;
        }
        iVar.dismiss();
    }
}
