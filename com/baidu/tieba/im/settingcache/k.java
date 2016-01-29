package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends m<Void> {
    final /* synthetic */ j cfJ;
    private final /* synthetic */ PersonalSettingItemData cfK;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.cfJ = jVar;
        this.cfK = personalSettingItemData;
        this.tL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        this.cfJ.aeQ().f(this.tL, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cfK));
        return null;
    }
}
