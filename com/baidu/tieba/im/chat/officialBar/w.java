package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.chat.w {
    final /* synthetic */ OfficialBarChatActivity aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(OfficialBarChatActivity officialBarChatActivity) {
        this.aSZ = officialBarChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void b(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.aSZ.mListModel;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void JN() {
    }
}
