package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ h bnI;
    private final /* synthetic */ OfficialSettingItemData bnJ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bnI = hVar;
        this.bnJ = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        this.bnI.SU().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bnJ));
        return null;
    }
}
