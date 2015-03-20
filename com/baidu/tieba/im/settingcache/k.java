package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bnf;
    private final /* synthetic */ PersonalSettingItemData bng;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bnf = jVar;
        this.bng = personalSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        this.bnf.Tm().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bng));
        return null;
    }
}
