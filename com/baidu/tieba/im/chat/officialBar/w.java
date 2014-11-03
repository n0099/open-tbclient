package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.chat.v {
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(OfficialBarChatActivity officialBarChatActivity) {
        this.aRt = officialBarChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void c(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.aRt.aQe;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void BX() {
    }
}
