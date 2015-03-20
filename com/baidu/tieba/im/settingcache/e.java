package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bmX;
    private final /* synthetic */ GroupSettingItemData bmZ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bmX = cVar;
        this.bmZ = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        this.bmX.Tm().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bmZ));
        return null;
    }
}
