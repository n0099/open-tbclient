package com.baidu.tbadk.editortools;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Comparator<w> {
    final /* synthetic */ j apm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.apm = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(w wVar, w wVar2) {
        return wVar.launcherPriority - wVar2.launcherPriority;
    }
}
