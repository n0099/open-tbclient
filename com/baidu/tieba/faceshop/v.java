package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v iWv;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iGD = new LinkedList<>();

    private v() {
    }

    public static v czy() {
        if (iWv == null) {
            synchronized (v.class) {
                if (iWv == null) {
                    iWv = new v();
                }
            }
        }
        return iWv;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 4;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (com.baidu.tbadk.core.util.o.checkSD()) {
            List<MyEmotionGroupData> Jw = a.cyo().Jw(TbadkApplication.getCurrentAccount());
            this.iGD.clear();
            for (MyEmotionGroupData myEmotionGroupData : Jw) {
                EmotionGroupData JC = i.cyE().JC(myEmotionGroupData.getGroupId());
                if (JC != null) {
                    c cVar = new c(JC);
                    if (cVar.bBC() != null) {
                        this.iGD.add(cVar);
                        if (interfaceC0573a != null) {
                            interfaceC0573a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    protected void register() {
    }
}
