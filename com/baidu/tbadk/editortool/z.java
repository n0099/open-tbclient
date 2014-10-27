package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z Sm = new z();
    private LinkedList<ad> Sn;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized z ry() {
        z zVar;
        synchronized (z.class) {
            zVar = Sm;
        }
        return zVar;
    }

    public List<ad> getGroups() {
        return this.Sn;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.Sn == null) {
            this.Sn = new LinkedList<>();
            if (TbFaceManager.sf().rx() > 0) {
                y yVar = new y();
                this.Sn.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ad> it = this.Sn.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void op() {
    }

    public boolean isEmpty() {
        return this.Sn == null || this.Sn.size() == 0;
    }
}
