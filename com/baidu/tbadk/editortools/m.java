package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Comparator<x> {
    final /* synthetic */ j azy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.azy = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(x xVar, x xVar2) {
        return xVar.azL - xVar2.azL;
    }
}
