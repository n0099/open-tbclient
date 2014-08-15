package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.a = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.y.a().c(TbadkApplication.getCurrentAccount(), this.a.b()));
    }
}
