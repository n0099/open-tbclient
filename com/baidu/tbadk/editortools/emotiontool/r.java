package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends a {
    private static r aso = new r();
    private LinkedList<v> asp;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized r Bo() {
        r rVar;
        synchronized (r.class) {
            rVar = aso;
        }
        return rVar;
    }

    public List<v> getGroups() {
        return this.asp;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0046a interfaceC0046a) {
        if (this.asp == null || this.asp.isEmpty()) {
            this.asp = new LinkedList<>();
            if (TbFaceManager.Cr().Bd() > 0) {
                q qVar = new q();
                this.asp.add(qVar);
                if (interfaceC0046a != null) {
                    interfaceC0046a.a(qVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<v> it = this.asp.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (interfaceC0046a != null) {
                interfaceC0046a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void AW() {
    }

    public boolean isEmpty() {
        return this.asp == null || this.asp.size() == 0;
    }
}
