package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Comparator<y> {
    final /* synthetic */ k asO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.asO = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(y yVar, y yVar2) {
        return yVar.launcherPriority - yVar2.launcherPriority;
    }
}
