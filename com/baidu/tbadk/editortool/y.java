package com.baidu.tbadk.editortool;

import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends a {
    private static y aju = new y();
    private LinkedList<ad> ajv;

    @Override // com.baidu.tbadk.editortool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized y yQ() {
        y yVar;
        synchronized (y.class) {
            yVar = aju;
        }
        return yVar;
    }

    public List<ad> getGroups() {
        return this.ajv;
    }

    @Override // com.baidu.tbadk.editortool.a
    public void a(b bVar) {
        if (this.ajv == null || this.ajv.isEmpty()) {
            this.ajv = new LinkedList<>();
            if (TbFaceManager.zx().yF() > 0) {
                x xVar = new x();
                this.ajv.add(xVar);
                if (bVar != null) {
                    bVar.a(xVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<ad> it = this.ajv.iterator();
        while (it.hasNext()) {
            ad next = it.next();
            if (bVar != null) {
                bVar.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.a
    public void yz() {
    }

    public boolean isEmpty() {
        return this.ajv == null || this.ajv.size() == 0;
    }
}
