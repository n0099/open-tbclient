package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String dhf;
    final /* synthetic */ a dhn;
    private final /* synthetic */ String dho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dhn = aVar;
        this.dhf = str;
        this.dho = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        ChatSetting bf = this.dhn.bf(this.dhf, this.dho);
        if (bf == null) {
            return false;
        }
        return Boolean.valueOf(bf.isAcceptNotify());
    }
}
