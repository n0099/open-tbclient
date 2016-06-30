package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c cWt;
    private final /* synthetic */ GroupSettingItemData cWv;
    private final /* synthetic */ String jG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cWt = cVar;
        this.cWv = groupSettingItemData;
        this.jG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        this.cWt.aqG().e(this.jG, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cWv));
        return null;
    }
}
