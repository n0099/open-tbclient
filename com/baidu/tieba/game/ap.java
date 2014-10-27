package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ ao aIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i) {
        super(i);
        this.aIm = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        av avVar;
        av avVar2;
        au auVar;
        av avVar3;
        int i2;
        av avVar4;
        av avVar5;
        au auVar2;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage)) {
            NetWorkChangeMessage netWorkChangeMessage = (NetWorkChangeMessage) customResponsedMessage;
            boolean z = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_center_has_loaded", false);
            if (netWorkChangeMessage.mState == 2) {
                avVar3 = this.aIm.aIh;
                avVar3.HA();
                i2 = this.aIm.aIj;
                if (i2 == 0 && !z) {
                    ao aoVar = this.aIm;
                    avVar4 = this.aIm.aIh;
                    aoVar.showLoadingView(avVar4.HF(), true);
                    avVar5 = this.aIm.aIh;
                    avVar5.cn(false);
                    auVar2 = this.aIm.aIi;
                    auVar2.setPageNum(1);
                    this.aIm.bK(true);
                    com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_center_has_loaded", true);
                }
                this.aIm.aIj = 2;
            } else if (netWorkChangeMessage.mState == 1) {
                i = this.aIm.aIj;
                if (i == 0 && !z) {
                    ao aoVar2 = this.aIm;
                    avVar = this.aIm.aIh;
                    aoVar2.showLoadingView(avVar.HF(), true);
                    avVar2 = this.aIm.aIh;
                    avVar2.cn(false);
                    auVar = this.aIm.aIi;
                    auVar.setPageNum(1);
                    this.aIm.bK(true);
                    com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_center_has_loaded", true);
                }
                this.aIm.aIj = 1;
            } else if (netWorkChangeMessage.mState == -1 || netWorkChangeMessage.mState == 0) {
                this.aIm.aIj = 0;
            }
        }
    }
}
