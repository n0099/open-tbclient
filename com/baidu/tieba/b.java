package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ LogoActivity aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LogoActivity logoActivity, int i) {
        super(i);
        this.aFj = logoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                Intent intent = new Intent();
                intent.putExtra("class", 30);
                intent.putExtra("jump_url", (String) data);
                TbadkCoreApplication.setIntent(intent);
                this.aFj.GH();
            }
        }
    }
}
