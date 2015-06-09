package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends a {
    private static y akt = new y();
    private LinkedList<ad> aku;

    @Override // com.baidu.tbadk.editortool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized y zE() {
        y yVar;
        synchronized (y.class) {
            yVar = akt;
        }
        return yVar;
    }

    public List<ad> getGroups() {
        return this.aku;
    }

    @Override // com.baidu.tbadk.editortool.a
    public void a(b bVar) {
        if (this.aku == null || this.aku.isEmpty()) {
            this.aku = new LinkedList<>();
            if (TbFaceManager.Al().zt() > 0) {
                x xVar = new x();
                this.aku.add(xVar);
                if (bVar != null) {
                    bVar.a(xVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ad> it = this.aku.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (bVar != null) {
                bVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.a
    public void zn() {
    }

    public boolean isEmpty() {
        return this.aku == null || this.aku.size() == 0;
    }
}
