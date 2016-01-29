package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class b extends m<Boolean> {
    private final /* synthetic */ String cfq;
    final /* synthetic */ a cfy;
    private final /* synthetic */ String cfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cfy = aVar;
        this.cfq = str;
        this.cfz = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aO = this.cfy.aO(this.cfq, this.cfz);
        if (aO == null) {
            return false;
        }
        return Boolean.valueOf(aO.isAcceptNotify());
    }
}
