package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String ddZ;
    final /* synthetic */ a deh;
    private final /* synthetic */ String dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.deh = aVar;
        this.ddZ = str;
        this.dei = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        ChatSetting bk = this.deh.bk(this.ddZ, this.dei);
        if (bk == null) {
            return false;
        }
        return Boolean.valueOf(bk.isAcceptNotify());
    }
}
