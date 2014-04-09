package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.VoiceData;
/* loaded from: classes.dex */
final class bf implements w {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public final void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.a.e.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
