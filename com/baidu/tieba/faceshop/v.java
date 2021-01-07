package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v iVv;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iFA = new LinkedList<>();

    private v() {
    }

    public static v cCf() {
        if (iVv == null) {
            synchronized (v.class) {
                if (iVv == null) {
                    iVv = new v();
                }
            }
        }
        return iVv;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 4;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0593a interfaceC0593a) {
        if (com.baidu.tbadk.core.util.n.checkSD()) {
            List<MyEmotionGroupData> JW = a.cAV().JW(TbadkApplication.getCurrentAccount());
            this.iFA.clear();
            for (MyEmotionGroupData myEmotionGroupData : JW) {
                EmotionGroupData Kc = i.cBl().Kc(myEmotionGroupData.getGroupId());
                if (Kc != null) {
                    c cVar = new c(Kc);
                    if (cVar.bFe() != null) {
                        this.iFA.add(cVar);
                        if (interfaceC0593a != null) {
                            interfaceC0593a.a(cVar);
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
