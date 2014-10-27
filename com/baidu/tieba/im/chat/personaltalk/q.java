package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<PersonalSettingItemData> {
    private final /* synthetic */ long aOU;
    final /* synthetic */ n aSy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, long j) {
        this.aSy = nVar;
        this.aOU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: KL */
    public PersonalSettingItemData doInBackground() {
        return c.KF().am(TbadkApplication.getCurrentAccount(), String.valueOf(this.aOU));
    }
}
