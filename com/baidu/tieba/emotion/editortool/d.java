package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eQd = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eQe;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bcR() {
        d dVar;
        synchronized (d.class) {
            dVar = eQd;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eQe;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0251a interfaceC0251a) {
        if (this.eQe == null || this.eQe.isEmpty()) {
            this.eQe = new LinkedList<>();
            if (TbFaceManager.aso().arg() > 0) {
                c cVar = new c();
                this.eQe.add(cVar);
                if (interfaceC0251a != null) {
                    interfaceC0251a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eQe.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0251a != null) {
                interfaceC0251a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eQe == null || this.eQe.size() == 0;
    }
}
