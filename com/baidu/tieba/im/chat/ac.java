package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class ac implements w {
    final /* synthetic */ GroupChatActivity aRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GroupChatActivity groupChatActivity) {
        this.aRn = groupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aRn.mListModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void Kd() {
    }
}
