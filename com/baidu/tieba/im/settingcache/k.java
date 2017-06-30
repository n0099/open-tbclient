package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends w<Void> {
    final /* synthetic */ j doS;
    private final /* synthetic */ PersonalSettingItemData doT;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.doS = jVar;
        this.doT = personalSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: Ld */
    public Void doInBackground() {
        this.doS.avZ().k(this.val$key, OrmObject.jsonStrWithObject(this.doT));
        return null;
    }
}
