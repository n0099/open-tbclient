package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.editortools.emotiontool.a {
    private static w bFK = new w();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bFL;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized w Wr() {
        w wVar;
        synchronized (w.class) {
            wVar = bFK;
        }
        return wVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bFL;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0039a interfaceC0039a) {
        if (this.bFL == null || this.bFL.isEmpty()) {
            this.bFL = new LinkedList<>();
            if (TbFaceManager.EI().DA() > 0) {
                v vVar = new v();
                this.bFL.add(vVar);
                if (interfaceC0039a != null) {
                    interfaceC0039a.a(vVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFL.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0039a != null) {
                interfaceC0039a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bFL == null || this.bFL.size() == 0;
    }
}
