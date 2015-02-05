package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class bx implements w {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PersonalChatActivity personalChatActivity) {
        this.aSM = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aSM.mListModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void Kd() {
    }
}
