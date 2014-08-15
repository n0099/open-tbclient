package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
class bd implements v {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void a() {
    }
}
