package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class bu implements w {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aRE.mListModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void JN() {
    }
}
