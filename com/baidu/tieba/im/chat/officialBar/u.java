package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.chat.w {
    final /* synthetic */ OfficialBarChatActivity aYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(OfficialBarChatActivity officialBarChatActivity) {
        this.aYU = officialBarChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void c(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.aYU.mListModel;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void Nt() {
    }
}
