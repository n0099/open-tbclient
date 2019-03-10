package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        azT();
        aH(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (DEBUG) {
            Log.d("ShareDelegation", "onSelfFinish.");
        }
        azU();
    }

    private void azT() {
    }

    private void azU() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(boolean z) {
        if (DEBUG) {
            Log.d("ShareDelegation", "notify callBack: " + z);
        }
        this.mResult.putBoolean("share_result", z);
        azU();
        finish();
    }

    private void aH(Context context, String str) {
        if (context == null) {
            gb(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.aX(new JSONObject(str));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.gb(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.gb(false);
                }
            };
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } catch (JSONException e) {
            gb(false);
        }
    }
}
