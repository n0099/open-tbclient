package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f dlz = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dlA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f apj() {
        f fVar;
        synchronized (f.class) {
            fVar = dlz;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dlA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0081a interfaceC0081a) {
        if (this.dlA == null || this.dlA.isEmpty()) {
            this.dlA = new LinkedList<>();
            if (TbFaceManager.LO().KH() > 0) {
                e eVar = new e();
                this.dlA.add(eVar);
                if (interfaceC0081a != null) {
                    interfaceC0081a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0081a != null) {
                interfaceC0081a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dlA == null || this.dlA.size() == 0;
    }
}
