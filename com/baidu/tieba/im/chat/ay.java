package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
final class ay extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar) {
        this.a = awVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.v(), this.a.c()));
    }
}
