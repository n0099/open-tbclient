package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f doz = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> doA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aqc() {
        f fVar;
        synchronized (f.class) {
            fVar = doz;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.doA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0106a interfaceC0106a) {
        if (this.doA == null || this.doA.isEmpty()) {
            this.doA = new LinkedList<>();
            if (TbFaceManager.Mv().Lo() > 0) {
                e eVar = new e();
                this.doA.add(eVar);
                if (interfaceC0106a != null) {
                    interfaceC0106a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.doA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0106a != null) {
                interfaceC0106a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.doA == null || this.doA.size() == 0;
    }
}
