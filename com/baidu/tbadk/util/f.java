package com.baidu.tbadk.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private Context mContext;

    public f(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void startWebActivity(String str) {
        com.baidu.tbadk.browser.a.y(this.mContext, str);
    }

    public void eH(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createNormalCfg(str, null, null)));
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }
}
