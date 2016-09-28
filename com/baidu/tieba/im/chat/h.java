package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cTO = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xO = lVar.xO();
                    String name = lVar.getName();
                    if (xO != EmotionGroupType.LOCAL && name != null) {
                        this.cTO.mContext.a(lVar);
                        this.cTO.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cTO.mContext.aqJ();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cTO.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cTO.mContext.aqK();
            }
        }
    }
}
