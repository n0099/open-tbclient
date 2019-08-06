package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        aHA();
        av(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        aHB();
    }

    private void aHA() {
    }

    private void aHB() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(boolean z) {
        this.mResult.putBoolean("share_result", z);
        aHB();
        finish();
    }

    private void av(Context context, String str) {
        if (context == null) {
            gD(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.bi(new JSONObject(str));
            TiebaStatic.log(new an("c13530").bT(VideoPlayActivityConfig.OBJ_ID, aVar.clj).P("obj_type", aVar.clk).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aVar.cll));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.gD(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } catch (JSONException e) {
            gD(false);
        }
    }
}
