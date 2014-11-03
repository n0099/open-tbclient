package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class cx implements v {
    final /* synthetic */ PersonalChatActivity aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(PersonalChatActivity personalChatActivity) {
        this.aPW = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void c(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aPW.aQe.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void BX() {
    }
}
