package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends s<Void> {
    final /* synthetic */ j crl;
    private final /* synthetic */ PersonalSettingItemData crm;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.crl = jVar;
        this.crm = personalSettingItemData;
        this.jI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        this.crl.ais().e(this.jI, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.crm));
        return null;
    }
}
