package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView bGC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.bGC = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                    com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) aVar.data;
                    EmotionGroupType xh = hVar.xh();
                    String name = hVar.getName();
                    if (xh != EmotionGroupType.LOCAL && name != null) {
                        this.bGC.mContext.sendBigEmotionMsg(hVar);
                        this.bGC.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.bGC.mContext.sendTextMsg();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.bGC.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.bGC.mContext.openImageView();
            }
        }
    }
}
