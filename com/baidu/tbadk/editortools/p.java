package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Comparator<aa> {
    final /* synthetic */ l avj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.avj = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(aa aaVar, aa aaVar2) {
        return aaVar.avw - aaVar2.avw;
    }
}
