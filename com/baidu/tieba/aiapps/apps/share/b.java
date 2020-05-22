package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        boD();
        aA(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        boE();
    }

    private void boD() {
    }

    private void boE() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc(boolean z) {
        this.mResult.putBoolean("share_result", z);
        boE();
        finish();
    }

    private void aA(Context context, String str) {
        if (context == null) {
            jc(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.cK(new JSONObject(str));
            TiebaStatic.log(new an("c13530").dh("obj_id", aVar.efm).ag("obj_type", aVar.efn).dh("obj_source", aVar.efo));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.jc(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        } catch (JSONException e) {
            jc(false);
        }
    }
}
