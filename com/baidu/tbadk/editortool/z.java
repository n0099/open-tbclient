package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z YS = new z();
    private LinkedList<ae> YT;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized z vs() {
        z zVar;
        synchronized (z.class) {
            zVar = YS;
        }
        return zVar;
    }

    public List<ae> getGroups() {
        return this.YT;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.YT == null) {
            this.YT = new LinkedList<>();
            if (TbFaceManager.wd().vr() > 0) {
                y yVar = new y();
                this.YT.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ae> it = this.YT.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            if (fVar != null) {
                fVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void rB() {
    }

    public boolean isEmpty() {
        return this.YT == null || this.YT.size() == 0;
    }
}
