package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bDG;
    private final /* synthetic */ GroupSettingItemData bDI;
    private final /* synthetic */ String tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bDG = cVar;
        this.bDI = groupSettingItemData;
        this.tB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        this.bDG.Wu().f(this.tB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bDI));
        return null;
    }
}
