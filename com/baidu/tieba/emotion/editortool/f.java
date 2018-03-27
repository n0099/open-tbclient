package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f doC = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> doD;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aqd() {
        f fVar;
        synchronized (f.class) {
            fVar = doC;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.doD;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0106a interfaceC0106a) {
        if (this.doD == null || this.doD.isEmpty()) {
            this.doD = new LinkedList<>();
            if (TbFaceManager.Mw().Lp() > 0) {
                e eVar = new e();
                this.doD.add(eVar);
                if (interfaceC0106a != null) {
                    interfaceC0106a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.doD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0106a != null) {
                interfaceC0106a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.doD == null || this.doD.size() == 0;
    }
}
