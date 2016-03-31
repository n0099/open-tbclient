package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bam = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> ban;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Nm() {
        v vVar;
        synchronized (v.class) {
            vVar = bam;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.ban;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0049a interfaceC0049a) {
        if (this.ban == null || this.ban.isEmpty()) {
            this.ban = new LinkedList<>();
            if (TbFaceManager.EN().Dz() > 0) {
                u uVar = new u();
                this.ban.add(uVar);
                if (interfaceC0049a != null) {
                    interfaceC0049a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ban.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0049a != null) {
                interfaceC0049a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void Dy() {
    }

    public boolean isEmpty() {
        return this.ban == null || this.ban.size() == 0;
    }
}
