package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bnn;
    private final /* synthetic */ GroupSettingItemData bnp;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bnn = cVar;
        this.bnp = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        this.bnn.Tz().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bnp));
        return null;
    }
}
