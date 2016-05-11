package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(k kVar, int i) {
        super(i);
        this.aXF = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016313 && this.aXF.aJw != null) {
            z = this.aXF.aXo;
            if (z) {
                TiebaStatic.log(new aw("c10808"));
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                bg.us().a(this.aXF.aJw.getPageContext(), new String[]{(String) data}, true);
            }
        }
    }
}
