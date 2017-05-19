package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends v<Boolean> {
    private final /* synthetic */ String dbg;
    final /* synthetic */ a dbo;
    private final /* synthetic */ String dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dbo = aVar;
        this.dbg = str;
        this.dbp = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        ChatSetting bf = this.dbo.bf(this.dbg, this.dbp);
        if (bf == null) {
            return false;
        }
        return Boolean.valueOf(bf.isAcceptNotify());
    }
}
