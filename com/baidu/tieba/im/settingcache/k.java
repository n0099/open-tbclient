package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends t<Void> {
    final /* synthetic */ j dlf;
    private final /* synthetic */ PersonalSettingItemData dlg;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.dlf = jVar;
        this.dlg = personalSettingItemData;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        this.dlf.awg().k(this.mB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dlg));
        return null;
    }
}
