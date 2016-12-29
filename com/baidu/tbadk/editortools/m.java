package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Comparator<x> {
    final /* synthetic */ j auG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.auG = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(x xVar, x xVar2) {
        return xVar.auT - xVar2.auT;
    }
}
