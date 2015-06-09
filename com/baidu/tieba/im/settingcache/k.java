package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bqb;
    private final /* synthetic */ PersonalSettingItemData bqc;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bqb = jVar;
        this.bqc = personalSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        this.bqb.UN().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bqc));
        return null;
    }
}
