package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f cjs = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cjt;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aeA() {
        f fVar;
        synchronized (f.class) {
            fVar = cjs;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cjt;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0055a interfaceC0055a) {
        if (this.cjt == null || this.cjt.isEmpty()) {
            this.cjt = new LinkedList<>();
            if (TbFaceManager.Ef().CU() > 0) {
                e eVar = new e();
                this.cjt.add(eVar);
                if (interfaceC0055a != null) {
                    interfaceC0055a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cjt.iterator();
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
        return this.cjt == null || this.cjt.size() == 0;
    }
}
