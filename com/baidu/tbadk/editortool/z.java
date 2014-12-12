package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z Ym = new z();
    private LinkedList<ae> Yn;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized z vb() {
        z zVar;
        synchronized (z.class) {
            zVar = Ym;
        }
        return zVar;
    }

    public List<ae> getGroups() {
        return this.Yn;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.Yn == null) {
            this.Yn = new LinkedList<>();
            if (TbFaceManager.vK().va() > 0) {
                y yVar = new y();
                this.Yn.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ae> it = this.Yn.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void register() {
    }

    public boolean isEmpty() {
        return this.Yn == null || this.Yn.size() == 0;
    }
}
