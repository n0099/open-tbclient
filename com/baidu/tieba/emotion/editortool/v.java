package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bum = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bun;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Sg() {
        v vVar;
        synchronized (v.class) {
            vVar = bum;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bun;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        if (this.bun == null || this.bun.isEmpty()) {
            this.bun = new LinkedList<>();
            if (TbFaceManager.CO().BD() > 0) {
                u uVar = new u();
                this.bun.add(uVar);
                if (interfaceC0041a != null) {
                    interfaceC0041a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bun.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0041a != null) {
                interfaceC0041a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void BC() {
    }

    public boolean isEmpty() {
        return this.bun == null || this.bun.size() == 0;
    }
}
