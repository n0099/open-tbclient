package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v iYs;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iIA = new LinkedList<>();

    private v() {
    }

    public static v czL() {
        if (iYs == null) {
            synchronized (v.class) {
                if (iYs == null) {
                    iYs = new v();
                }
            }
        }
        return iYs;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 4;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0579a interfaceC0579a) {
        if (com.baidu.tbadk.core.util.o.checkSD()) {
            List<MyEmotionGroupData> JG = a.cyB().JG(TbadkApplication.getCurrentAccount());
            this.iIA.clear();
            for (MyEmotionGroupData myEmotionGroupData : JG) {
                EmotionGroupData JM = i.cyR().JM(myEmotionGroupData.getGroupId());
                if (JM != null) {
                    c cVar = new c(JM);
                    if (cVar.bBF() != null) {
                        this.iIA.add(cVar);
                        if (interfaceC0579a != null) {
                            interfaceC0579a.a(cVar);
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
