package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cIW = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xM = lVar.xM();
                    String name = lVar.getName();
                    if (xM != EmotionGroupType.LOCAL && name != null) {
                        this.cIW.mContext.a(lVar);
                        this.cIW.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cIW.mContext.alw();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cIW.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cIW.mContext.alx();
            }
        }
    }
}
