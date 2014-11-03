package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class z extends e {
    private static z Sq = new z();
    private LinkedList<ad> Sr;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 1;
    }

    public static synchronized z rA() {
        z zVar;
        synchronized (z.class) {
            zVar = Sq;
        }
        return zVar;
    }

    public List<ad> getGroups() {
        return this.Sr;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(f fVar) {
        if (this.Sr == null) {
            this.Sr = new LinkedList<>();
            if (TbFaceManager.sh().rz() > 0) {
                y yVar = new y();
                this.Sr.add(yVar);
                if (fVar != null) {
                    fVar.a(yVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ad> it = this.Sr.iterator();
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
        return this.Sr == null || this.Sr.size() == 0;
    }
}
