package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends t<Void> {
    final /* synthetic */ j cZw;
    private final /* synthetic */ PersonalSettingItemData cZx;
    private final /* synthetic */ String kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.cZw = jVar;
        this.cZx = personalSettingItemData;
        this.kj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        this.cZw.ars().k(this.kj, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cZx));
        return null;
    }
}
