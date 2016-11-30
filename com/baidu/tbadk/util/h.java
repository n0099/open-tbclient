package com.baidu.tbadk.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class h extends ClickableSpan {
    private Context mContext;

    public h(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void gu(String str) {
        com.baidu.tbadk.browser.f.u(this.mContext, str);
    }

    public void gv(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, null, null)));
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }
}
