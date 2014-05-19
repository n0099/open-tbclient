package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar) {
        this.b = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.aa.a().d(TbadkApplication.getCurrentAccount(), this.b.b()));
    }
}
