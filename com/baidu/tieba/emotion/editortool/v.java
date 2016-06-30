package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v brX = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> brY;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Rz() {
        v vVar;
        synchronized (v.class) {
            vVar = brX;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.brY;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0040a interfaceC0040a) {
        if (this.brY == null || this.brY.isEmpty()) {
            this.brY = new LinkedList<>();
            if (TbFaceManager.CP().BD() > 0) {
                u uVar = new u();
                this.brY.add(uVar);
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.brY.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0040a != null) {
                interfaceC0040a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void BC() {
    }

    public boolean isEmpty() {
        return this.brY == null || this.brY.size() == 0;
    }
}
