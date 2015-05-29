package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ h bpX;
    private final /* synthetic */ OfficialSettingItemData bpY;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bpX = hVar;
        this.bpY = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        this.bpX.UM().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpY));
        return null;
    }
}
