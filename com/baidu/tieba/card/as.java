package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends CustomMessageListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(al alVar, int i) {
        super(i);
        this.aTK = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        com.baidu.tieba.card.a.v vVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001399) {
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                if (((Boolean) data).booleanValue()) {
                    if (this.aTK.getView().getParent() != null) {
                        this.aTK.i(true, false);
                        if (com.baidu.adp.lib.util.i.jg()) {
                            textureVideoView = this.aTK.aTx;
                            if (textureVideoView.xD()) {
                                textureVideoView2 = this.aTK.aTx;
                                vVar = this.aTK.aTD;
                                textureVideoView2.setVideoPath(vVar.aWf.tC().video_url);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.aTK.stopPlay();
            }
        }
    }
}
