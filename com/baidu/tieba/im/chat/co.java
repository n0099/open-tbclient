package com.baidu.tieba.im.chat;

import com.baidu.tieba.voice.VoiceManager;
/* loaded from: classes.dex */
final class co implements p {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.p
    public final void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
