package com.baidu.tieba.im.chat;

import com.baidu.location.LocationClientOption;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.tieba.im.b<LinkedList<String>> {
    final /* synthetic */ x b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(x xVar, String str) {
        this.b = xVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedList<String> a() {
        return com.baidu.tieba.im.db.c.a().a(this.c, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN);
    }
}
