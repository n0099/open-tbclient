package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements f {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public final boolean a(String str) {
        Context context;
        if (str != null) {
            try {
                context = this.a.c;
                com.baidu.tbadk.browser.a.c(context, str);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
