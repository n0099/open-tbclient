package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends s<Void> {
    final /* synthetic */ j dsl;
    private final /* synthetic */ PersonalSettingItemData dsm;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.dsl = jVar;
        this.dsm = personalSettingItemData;
        this.mD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        this.dsl.ayC().k(this.mD, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dsm));
        return null;
    }
}
