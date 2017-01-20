package com.baidu.tbadk.game;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.m;
/* loaded from: classes.dex */
public class a extends m {
    public static void b(Context context, String str, String str2, String str3) {
        b.DF().ap(str3, str2);
        e.DI().D(str3, 2);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameWebViewActivityConfig(context, str, str2, str3, true)));
    }
}
