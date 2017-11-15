package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f cjF = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cjG;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aeM() {
        f fVar;
        synchronized (f.class) {
            fVar = cjF;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cjG;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0055a interfaceC0055a) {
        if (this.cjG == null || this.cjG.isEmpty()) {
            this.cjG = new LinkedList<>();
            if (TbFaceManager.Er().Dg() > 0) {
                e eVar = new e();
                this.cjG.add(eVar);
                if (interfaceC0055a != null) {
                    interfaceC0055a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cjG.iterator();
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
        return this.cjG == null || this.cjG.size() == 0;
    }
}
