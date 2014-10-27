package com.baidu.tieba.forumfeed;

import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.model.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.h {
    final /* synthetic */ a aya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aya = aVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        boolean z;
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        z = this.aya.axX;
        if (z) {
            voiceManager = this.aya.axQ;
            if (voiceManager != null) {
                voiceManager2 = this.aya.axQ;
                voiceManager2.forceStop();
            }
            this.aya.axX = false;
        }
        if (!(obj instanceof u)) {
            if (obj != null) {
                this.aya.v(obj);
                return;
            } else {
                this.aya.Eg();
                return;
            }
        }
        this.aya.u(obj);
    }
}
