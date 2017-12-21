package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f csz = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> csA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f agF() {
        f fVar;
        synchronized (f.class) {
            fVar = csz;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.csA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0068a interfaceC0068a) {
        if (this.csA == null || this.csA.isEmpty()) {
            this.csA = new LinkedList<>();
            if (TbFaceManager.Ez().Dr() > 0) {
                e eVar = new e();
                this.csA.add(eVar);
                if (interfaceC0068a != null) {
                    interfaceC0068a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0068a != null) {
                interfaceC0068a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.csA == null || this.csA.size() == 0;
    }
}
