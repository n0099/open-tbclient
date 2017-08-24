package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f bYn = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bYo;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f abu() {
        f fVar;
        synchronized (f.class) {
            fVar = bYn;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bYo;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0054a interfaceC0054a) {
        if (this.bYo == null || this.bYo.isEmpty()) {
            this.bYo = new LinkedList<>();
            if (TbFaceManager.Ew().Dn() > 0) {
                e eVar = new e();
                this.bYo.add(eVar);
                if (interfaceC0054a != null) {
                    interfaceC0054a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bYo.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0054a != null) {
                interfaceC0054a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bYo == null || this.bYo.size() == 0;
    }
}
