package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Comparator<aa> {
    final /* synthetic */ l aqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.aqa = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(aa aaVar, aa aaVar2) {
        return aaVar.aqn - aaVar2.aqn;
    }
}
