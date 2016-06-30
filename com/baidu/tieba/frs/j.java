package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        if (customResponsedMessage != null && b.sO().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1) != -1) {
            pVar = this.bDB.bCF;
            if (pVar.aDN() != null) {
                pVar2 = this.bDB.bCF;
                pVar2.aDN().setCanAddPhotoLivePost(true);
            }
        }
    }
}
