package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements bv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(MsglistActivity msglistActivity) {
        this.f1426a = msglistActivity;
    }

    @Override // com.baidu.tieba.im.chat.bv
    public void a(VoiceManager.VoiceModel voiceModel) {
        MsglistModel msglistModel;
        if (voiceModel != null) {
            msglistModel = this.f1426a.g;
            msglistModel.a(voiceModel.voiceId, voiceModel.duration);
        }
    }

    @Override // com.baidu.tieba.im.chat.bv
    public void a() {
    }
}
