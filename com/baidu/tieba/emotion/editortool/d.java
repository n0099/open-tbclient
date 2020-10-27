package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d ibC = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> ibD;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cog() {
        d dVar;
        synchronized (d.class) {
            dVar = ibC;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.ibD;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0578a interfaceC0578a) {
        if (this.ibD == null || this.ibD.isEmpty()) {
            this.ibD = new LinkedList<>();
            if (TbFaceManager.byD().bxq() > 0) {
                c cVar = new c();
                this.ibD.add(cVar);
                if (interfaceC0578a != null) {
                    interfaceC0578a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ibD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0578a != null) {
                interfaceC0578a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.ibD == null || this.ibD.size() == 0;
    }
}
