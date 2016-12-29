package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c cWX;
    private final /* synthetic */ GroupSettingItemData cWZ;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cWX = cVar;
        this.cWZ = groupSettingItemData;
        this.mD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mu */
    public Void doInBackground() {
        this.cWX.atb().k(this.mD, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cWZ));
        return null;
    }
}
