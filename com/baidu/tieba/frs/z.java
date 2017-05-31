package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(r rVar, int i) {
        super(i);
        this.bVb = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11455").Z("obj_locate", "frs"));
                com.baidu.tbadk.core.util.bb.vy().c(this.bVb.getPageContext(), new String[]{str});
            }
        }
    }
}
