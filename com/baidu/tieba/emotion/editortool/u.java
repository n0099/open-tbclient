package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.emotiontool.a {
    private static u aLg = new u();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> aLh;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized u Ia() {
        u uVar;
        synchronized (u.class) {
            uVar = aLg;
        }
        return uVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.aLh;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0046a interfaceC0046a) {
        if (this.aLh == null || this.aLh.isEmpty()) {
            this.aLh = new LinkedList<>();
            if (TbFaceManager.BU().AN() > 0) {
                t tVar = new t();
                this.aLh.add(tVar);
                if (interfaceC0046a != null) {
                    interfaceC0046a.a(tVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aLh.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0046a != null) {
                interfaceC0046a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void AM() {
    }

    public boolean isEmpty() {
        return this.aLh == null || this.aLh.size() == 0;
    }
}
