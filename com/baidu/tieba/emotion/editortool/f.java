package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f csv = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> csw;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f agF() {
        f fVar;
        synchronized (f.class) {
            fVar = csv;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.csw;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0069a interfaceC0069a) {
        if (this.csw == null || this.csw.isEmpty()) {
            this.csw = new LinkedList<>();
            if (TbFaceManager.Ez().Dr() > 0) {
                e eVar = new e();
                this.csw.add(eVar);
                if (interfaceC0069a != null) {
                    interfaceC0069a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csw.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0069a != null) {
                interfaceC0069a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.csw == null || this.csw.size() == 0;
    }
}
