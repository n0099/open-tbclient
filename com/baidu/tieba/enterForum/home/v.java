package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i iVar, int i) {
        super(i);
        this.aUE = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016313 && this.aUE.aJl != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                bf.vn().a((TbPageContext<?>) this.aUE.aJl.getPageContext(), new String[]{(String) data}, true);
            }
        }
    }
}
