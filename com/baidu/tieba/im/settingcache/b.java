package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class b extends t<Boolean> {
    private final /* synthetic */ String cZd;
    final /* synthetic */ a cZl;
    private final /* synthetic */ String cZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cZl = aVar;
        this.cZd = str;
        this.cZm = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bg = this.cZl.bg(this.cZd, this.cZm);
        if (bg == null) {
            return false;
        }
        return Boolean.valueOf(bg.isAcceptNotify());
    }
}
