package com.baidu.tieba.im.chat;

import com.baidu.tieba.voice.VoiceManager;
/* loaded from: classes.dex */
final class ao implements p {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.p
    public final void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
