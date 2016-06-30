package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends s<Void> {
    final /* synthetic */ j cWB;
    private final /* synthetic */ PersonalSettingItemData cWC;
    private final /* synthetic */ String jG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.cWB = jVar;
        this.cWC = personalSettingItemData;
        this.jG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        this.cWB.aqG().e(this.jG, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cWC));
        return null;
    }
}
