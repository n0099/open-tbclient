package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cGH = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cGI;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d akl() {
        d dVar;
        synchronized (d.class) {
            dVar = cGH;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cGI;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0095a interfaceC0095a) {
        if (this.cGI == null || this.cGI.isEmpty()) {
            this.cGI = new LinkedList<>();
            if (TbFaceManager.EZ().DS() > 0) {
                c cVar = new c();
                this.cGI.add(cVar);
                if (interfaceC0095a != null) {
                    interfaceC0095a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGI.iterator();
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
        return this.cGI == null || this.cGI.size() == 0;
    }
}
