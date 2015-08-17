package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bDO;
    private final /* synthetic */ PersonalSettingItemData bDP;
    private final /* synthetic */ String tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bDO = jVar;
        this.bDP = personalSettingItemData;
        this.tB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        this.bDO.Wu().f(this.tB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bDP));
        return null;
    }
}
