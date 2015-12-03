package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends m<Void> {
    final /* synthetic */ j bXk;
    private final /* synthetic */ PersonalSettingItemData bXl;
    private final /* synthetic */ String tA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bXk = jVar;
        this.bXl = personalSettingItemData;
        this.tA = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        this.bXk.aaC().f(this.tA, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bXl));
        return null;
    }
}
