package com.baidu.tbadk.coreExtra.share;

import android.app.AlertDialog;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    final /* synthetic */ d asa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.asa = dVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.asa.aar;
        if (alertDialog != null) {
            alertDialog2 = this.asa.aar;
            if (alertDialog2.isShowing()) {
                this.asa.dismiss();
                return null;
            }
            return null;
        }
        return null;
    }
}
