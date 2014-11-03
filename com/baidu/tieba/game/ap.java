package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ ao aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i) {
        super(i);
        this.aIz = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        av avVar;
        au auVar;
        av avVar2;
        int i2;
        av avVar3;
        au auVar2;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage)) {
            NetWorkChangeMessage netWorkChangeMessage = (NetWorkChangeMessage) customResponsedMessage;
            boolean z = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_center_has_loaded", false);
            if (netWorkChangeMessage.mState == 2) {
                avVar2 = this.aIz.aIt;
                avVar2.HD();
                i2 = this.aIz.aIv;
                if (i2 == 0 && !z) {
                    avVar3 = this.aIz.aIt;
                    avVar3.cn(false);
                    auVar2 = this.aIz.aIu;
                    auVar2.setPageNum(1);
                    this.aIz.bK(true);
                    com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_center_has_loaded", true);
                }
                this.aIz.aIv = 2;
            } else if (netWorkChangeMessage.mState == 1) {
                i = this.aIz.aIv;
                if (i == 0 && !z) {
                    avVar = this.aIz.aIt;
                    avVar.cn(false);
                    auVar = this.aIz.aIu;
                    auVar.setPageNum(1);
                    this.aIz.bK(true);
                    com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_center_has_loaded", true);
                }
                this.aIz.aIv = 1;
            } else if (netWorkChangeMessage.mState == -1 || netWorkChangeMessage.mState == 0) {
                this.aIz.aIv = 0;
            }
        }
    }
}
