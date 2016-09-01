package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends t<Void> {
    final /* synthetic */ c dkX;
    private final /* synthetic */ GroupSettingItemData dkZ;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dkX = cVar;
        this.dkZ = groupSettingItemData;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        this.dkX.awg().k(this.mB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dkZ));
        return null;
    }
}
