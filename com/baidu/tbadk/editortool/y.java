package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends a {
    private static y ajm = new y();
    private LinkedList<ad> ajn;

    @Override // com.baidu.tbadk.editortool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized y yK() {
        y yVar;
        synchronized (y.class) {
            yVar = ajm;
        }
        return yVar;
    }

    public List<ad> getGroups() {
        return this.ajn;
    }

    @Override // com.baidu.tbadk.editortool.a
    public void a(b bVar) {
        if (this.ajn == null || this.ajn.isEmpty()) {
            this.ajn = new LinkedList<>();
            if (TbFaceManager.zr().yz() > 0) {
                x xVar = new x();
                this.ajn.add(xVar);
                if (bVar != null) {
                    bVar.a(xVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ad> it = this.ajn.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (bVar != null) {
                bVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.a
    public void yt() {
    }

    public boolean isEmpty() {
        return this.ajn == null || this.ajn.size() == 0;
    }
}
