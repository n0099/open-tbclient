package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(l lVar, int i) {
        super(i);
        this.bHc = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016313 && this.bHc.aTi != null) {
            z = this.bHc.bGN;
            if (z) {
                TiebaStatic.log(new ay("c10808"));
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                bi.vx().a(this.bHc.aTi.getPageContext(), new String[]{(String) data}, true);
            }
        }
    }
}
