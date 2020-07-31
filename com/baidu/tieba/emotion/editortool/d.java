package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d hgg = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> hgh;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bUb() {
        d dVar;
        synchronized (d.class) {
            dVar = hgg;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.hgh;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0506a interfaceC0506a) {
        if (this.hgh == null || this.hgh.isEmpty()) {
            this.hgh = new LinkedList<>();
            if (TbFaceManager.bkj().biY() > 0) {
                c cVar = new c();
                this.hgh.add(cVar);
                if (interfaceC0506a != null) {
                    interfaceC0506a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hgh.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0506a != null) {
                interfaceC0506a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.hgh == null || this.hgh.size() == 0;
    }
}
