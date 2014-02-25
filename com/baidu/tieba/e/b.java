package com.baidu.tieba.e;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.a.i;
        if (z) {
            voiceManager = this.a.b;
            if (voiceManager != null) {
                voiceManager2 = this.a.b;
                voiceManager2.h();
            }
            this.a.i = false;
        }
        if (!(obj instanceof com.baidu.tieba.model.r)) {
            if (obj != null) {
                this.a.b(obj);
                return;
            } else {
                this.a.j();
                return;
            }
        }
        this.a.a(obj);
    }
}
