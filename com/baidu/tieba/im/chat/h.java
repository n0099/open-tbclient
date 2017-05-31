package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cOu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cOu = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xF = lVar.xF();
                    String name = lVar.getName();
                    if (xF != EmotionGroupType.LOCAL && name != null) {
                        this.cOu.mContext.a(lVar);
                        this.cOu.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cOu.mContext.amw();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cOu.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cOu.mContext.amx();
            }
        }
    }
}
