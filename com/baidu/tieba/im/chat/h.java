package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cEI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cEI = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xI = lVar.xI();
                    String name = lVar.getName();
                    if (xI != EmotionGroupType.LOCAL && name != null) {
                        this.cEI.mContext.a(lVar);
                        this.cEI.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cEI.mContext.ang();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cEI.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cEI.mContext.anh();
            }
        }
    }
}
