package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends w<Boolean> {
    final /* synthetic */ a doH;
    private final /* synthetic */ String doI;
    private final /* synthetic */ String doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.doH = aVar;
        this.doz = str;
        this.doI = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        ChatSetting bk = this.doH.bk(this.doz, this.doI);
        if (bk == null) {
            return false;
        }
        return Boolean.valueOf(bk.isAcceptNotify());
    }
}
