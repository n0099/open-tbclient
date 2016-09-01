package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cSu = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                    com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                    EmotionGroupType xL = lVar.xL();
                    String name = lVar.getName();
                    if (xL != EmotionGroupType.LOCAL && name != null) {
                        this.cSu.mContext.a(lVar);
                        this.cSu.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cSu.mContext.aqk();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cSu.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cSu.mContext.aql();
            }
        }
    }
}
