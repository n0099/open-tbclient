package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bpi;
    private final /* synthetic */ PersonalSettingItemData bpj;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bpi = jVar;
        this.bpj = personalSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        this.bpi.Tq().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpj));
        return null;
    }
}
