package com.baidu.tieba.forumfeed;

import com.baidu.tieba.model.ac;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.g {
    final /* synthetic */ ForumFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumFeedActivity forumFeedActivity) {
        this.a = forumFeedActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.a.h;
        if (z) {
            voiceManager = this.a.a;
            if (voiceManager != null) {
                voiceManager2 = this.a.a;
                voiceManager2.h();
            }
            this.a.h = false;
        }
        if (obj instanceof ac) {
            this.a.a(obj);
        } else if (obj != null) {
            this.a.b(obj);
        } else {
            this.a.M();
        }
    }
}
