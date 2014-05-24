package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bn bnVar) {
        this.b = bnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.aa.a().d(TbadkApplication.getCurrentAccount(), this.b.b()));
    }
}
