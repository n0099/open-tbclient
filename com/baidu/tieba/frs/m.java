package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i) {
        super(i);
        this.bzl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11455").ab("obj_locate", "frs"));
                com.baidu.tbadk.core.util.bc.vz().c(this.bzl.getPageContext(), new String[]{str});
            }
        }
    }
}
