package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends t<Void> {
    private final /* synthetic */ OfficialSettingItemData dmA;
    final /* synthetic */ h dmz;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dmz = hVar;
        this.dmA = officialSettingItemData;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        this.dmz.awF().k(this.mB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dmA));
        return null;
    }
}
