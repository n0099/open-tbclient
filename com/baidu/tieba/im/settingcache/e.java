package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bpa;
    private final /* synthetic */ GroupSettingItemData bpc;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bpa = cVar;
        this.bpc = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        this.bpa.Tq().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpc));
        return null;
    }
}
