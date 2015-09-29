package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Comparator<v> {
    final /* synthetic */ j apf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.apf = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(v vVar, v vVar2) {
        return vVar.apt - vVar2.apt;
    }
}
