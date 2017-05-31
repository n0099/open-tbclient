package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends v<Boolean> {
    private final /* synthetic */ String dgD;
    final /* synthetic */ a dgL;
    private final /* synthetic */ String dgM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dgL = aVar;
        this.dgD = str;
        this.dgM = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        ChatSetting bd = this.dgL.bd(this.dgD, this.dgM);
        if (bd == null) {
            return false;
        }
        return Boolean.valueOf(bd.isAcceptNotify());
    }
}
