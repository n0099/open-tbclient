package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f dgX = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dgY;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aog() {
        f fVar;
        synchronized (f.class) {
            fVar = dgX;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dgY;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0082a interfaceC0082a) {
        if (this.dgY == null || this.dgY.isEmpty()) {
            this.dgY = new LinkedList<>();
            if (TbFaceManager.Ma().KS() > 0) {
                e eVar = new e();
                this.dgY.add(eVar);
                if (interfaceC0082a != null) {
                    interfaceC0082a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dgY.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0082a != null) {
                interfaceC0082a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dgY == null || this.dgY.size() == 0;
    }
}
