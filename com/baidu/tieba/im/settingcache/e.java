package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ c bHW;
    private final /* synthetic */ GroupSettingItemData bHY;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bHW = cVar;
        this.bHY = groupSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        this.bHW.Xw().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bHY));
        return null;
    }
}
