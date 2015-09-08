package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bEn;
    private final /* synthetic */ GroupSettingItemData bEp;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bEn = cVar;
        this.bEp = groupSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        this.bEn.Ww().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bEp));
        return null;
    }
}
