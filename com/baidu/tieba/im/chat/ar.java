package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(int i) {
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (TbadkApplication.getCurrentAccountName() != null) {
            com.baidu.tieba.im.db.o.d().a(this.b);
            return null;
        }
        return null;
    }
}
