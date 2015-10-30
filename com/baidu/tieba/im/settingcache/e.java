package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ c bHB;
    private final /* synthetic */ GroupSettingItemData bHD;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bHB = cVar;
        this.bHD = groupSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gh */
    public Void doInBackground() {
        this.bHB.Xb().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bHD));
        return null;
    }
}
