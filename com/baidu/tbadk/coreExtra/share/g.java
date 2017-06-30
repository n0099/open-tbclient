package com.baidu.tbadk.coreExtra.share;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {
    final /* synthetic */ d asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.asQ = dVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener;
        DialogInterface.OnDismissListener onDismissListener2;
        onDismissListener = this.asQ.asI;
        if (onDismissListener != null) {
            onDismissListener2 = this.asQ.asI;
            onDismissListener2.onDismiss(dialogInterface);
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS);
    }
}
