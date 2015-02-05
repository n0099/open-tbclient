package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* loaded from: classes.dex */
class u extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long aSb;
    final /* synthetic */ r aVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.aVr = rVar;
        this.aSb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Lh */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.Tp().aG(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aSb));
    }
}
