package com.baidu.tbadk.game;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.n;
/* loaded from: classes.dex */
public class a extends n {
    public static void b(Context context, String str, String str2, String str3) {
        b.Ec().ap(str3, str2);
        e.Ef().D(str3, 2);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameWebViewActivityConfig(context, str, str2, str3, true)));
    }
}
