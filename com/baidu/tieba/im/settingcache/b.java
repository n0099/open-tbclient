package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class b extends m<Boolean> {
    private final /* synthetic */ String caQ;
    final /* synthetic */ a caY;
    private final /* synthetic */ String caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.caY = aVar;
        this.caQ = str;
        this.caZ = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aJ = this.caY.aJ(this.caQ, this.caZ);
        if (aJ == null) {
            return false;
        }
        return Boolean.valueOf(aJ.isAcceptNotify());
    }
}
