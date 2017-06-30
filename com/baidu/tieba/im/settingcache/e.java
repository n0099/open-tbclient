package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends w<Void> {
    final /* synthetic */ c doK;
    private final /* synthetic */ GroupSettingItemData doM;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.doK = cVar;
        this.doM = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: Ld */
    public Void doInBackground() {
        this.doK.avZ().k(this.val$key, OrmObject.jsonStrWithObject(this.doM));
        return null;
    }
}
