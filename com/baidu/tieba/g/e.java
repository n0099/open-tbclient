package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a fdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.fdZ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.uo().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
            this.fdZ.fdL = true;
            a aVar = this.fdZ;
            z = this.fdZ.fdL;
            aVar.fdD = z ? true : this.fdZ.fdD;
            com.baidu.tbadk.core.sharedPref.b.uo().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            this.fdZ.bae();
        }
    }
}
