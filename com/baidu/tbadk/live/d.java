package com.baidu.tbadk.live;

import com.baidu.adp.lib.cache.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements u<String> {
    final /* synthetic */ a abz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.abz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    public void onItemGet(String str, String str2) {
        if (str2 != null) {
            this.abz.onAccessTokenLoaded(str, str2);
        } else {
            this.abz.updateAccessTokenFromServer(str);
        }
    }
}
