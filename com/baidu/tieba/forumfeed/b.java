package com.baidu.tieba.forumfeed;

import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.model.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.h {
    final /* synthetic */ a ayj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayj = aVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.ayj.ayg;
        if (z) {
            voiceManager = this.ayj.axZ;
            if (voiceManager != null) {
                voiceManager2 = this.ayj.axZ;
                voiceManager2.forceStop();
            }
            this.ayj.ayg = false;
        }
        if (!(obj instanceof u)) {
            if (obj != null) {
                this.ayj.v(obj);
                return;
            } else {
                this.ayj.Ei();
                return;
            }
        }
        this.ayj.u(obj);
    }
}
