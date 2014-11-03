package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<PersonalSettingItemData> {
    private final /* synthetic */ long aPi;
    final /* synthetic */ n aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, long j) {
        this.aSM = nVar;
        this.aPi = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: KP */
    public PersonalSettingItemData doInBackground() {
        return c.KJ().am(TbadkApplication.getCurrentAccount(), String.valueOf(this.aPi));
    }
}
