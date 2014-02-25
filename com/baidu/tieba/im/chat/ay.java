package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar) {
        this.a = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.A(), this.a.c()));
    }
}
