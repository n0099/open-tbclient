package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f dlU = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dlV;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f apo() {
        f fVar;
        synchronized (f.class) {
            fVar = dlU;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dlV;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0082a interfaceC0082a) {
        if (this.dlV == null || this.dlV.isEmpty()) {
            this.dlV = new LinkedList<>();
            if (TbFaceManager.LQ().KJ() > 0) {
                e eVar = new e();
                this.dlV.add(eVar);
                if (interfaceC0082a != null) {
                    interfaceC0082a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlV.iterator();
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
        return this.dlV == null || this.dlV.size() == 0;
    }
}
