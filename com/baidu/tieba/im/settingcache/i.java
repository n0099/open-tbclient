package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ h bnc;
    private final /* synthetic */ OfficialSettingItemData bnd;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bnc = hVar;
        this.bnd = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        this.bnc.Tm().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bnd));
        return null;
    }
}
