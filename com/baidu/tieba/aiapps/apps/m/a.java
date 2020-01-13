package com.baidu.tieba.aiapps.apps.m;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.process.a.a.a {
    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        String string = bundle.getString("key_param_url");
        if (StringUtils.isNull(string)) {
            finish();
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, string));
        }
    }
}
