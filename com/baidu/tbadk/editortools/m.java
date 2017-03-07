package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Comparator<x> {
    final /* synthetic */ j azg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.azg = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(x xVar, x xVar2) {
        return xVar.azt - xVar2.azt;
    }
}
