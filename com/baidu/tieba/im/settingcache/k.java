package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bnL;
    private final /* synthetic */ PersonalSettingItemData bnM;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bnL = jVar;
        this.bnM = personalSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        this.bnL.SU().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bnM));
        return null;
    }
}
