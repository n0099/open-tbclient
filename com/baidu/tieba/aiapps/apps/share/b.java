package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b implements IAiAppsSocialShareIoc {
    private IAiAppsSocialShareIoc.OnShareResultListener bFn;
    private String errorCallback = "";
    private String bFm = "";
    private CustomMessageListener bFo = new CustomMessageListener(2921366) { // from class: com.baidu.tieba.aiapps.apps.share.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.bFn != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.bFn.notify(b.this.bFm, String.valueOf(true));
                } else {
                    b.this.bFn.notify(b.this.errorCallback, String.valueOf(false));
                }
            }
        }
    };

    public b() {
        TbadkCoreApplication.getInst().setSkinType(0);
        MessageManager.getInstance().registerListener(this.bFo);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc
    public void share(Context context, String str, BrowserType browserType, String str2, String str3, boolean z, boolean z2, String str4, final IAiAppsSocialShareIoc.OnShareResultListener onShareResultListener) {
        if (context instanceof Activity) {
            Bundle bundle = new Bundle();
            bundle.putString("options", str2);
            bundle.putString("successCallback", str3);
            bundle.putString("errorCallback", str4);
            bundle.putBoolean("snapshot", z);
            bundle.putBoolean("forceLightTheme", z2);
            bundle.putString("source", str);
            DelegateUtils.callOnMainWithActivity((Activity) context, AiAppsShareDelegateActivity.class, c.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (delegateResult.isOk()) {
                        String string = delegateResult.mResult.getString("callBack");
                        String string2 = delegateResult.mResult.getString("info");
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            onShareResultListener.notify(string, string2);
                        }
                    }
                }
            });
        }
    }
}
