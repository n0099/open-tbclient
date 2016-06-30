package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView cDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.cDZ = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.i)) {
                    com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) aVar.data;
                    EmotionGroupType wB = iVar.wB();
                    String name = iVar.getName();
                    if (wB != EmotionGroupType.LOCAL && name != null) {
                        this.cDZ.mContext.a(iVar);
                        this.cDZ.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.cDZ.mContext.akL();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.cDZ.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.cDZ.mContext.akM();
            }
        }
    }
}
