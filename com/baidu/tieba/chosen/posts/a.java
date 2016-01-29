package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.b<tinfo, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b>> {
    public a(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eS(int i) {
        tinfo item = getItem(i);
        if (item == null) {
            return -1;
        }
        if (item.pics != null) {
            int size = item.pics.size();
            if (size >= 3) {
                return 0;
            }
            return (size <= 0 || size >= 3) ? 1 : 2;
        }
        return 1;
    }

    public void ar(long j) {
        List<tinfo> Fm;
        tinfo tinfoVar;
        if (j > 0 && (Fm = Fm()) != null && Fm.size() > 0) {
            int size = Fm.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    tinfoVar = null;
                    break;
                }
                tinfo tinfoVar2 = Fm.get(i);
                if (tinfoVar2 == null || tinfoVar2.thread_id == null || tinfoVar2.thread_id.longValue() != j) {
                    i++;
                } else {
                    tinfoVar = Fm.get(i);
                    break;
                }
            }
            if (tinfoVar != null) {
                z(tinfoVar);
            }
        }
    }
}
