package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class aa extends e {
    private static aa a = new aa();
    private LinkedList<ag> b;

    @Override // com.baidu.tbadk.editortool.e
    public final int a() {
        return 1;
    }

    public static synchronized aa c() {
        aa aaVar;
        synchronized (aa.class) {
            aaVar = a;
        }
        return aaVar;
    }

    public final List<ag> d() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.e
    public final void a(f fVar) {
        if (this.b == null) {
            this.b = new LinkedList<>();
            if (TbFaceManager.a().b() > 0) {
                z zVar = new z();
                this.b.add(zVar);
                if (fVar != null) {
                    fVar.a(zVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ag> it = this.b.iterator();
        while (it.hasNext()) {
            ag next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public final void b() {
    }

    public final boolean e() {
        return this.b == null || this.b.size() == 0;
    }
}
