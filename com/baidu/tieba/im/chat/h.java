package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cWq = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xW = lVar.xW();
                    String name = lVar.getName();
                    if (xW != EmotionGroupType.LOCAL && name != null) {
                        this.cWq.mContext.a(lVar);
                        this.cWq.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cWq.mContext.aqh();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cWq.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cWq.mContext.aqi();
            }
        }
    }
}
