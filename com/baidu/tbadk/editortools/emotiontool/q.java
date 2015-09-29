package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a {
    private static q aqO = new q();
    private LinkedList<t> aqP;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized q Bb() {
        q qVar;
        synchronized (q.class) {
            qVar = aqO;
        }
        return qVar;
    }

    public List<t> getGroups() {
        return this.aqP;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0046a interfaceC0046a) {
        if (this.aqP == null || this.aqP.isEmpty()) {
            this.aqP = new LinkedList<>();
            if (TbFaceManager.Ce().AQ() > 0) {
                p pVar = new p();
                this.aqP.add(pVar);
                if (interfaceC0046a != null) {
                    interfaceC0046a.a(pVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<t> it = this.aqP.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (interfaceC0046a != null) {
                interfaceC0046a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void AJ() {
    }

    public boolean isEmpty() {
        return this.aqP == null || this.aqP.size() == 0;
    }
}
