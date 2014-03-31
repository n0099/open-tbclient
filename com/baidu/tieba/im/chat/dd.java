package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
final class dd implements w {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public final void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
