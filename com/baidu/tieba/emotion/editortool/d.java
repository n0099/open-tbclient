package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iIz = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iIA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cva() {
        d dVar;
        synchronized (d.class) {
            dVar = iIz;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iIA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0579a interfaceC0579a) {
        if (this.iIA == null || this.iIA.isEmpty()) {
            this.iIA = new LinkedList<>();
            if (TbFaceManager.bCR().bBC() > 0) {
                c cVar = new c();
                this.iIA.add(cVar);
                if (interfaceC0579a != null) {
                    interfaceC0579a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iIA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0579a != null) {
                interfaceC0579a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.iIA == null || this.iIA.size() == 0;
    }
}
