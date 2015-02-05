package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z YP = new z();
    private LinkedList<ae> YQ;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized z vm() {
        z zVar;
        synchronized (z.class) {
            zVar = YP;
        }
        return zVar;
    }

    public List<ae> getGroups() {
        return this.YQ;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.YQ == null) {
            this.YQ = new LinkedList<>();
            if (TbFaceManager.vX().vl() > 0) {
                y yVar = new y();
                this.YQ.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ae> it = this.YQ.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void rv() {
    }

    public boolean isEmpty() {
        return this.YQ == null || this.YQ.size() == 0;
    }
}
