package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(int i) {
        this.b = i;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        if (TbadkApplication.O() != null) {
            com.baidu.tieba.im.db.o.d().a(this.b);
            return null;
        }
        return null;
    }
}
