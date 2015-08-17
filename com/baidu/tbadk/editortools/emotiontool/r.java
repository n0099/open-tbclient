package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends a {
    private static r aqE = new r();
    private LinkedList<v> aqF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized r Bb() {
        r rVar;
        synchronized (r.class) {
            rVar = aqE;
        }
        return rVar;
    }

    public List<v> getGroups() {
        return this.aqF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0047a interfaceC0047a) {
        if (this.aqF == null || this.aqF.isEmpty()) {
            this.aqF = new LinkedList<>();
            if (TbFaceManager.Cd().AQ() > 0) {
                q qVar = new q();
                this.aqF.add(qVar);
                if (interfaceC0047a != null) {
                    interfaceC0047a.a(qVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<v> it = this.aqF.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (interfaceC0047a != null) {
                interfaceC0047a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void AJ() {
    }

    public boolean isEmpty() {
        return this.aqF == null || this.aqF.size() == 0;
    }
}
