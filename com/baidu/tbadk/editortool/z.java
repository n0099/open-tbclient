package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z a = new z();
    private LinkedList<ae> b;

    @Override // com.baidu.tbadk.editortool.e
    public int a() {
        return 1;
    }

    public static synchronized z c() {
        z zVar;
        synchronized (z.class) {
            zVar = a;
        }
        return zVar;
    }

    public List<ae> d() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.b == null) {
            this.b = new LinkedList<>();
            if (TbFaceManager.a().b() > 0) {
                y yVar = new y();
                this.b.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ae> it = this.b.iterator();
        while (it.hasNext()) {
            ae next = it.next();
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
