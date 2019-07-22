package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eVe = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eVf;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d beW() {
        d dVar;
        synchronized (d.class) {
            dVar = eVe;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eVf;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0248a interfaceC0248a) {
        if (this.eVf == null || this.eVf.isEmpty()) {
            this.eVf = new LinkedList<>();
            if (TbFaceManager.atv().asm() > 0) {
                c cVar = new c();
                this.eVf.add(cVar);
                if (interfaceC0248a != null) {
                    interfaceC0248a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVf.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0248a != null) {
                interfaceC0248a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eVf == null || this.eVf.size() == 0;
    }
}
