package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(i iVar, int i) {
        super(i);
        this.bbw = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016313 && this.bbw.aNm != null) {
            z = this.bbw.bbf;
            if (z) {
                TiebaStatic.log(new aw("c10808"));
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                bg.wM().a(this.bbw.aNm.getPageContext(), new String[]{(String) data}, true);
            }
        }
    }
}
