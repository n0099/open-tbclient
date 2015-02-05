package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.Comparator;
import java.util.Map;
/* loaded from: classes.dex */
class d implements Comparator<Map.Entry<String, Integer>> {
    final /* synthetic */ c VJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.VJ = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
        return (int) (com.baidu.adp.lib.g.c.toInt(String.valueOf(entry.getValue()), 0) - com.baidu.adp.lib.g.c.toInt(String.valueOf(entry2.getValue()), 0));
    }
}
