package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class cx implements v {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void c(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aPI.aPQ.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void BV() {
    }
}
