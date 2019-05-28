package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eQe = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eQf;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bcU() {
        d dVar;
        synchronized (d.class) {
            dVar = eQe;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eQf;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0251a interfaceC0251a) {
        if (this.eQf == null || this.eQf.isEmpty()) {
            this.eQf = new LinkedList<>();
            if (TbFaceManager.aso().arg() > 0) {
                c cVar = new c();
                this.eQf.add(cVar);
                if (interfaceC0251a != null) {
                    interfaceC0251a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eQf.iterator();
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
        return this.eQf == null || this.eQf.size() == 0;
    }
}
