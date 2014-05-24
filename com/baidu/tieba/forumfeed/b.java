package com.baidu.tieba.forumfeed;

import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.model.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.a.i;
        if (z) {
            voiceManager = this.a.b;
            if (voiceManager != null) {
                voiceManager2 = this.a.b;
                voiceManager2.forceStop();
            }
            this.a.i = false;
        }
        if (!(obj instanceof u)) {
            if (obj != null) {
                this.a.b(obj);
                return;
            } else {
                this.a.k();
                return;
            }
        }
        this.a.a(obj);
    }
}
