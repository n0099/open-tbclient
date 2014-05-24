package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends e {
    private static aa a = new aa();
    private LinkedList<af> b;

    @Override // com.baidu.tbadk.editortool.e
    public int a() {
        return 1;
    }

    public static synchronized aa c() {
        aa aaVar;
        synchronized (aa.class) {
            aaVar = a;
        }
        return aaVar;
    }

    public List<af> d() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
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
        Iterator<af> it = this.b.iterator();
        while (it.hasNext()) {
            af next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void b() {
    }

    public boolean e() {
        return this.b == null || this.b.size() == 0;
    }
}
