package com.baidu.tieba.im.chat;

import com.baidu.location.LocationClientOption;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.im.c<LinkedList<String>> {
    final /* synthetic */ q a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(q qVar, String str) {
        this.a = qVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public LinkedList<String> b() {
        return com.baidu.tieba.im.db.q.a().a(this.c, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN);
    }
}
