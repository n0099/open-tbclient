package com.baidu.tbadk.editortool;

import java.util.List;
/* loaded from: classes.dex */
public abstract class e implements Comparable<e> {
    public abstract void getEmotions(f fVar);

    public abstract List<af> getGroups();

    public abstract int getIndex();

    public abstract boolean isEmpty();

    protected abstract void register();

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        register();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(e eVar) {
        if (eVar == null) {
            return 1;
        }
        return getIndex() - eVar.getIndex();
    }
}
