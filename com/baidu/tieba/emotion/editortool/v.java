package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bDA = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bDB;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v US() {
        v vVar;
        synchronized (v.class) {
            vVar = bDA;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bDB;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0040a interfaceC0040a) {
        if (this.bDB == null || this.bDB.isEmpty()) {
            this.bDB = new LinkedList<>();
            if (TbFaceManager.Ek().Dc() > 0) {
                u uVar = new u();
                this.bDB.add(uVar);
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDB.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0040a != null) {
                interfaceC0040a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bDB == null || this.bDB.size() == 0;
    }
}
