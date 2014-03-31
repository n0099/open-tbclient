package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
final class x implements com.baidu.tieba.im.chat.w {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity) {
        this.a = officialBarChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public final void a(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.a.e;
            msglistModel.a(voiceModel.voiceId, voiceModel.duration);
        }
    }
}
