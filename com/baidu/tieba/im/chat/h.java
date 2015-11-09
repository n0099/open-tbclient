package com.baidu.tieba.im.chat;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ AbsMsglistView brw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AbsMsglistView absMsglistView) {
        this.brw = absMsglistView;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 24) {
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                    com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) aVar.data;
                    EmotionGroupType wm = fVar.wm();
                    String name = fVar.getName();
                    if (wm != EmotionGroupType.LOCAL && name != null) {
                        this.brw.mContext.sendBigEmotionMsg(fVar);
                        this.brw.onSendEmotion();
                    }
                }
            } else if (aVar.code == 8) {
                this.brw.mContext.sendTextMsg();
            } else if (aVar.code == 4) {
                if (aVar.data != null && (aVar.data instanceof String)) {
                    this.brw.mTextContent = (String) aVar.data;
                }
            } else if (aVar.code == 14) {
                this.brw.mContext.openImageView();
            }
        }
    }
}
