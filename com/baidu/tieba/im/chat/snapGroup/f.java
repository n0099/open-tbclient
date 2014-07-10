package com.baidu.tieba.im.chat.snapGroup;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.chat.v;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class f implements v {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.v
    public void a(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.a.e;
            msglistModel.a(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.v
    public void a() {
    }
}
