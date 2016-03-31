package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView bYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.bYk = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                    com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) aVar.data;
                    EmotionGroupType yE = hVar.yE();
                    String name = hVar.getName();
                    if (yE != EmotionGroupType.LOCAL && name != null) {
                        this.bYk.mContext.a(hVar);
                        this.bYk.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.bYk.mContext.acw();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.bYk.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.bYk.mContext.acx();
            }
        }
    }
}
