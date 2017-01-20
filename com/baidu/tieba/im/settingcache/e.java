package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c dek;
    private final /* synthetic */ GroupSettingItemData dem;
    private final /* synthetic */ String mw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dek = cVar;
        this.dem = groupSettingItemData;
        this.mw = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Li */
    public Void doInBackground() {
        this.dek.auh().k(this.mw, OrmObject.jsonStrWithObject(this.dem));
        return null;
    }
}
