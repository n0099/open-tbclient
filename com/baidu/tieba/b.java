package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ LogoActivity aLA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LogoActivity logoActivity, int i) {
        super(i);
        this.aLA = logoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LogoActivity.a aVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                    Intent intent = new Intent();
                    intent.putExtra("class", 30);
                    intent.putExtra("jump_url", str);
                    intent.putExtra("is_ad", true);
                    TbadkCoreApplication.setIntent(intent);
                }
                com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
                aVar = this.aLA.aLt;
                eG.removeCallbacks(aVar);
                this.aLA.Je();
            }
        }
    }
}
