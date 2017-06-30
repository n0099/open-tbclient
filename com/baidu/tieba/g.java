package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ LogoActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LogoActivity logoActivity, int i) {
        super(i);
        this.aRW = logoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LogoActivity.a aVar;
        boolean Jv;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                    Jv = this.aRW.Jv();
                    if (Jv) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("class", 30);
                        intent.putExtra("jump_url", str);
                        intent.putExtra("is_ad", true);
                        TbadkCoreApplication.setIntent(intent);
                    }
                }
                com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
                aVar = this.aRW.aRQ;
                fR.removeCallbacks(aVar);
                this.aRW.JC();
            }
        }
    }
}
