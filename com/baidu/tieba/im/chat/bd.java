package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class bd implements v {
    final /* synthetic */ GroupChatActivity aOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(GroupChatActivity groupChatActivity) {
        this.aOr = groupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void c(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.aOr.aQe.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void BX() {
    }
}
