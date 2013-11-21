package com.baidu.tieba.forumfeed;

import com.baidu.tieba.model.ac;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumFeedActivity f1292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumFeedActivity forumFeedActivity) {
        this.f1292a = forumFeedActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.f1292a.h;
        if (z) {
            voiceManager = this.f1292a.f1291a;
            if (voiceManager != null) {
                voiceManager2 = this.f1292a.f1291a;
                voiceManager2.h();
            }
            this.f1292a.h = false;
        }
        if (obj instanceof ac) {
            this.f1292a.a(obj);
        } else if (obj != null) {
            this.f1292a.b(obj);
        } else {
            this.f1292a.M();
        }
    }
}
