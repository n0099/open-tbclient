package com.baidu.tieba.im.chat;

import com.baidu.tieba.voice.VoiceManager;
/* loaded from: classes.dex */
class cf implements p {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.p
    public void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.p
    public void a() {
    }
}
