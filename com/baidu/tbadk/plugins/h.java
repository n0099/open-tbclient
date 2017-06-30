package com.baidu.tbadk.plugins;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    private final /* synthetic */ int aJp;
    private final /* synthetic */ int aJq;
    private final /* synthetic */ String aJr;
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str, int i, int i2, String str2) {
        this.val$context = context;
        this.val$url = str;
        this.aJp = i;
        this.aJq = i2;
        this.aJr = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(this.val$context, this.val$url, this.aJp, this.aJq, this.aJr)));
        aVar.dismiss();
    }
}
