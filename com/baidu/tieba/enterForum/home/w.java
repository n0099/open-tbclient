package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(l lVar, int i) {
        super(i);
        this.bHl = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016313 && this.bHl.aXw != null) {
            z = this.bHl.bGW;
            if (z) {
                TiebaStatic.log(new as("c10808"));
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                bb.wn().a(this.bHl.aXw.getPageContext(), new String[]{(String) data}, true);
            }
        }
    }
}
