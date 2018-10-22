package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends ActivityDelegation implements IAiAppsSocialShareIoc.OnShareResultListener {
    private String errorCallback;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        XH();
        String string = this.mParams.getString("options");
        String string2 = this.mParams.getString("successCallback");
        this.errorCallback = this.mParams.getString("errorCallback");
        a(getAgent(), this.mParams.getString("source"), BrowserType.AI_APPS, string, string2, this.mParams.getBoolean("snapshot"), this.mParams.getBoolean("forceLightTheme"), this.errorCallback, this);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        XI();
    }

    private void XH() {
    }

    private void XI() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc.OnShareResultListener
    public void notify(String str, String str2) {
        this.mResult.putString("callBack", str);
        this.mResult.putString("info", str2);
        XI();
        finish();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc.OnShareResultListener
    public void onSharePanelCancel() {
        notify(this.errorCallback, String.valueOf(false));
    }

    private void a(Context context, String str, BrowserType browserType, String str2, String str3, boolean z, boolean z2, final String str4, final IAiAppsSocialShareIoc.OnShareResultListener onShareResultListener) {
        if (context == null) {
            onShareResultListener.notify(str4, "client error");
            return;
        }
        a aVar = new a();
        try {
            aVar.N(new JSONObject(str2));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.c.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    onShareResultListener.notify(str4, "user cancel");
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    onShareResultListener.notify(str4, "user cancel");
                }
            };
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } catch (JSONException e) {
            finish();
        }
    }
}
