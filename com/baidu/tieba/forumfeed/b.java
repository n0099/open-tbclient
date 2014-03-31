package com.baidu.tieba.forumfeed;

import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.model.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.a.h {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
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
        if (obj instanceof u) {
            a.a(this.a, obj);
        } else if (obj != null) {
            a.b(this.a, obj);
        } else {
            a.c(this.a);
        }
    }
}
