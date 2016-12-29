package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(FrsActivity frsActivity, int i) {
        super(i);
        this.bzl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.h.s sVar;
        com.baidu.tieba.frs.h.s sVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && this.bzl.byh != null && this.bzl.byh.aIk() != null) {
            SignData signData = (SignData) customResponsedMessage.getData();
            if (signData.forumId != null && signData.forumId.equals(this.bzl.byh.aIk().getId())) {
                this.bzl.byh.d(signData);
                sVar = this.bzl.bys;
                sVar.k(this.bzl.byh);
                int user_level = this.bzl.byh.aIk().getUser_level();
                sVar2 = this.bzl.bys;
                if (sVar2.abX()) {
                    user_level = this.bzl.byh.aIk().getUser_level() + 1;
                }
                TbadkCoreApplication.m9getInst().addSignedForum(this.bzl.byh.aIk().getName(), signData.sign_bonus_point, user_level);
            }
        }
    }
}
