package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v iWJ;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iGR = new LinkedList<>();

    private v() {
    }

    public static v czF() {
        if (iWJ == null) {
            synchronized (v.class) {
                if (iWJ == null) {
                    iWJ = new v();
                }
            }
        }
        return iWJ;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 4;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (com.baidu.tbadk.core.util.o.checkSD()) {
            List<MyEmotionGroupData> Jx = a.cyv().Jx(TbadkApplication.getCurrentAccount());
            this.iGR.clear();
            for (MyEmotionGroupData myEmotionGroupData : Jx) {
                EmotionGroupData JD = i.cyL().JD(myEmotionGroupData.getGroupId());
                if (JD != null) {
                    c cVar = new c(JD);
                    if (cVar.bBC() != null) {
                        this.iGR.add(cVar);
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
