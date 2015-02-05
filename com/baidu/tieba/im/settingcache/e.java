package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c boZ;
    private final /* synthetic */ GroupSettingItemData bpb;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.boZ = cVar;
        this.bpb = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        this.boZ.Tl().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpb));
        return null;
    }
}
