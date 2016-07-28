package com.baidu.tbadk.plugins;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ int aAS;
    private final /* synthetic */ int aAT;
    private final /* synthetic */ String aAU;
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, String str, int i, int i2, String str2) {
        this.val$context = context;
        this.val$url = str;
        this.aAS = i;
        this.aAT = i2;
        this.aAU = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(this.val$context, this.val$url, this.aAS, this.aAT, this.aAU)));
        aVar.dismiss();
    }
}
