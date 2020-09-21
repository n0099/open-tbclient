package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d hAk = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> hAl;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d chD() {
        d dVar;
        synchronized (d.class) {
            dVar = hAk;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.hAl;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0547a interfaceC0547a) {
        if (this.hAl == null || this.hAl.isEmpty()) {
            this.hAl = new LinkedList<>();
            if (TbFaceManager.bua().bsN() > 0) {
                c cVar = new c();
                this.hAl.add(cVar);
                if (interfaceC0547a != null) {
                    interfaceC0547a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hAl.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0547a != null) {
                interfaceC0547a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.hAl == null || this.hAl.size() == 0;
    }
}
