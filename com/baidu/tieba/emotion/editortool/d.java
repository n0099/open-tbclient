package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d itm = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> itn;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cuz() {
        d dVar;
        synchronized (d.class) {
            dVar = itm;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.itn;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0602a interfaceC0602a) {
        if (this.itn == null || this.itn.isEmpty()) {
            this.itn = new LinkedList<>();
            if (TbFaceManager.bDU().bCF() > 0) {
                c cVar = new c();
                this.itn.add(cVar);
                if (interfaceC0602a != null) {
                    interfaceC0602a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.itn.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0602a != null) {
                interfaceC0602a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.itn == null || this.itn.size() == 0;
    }
}
