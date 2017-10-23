package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f cbP = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cbQ;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f acr() {
        f fVar;
        synchronized (f.class) {
            fVar = cbP;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cbQ;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0055a interfaceC0055a) {
        if (this.cbQ == null || this.cbQ.isEmpty()) {
            this.cbQ = new LinkedList<>();
            if (TbFaceManager.DS().CG() > 0) {
                e eVar = new e();
                this.cbQ.add(eVar);
                if (interfaceC0055a != null) {
                    interfaceC0055a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbQ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0055a != null) {
                interfaceC0055a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cbQ == null || this.cbQ.size() == 0;
    }
}
