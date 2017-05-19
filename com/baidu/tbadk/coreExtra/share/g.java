package com.baidu.tbadk.coreExtra.share;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {
    final /* synthetic */ d ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.ase = dVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener;
        DialogInterface.OnDismissListener onDismissListener2;
        onDismissListener = this.ase.arV;
        if (onDismissListener != null) {
            onDismissListener2 = this.ase.arV;
            onDismissListener2.onDismiss(dialogInterface);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
    }
}
