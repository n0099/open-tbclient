package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ c bHq;
    private final /* synthetic */ GroupSettingItemData bHs;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bHq = cVar;
        this.bHs = groupSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        this.bHq.Xf().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bHs));
        return null;
    }
}
