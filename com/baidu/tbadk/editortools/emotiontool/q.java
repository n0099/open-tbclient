package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a {
    private static q aqP = new q();
    private LinkedList<t> aqQ;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized q AY() {
        q qVar;
        synchronized (q.class) {
            qVar = aqP;
        }
        return qVar;
    }

    public List<t> getGroups() {
        return this.aqQ;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0046a interfaceC0046a) {
        if (this.aqQ == null || this.aqQ.isEmpty()) {
            this.aqQ = new LinkedList<>();
            if (TbFaceManager.Cb().AN() > 0) {
                p pVar = new p();
                this.aqQ.add(pVar);
                if (interfaceC0046a != null) {
                    interfaceC0046a.a(pVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<t> it = this.aqQ.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (interfaceC0046a != null) {
                interfaceC0046a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void AG() {
    }

    public boolean isEmpty() {
        return this.aqQ == null || this.aqQ.size() == 0;
    }
}
