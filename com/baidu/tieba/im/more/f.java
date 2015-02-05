package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.core.dialog.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements l {
    final /* synthetic */ SecretSettingActivity bjW;
    private final /* synthetic */ String bjZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.bjW = secretSettingActivity;
        this.bjZ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        this.bjW.showProgressBar();
        switch (i) {
            case 0:
                this.bjW.P(this.bjZ, 1);
                break;
            case 1:
                this.bjW.P(this.bjZ, 2);
                break;
            case 2:
                this.bjW.P(this.bjZ, 3);
                break;
        }
        iVar.dismiss();
    }
}
