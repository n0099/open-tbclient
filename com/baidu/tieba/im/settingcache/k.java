package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends t<Void> {
    final /* synthetic */ j dmC;
    private final /* synthetic */ PersonalSettingItemData dmD;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.dmC = jVar;
        this.dmD = personalSettingItemData;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        this.dmC.awF().k(this.mB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dmD));
        return null;
    }
}
