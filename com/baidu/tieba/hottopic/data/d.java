package com.baidu.tieba.hottopic.data;

import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.u;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.a.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class d extends ah {
    public String bKP;
    public u bKQ;
    public List<com.baidu.tieba.card.a.c> bfi;

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.bKP = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.bfi = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        ah ahVar = new ah();
                        ahVar.a(threadInfo);
                        r rVar = null;
                        if (r.b(ahVar)) {
                            rVar = new r(ahVar);
                        } else if (s.b(ahVar)) {
                            rVar = new s(ahVar);
                        } else if (q.b(ahVar)) {
                            q qVar = new q();
                            qVar.aSc = ahVar;
                            rVar = qVar;
                        }
                        if (rVar != null && rVar.isValid()) {
                            rVar.gT("c10816");
                            this.bfi.add(rVar);
                        }
                    }
                }
            }
            if (hotThread.page != null) {
                this.bKQ = new u();
                this.bKQ.a(hotThread.page);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.bfi = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        ah ahVar = new ah();
                        ahVar.a(threadInfo);
                        r rVar = null;
                        if (r.b(ahVar)) {
                            rVar = new r(ahVar);
                        } else if (s.b(ahVar)) {
                            rVar = new s(ahVar);
                        } else if (q.b(ahVar)) {
                            q qVar = new q();
                            qVar.aSc = ahVar;
                            rVar = qVar;
                        }
                        if (rVar != null && rVar.isValid()) {
                            rVar.gT("c10816");
                            this.bfi.add(rVar);
                        }
                    }
                }
            }
            if (dataRes.page != null) {
                this.bKQ = new u();
                this.bKQ.a(dataRes.page);
            }
        }
    }
}
