package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cXm = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cXn;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d apZ() {
        d dVar;
        synchronized (d.class) {
            dVar = cXm;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cXn;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0110a interfaceC0110a) {
        if (this.cXn == null || this.cXn.isEmpty()) {
            this.cXn = new LinkedList<>();
            if (TbFaceManager.Kf().IW() > 0) {
                c cVar = new c();
                this.cXn.add(cVar);
                if (interfaceC0110a != null) {
                    interfaceC0110a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cXn.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0110a != null) {
                interfaceC0110a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cXn == null || this.cXn.size() == 0;
    }
}
