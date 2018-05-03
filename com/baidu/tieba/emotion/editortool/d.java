package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cGE = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cGF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d akl() {
        d dVar;
        synchronized (d.class) {
            dVar = cGE;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cGF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0095a interfaceC0095a) {
        if (this.cGF == null || this.cGF.isEmpty()) {
            this.cGF = new LinkedList<>();
            if (TbFaceManager.EZ().DS() > 0) {
                c cVar = new c();
                this.cGF.add(cVar);
                if (interfaceC0095a != null) {
                    interfaceC0095a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0095a != null) {
                interfaceC0095a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cGF == null || this.cGF.size() == 0;
    }
}
