package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class b extends m<Boolean> {
    private final /* synthetic */ String bWR;
    final /* synthetic */ a bWZ;
    private final /* synthetic */ String bXa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bWZ = aVar;
        this.bWR = str;
        this.bXa = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aO = this.bWZ.aO(this.bWR, this.bXa);
        if (aO == null) {
            return false;
        }
        return Boolean.valueOf(aO.isAcceptNotify());
    }
}
