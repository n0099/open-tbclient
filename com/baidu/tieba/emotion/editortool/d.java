package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d dgJ = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dgK;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d asV() {
        d dVar;
        synchronized (d.class) {
            dVar = dgJ;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dgK;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0158a interfaceC0158a) {
        if (this.dgK == null || this.dgK.isEmpty()) {
            this.dgK = new LinkedList<>();
            if (TbFaceManager.Mp().Lg() > 0) {
                c cVar = new c();
                this.dgK.add(cVar);
                if (interfaceC0158a != null) {
                    interfaceC0158a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dgK.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0158a != null) {
                interfaceC0158a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dgK == null || this.dgK.size() == 0;
    }
}
