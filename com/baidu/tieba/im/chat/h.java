package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView bnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.bnI = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                    com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) aVar.data;
                    EmotionGroupType wA = fVar.wA();
                    String name = fVar.getName();
                    if (wA != EmotionGroupType.LOCAL && name != null) {
                        this.bnI.mContext.sendBigEmotionMsg(fVar);
                        this.bnI.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.bnI.mContext.sendTextMsg();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.bnI.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.bnI.mContext.openImageView();
            }
        }
    }
}
