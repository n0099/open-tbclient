package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(r rVar, int i) {
        super(i);
        this.bPn = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11455").aa("obj_locate", "frs"));
                com.baidu.tbadk.core.util.bb.vB().c(this.bPn.getPageContext(), new String[]{str});
            }
        }
    }
}
