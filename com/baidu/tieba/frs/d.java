package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.bed = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.tJ().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "photolive_hostLevel", -1) != -1) {
            pVar = this.bed.bdo;
            if (pVar.akG() != null) {
                pVar2 = this.bed.bdo;
                pVar2.akG().setCanAddPhotoLivePost(true);
            }
        }
    }
}
