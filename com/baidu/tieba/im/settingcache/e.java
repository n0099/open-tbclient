package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bnD;
    private final /* synthetic */ GroupSettingItemData bnF;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bnD = cVar;
        this.bnF = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        this.bnD.SU().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bnF));
        return null;
    }
}
