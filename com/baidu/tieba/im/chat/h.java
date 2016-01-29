package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView bNS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.bNS = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                    com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) aVar.data;
                    EmotionGroupType yd = hVar.yd();
                    String name = hVar.getName();
                    if (yd != EmotionGroupType.LOCAL && name != null) {
                        this.bNS.mContext.a(hVar);
                        this.bNS.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.bNS.mContext.Zd();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.bNS.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.bNS.mContext.Ze();
            }
        }
    }
}
