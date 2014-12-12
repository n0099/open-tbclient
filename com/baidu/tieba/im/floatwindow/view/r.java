package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.chat.w {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.w
    public void b(VoiceData.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.aYF.mListModel;
            msglistModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.w
    public void JN() {
    }
}
