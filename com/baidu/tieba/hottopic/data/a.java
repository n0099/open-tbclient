package com.baidu.tieba.hottopic.data;

import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.data.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a extends v {
    public List<v> aTp;
    public String boF;
    public n boG;

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.boF = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.aTp = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        v vVar = new v();
                        vVar.a(threadInfo);
                        if (vVar.getType() == v.Vs && !d(vVar)) {
                            this.aTp.add(vVar);
                        }
                    }
                }
            }
            if (hotThread.page != null) {
                this.boG = new n();
                this.boG.a(hotThread.page);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.aTp = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        v vVar = new v();
                        vVar.a(threadInfo);
                        if (vVar.getType() == v.Vs && !d(vVar)) {
                            this.aTp.add(vVar);
                        }
                    }
                }
            }
            if (dataRes.page != null) {
                this.boG = new n();
                this.boG.a(dataRes.page);
            }
        }
    }

    private boolean d(v vVar) {
        return (vVar.getAnchorInfoData() == null || vVar.getAnchorInfoData().getGroup_id() == 0) ? false : true;
    }
}
