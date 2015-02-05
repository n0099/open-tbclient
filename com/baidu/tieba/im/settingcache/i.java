package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ h bpe;
    private final /* synthetic */ OfficialSettingItemData bpf;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bpe = hVar;
        this.bpf = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        this.bpe.Tl().f(this.val$key, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bpf));
        return null;
    }
}
