package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.b<tinfo, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b>> {
    public a(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.f.b
    public int ic(int i) {
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

    public void bn(long j) {
        List<tinfo> dataList;
        tinfo tinfoVar;
        if (j > 0 && (dataList = getDataList()) != null && dataList.size() > 0) {
            int size = dataList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    tinfoVar = null;
                    break;
                }
                tinfo tinfoVar2 = dataList.get(i);
                if (tinfoVar2 == null || tinfoVar2.thread_id == null || tinfoVar2.thread_id.longValue() != j) {
                    i++;
                } else {
                    tinfoVar = dataList.get(i);
                    break;
                }
            }
            if (tinfoVar != null) {
                aG(tinfoVar);
            }
        }
    }
}
