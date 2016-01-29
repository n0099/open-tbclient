package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes.dex */
class b implements Comparator<Map.Entry<String, Integer>> {
    final /* synthetic */ a.b aqH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.b bVar) {
        this.aqH = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
        return (int) (com.baidu.adp.lib.h.b.g(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.h.b.g(String.valueOf(entry2.getValue()), 0));
    }
}
