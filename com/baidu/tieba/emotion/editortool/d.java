package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iFz = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iFA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cxs() {
        d dVar;
        synchronized (d.class) {
            dVar = iFz;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iFA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0593a interfaceC0593a) {
        if (this.iFA == null || this.iFA.isEmpty()) {
            this.iFA = new LinkedList<>();
            if (TbFaceManager.bGo().bFa() > 0) {
                c cVar = new c();
                this.iFA.add(cVar);
                if (interfaceC0593a != null) {
                    interfaceC0593a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iFA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0593a != null) {
                interfaceC0593a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.iFA == null || this.iFA.size() == 0;
    }
}
