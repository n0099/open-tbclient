package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cOT = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType yy = lVar.yy();
                    String name = lVar.getName();
                    if (yy != EmotionGroupType.LOCAL && name != null) {
                        this.cOT.mContext.a(lVar);
                        this.cOT.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cOT.mContext.aoD();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cOT.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cOT.mContext.aoE();
            }
        }
    }
}
