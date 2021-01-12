package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iAS = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iAT;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d ctB() {
        d dVar;
        synchronized (d.class) {
            dVar = iAS;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iAT;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0576a interfaceC0576a) {
        if (this.iAT == null || this.iAT.isEmpty()) {
            this.iAT = new LinkedList<>();
            if (TbFaceManager.bCw().bBh() > 0) {
                c cVar = new c();
                this.iAT.add(cVar);
                if (interfaceC0576a != null) {
                    interfaceC0576a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iAT.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0576a != null) {
                interfaceC0576a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.iAT == null || this.iAT.size() == 0;
    }
}
