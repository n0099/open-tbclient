package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a fcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.fcn = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.tS().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
            this.fcn.fcb = true;
            a aVar = this.fcn;
            z = this.fcn.fcb;
            aVar.fbU = z ? true : this.fcn.fbU;
            com.baidu.tbadk.core.sharedPref.b.tS().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            this.fcn.bbF();
        }
    }
}
