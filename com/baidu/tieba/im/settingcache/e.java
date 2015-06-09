package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bpT;
    private final /* synthetic */ GroupSettingItemData bpV;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bpT = cVar;
        this.bpV = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        this.bpT.UN().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpV));
        return null;
    }
}
