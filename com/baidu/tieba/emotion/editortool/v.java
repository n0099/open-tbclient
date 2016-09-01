package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bFz = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bFA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v WS() {
        v vVar;
        synchronized (v.class) {
            vVar = bFz;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bFA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        if (this.bFA == null || this.bFA.isEmpty()) {
            this.bFA = new LinkedList<>();
            if (TbFaceManager.Ej().CY() > 0) {
                u uVar = new u();
                this.bFA.add(uVar);
                if (interfaceC0041a != null) {
                    interfaceC0041a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0041a != null) {
                interfaceC0041a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void CX() {
    }

    public boolean isEmpty() {
        return this.bFA == null || this.bFA.size() == 0;
    }
}
