package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tieba.im.chat.p;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.voice.VoiceManager;
/* loaded from: classes.dex */
final class e implements p {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.p
    public final void a(VoiceManager.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.a.e;
            msglistModel.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
