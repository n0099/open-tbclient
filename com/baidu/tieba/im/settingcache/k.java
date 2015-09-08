package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ j bEv;
    private final /* synthetic */ PersonalSettingItemData bEw;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bEv = jVar;
        this.bEw = personalSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        this.bEv.Ww().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bEw));
        return null;
    }
}
