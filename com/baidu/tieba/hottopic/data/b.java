package com.baidu.tieba.hottopic.data;

import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b extends z {
    public List<z> aYW;
    public String bDE;
    public q bDF;

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.bDE = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.aYW = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        z zVar = new z();
                        zVar.a(threadInfo);
                        if (zVar.getType() == z.Wc && !d(zVar)) {
                            this.aYW.add(zVar);
                        }
                    }
                }
            }
            if (hotThread.page != null) {
                this.bDF = new q();
                this.bDF.a(hotThread.page);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.aYW = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        z zVar = new z();
                        zVar.a(threadInfo);
                        if (zVar.getType() == z.Wc && !d(zVar)) {
                            this.aYW.add(zVar);
                        }
                    }
                }
            }
            if (dataRes.page != null) {
                this.bDF = new q();
                this.bDF.a(dataRes.page);
            }
        }
    }

    private boolean d(z zVar) {
        return (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0) ? false : true;
    }
}
