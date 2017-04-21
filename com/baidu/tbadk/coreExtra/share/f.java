package com.baidu.tbadk.coreExtra.share;

import android.app.AlertDialog;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    final /* synthetic */ d asc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.asc = dVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.asc.aas;
        if (alertDialog != null) {
            alertDialog2 = this.asc.aas;
            if (alertDialog2.isShowing()) {
                this.asc.dismiss();
                return null;
            }
            return null;
        }
        return null;
    }
}
