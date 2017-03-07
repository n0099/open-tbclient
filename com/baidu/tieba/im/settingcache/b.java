package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String dgA;
    private final /* synthetic */ String dgr;
    final /* synthetic */ a dgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dgz = aVar;
        this.dgr = str;
        this.dgA = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        ChatSetting bc = this.dgz.bc(this.dgr, this.dgA);
        if (bc == null) {
            return false;
        }
        return Boolean.valueOf(bc.isAcceptNotify());
    }
}
