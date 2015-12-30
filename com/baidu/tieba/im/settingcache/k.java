package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends m<Void> {
    final /* synthetic */ j cbj;
    private final /* synthetic */ PersonalSettingItemData cbk;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.cbj = jVar;
        this.cbk = personalSettingItemData;
        this.tC = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        this.cbj.abK().f(this.tC, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cbk));
        return null;
    }
}
