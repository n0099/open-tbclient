package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortools.emotiontool.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v iQO;
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iAT = new LinkedList<>();

    private v() {
    }

    public static v cyn() {
        if (iQO == null) {
            synchronized (v.class) {
                if (iQO == null) {
                    iQO = new v();
                }
            }
        }
        return iQO;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 4;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0576a interfaceC0576a) {
        if (com.baidu.tbadk.core.util.n.checkSD()) {
            List<MyEmotionGroupData> IL = a.cxd().IL(TbadkApplication.getCurrentAccount());
            this.iAT.clear();
            for (MyEmotionGroupData myEmotionGroupData : IL) {
                EmotionGroupData IR = i.cxt().IR(myEmotionGroupData.getGroupId());
                if (IR != null) {
                    c cVar = new c(IR);
                    if (cVar.bBk() != null) {
                        this.iAT.add(cVar);
                        if (interfaceC0576a != null) {
                            interfaceC0576a.a(cVar);
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
