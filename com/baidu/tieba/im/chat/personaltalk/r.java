package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long aQT;
    final /* synthetic */ o aTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, long j) {
        this.aTZ = oVar;
        this.aQT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KR */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.SY().aD(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aQT));
    }
}
