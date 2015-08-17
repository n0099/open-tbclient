package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView bnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.bnk = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                    com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) aVar.data;
                    EmotionGroupType wu = fVar.wu();
                    String name = fVar.getName();
                    if (wu != EmotionGroupType.LOCAL && name != null) {
                        this.bnk.mContext.sendBigEmotionMsg(fVar);
                        this.bnk.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.bnk.mContext.sendTextMsg();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.bnk.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.bnk.mContext.openImageView();
            }
        }
    }
}
