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
    public String bHi;
    public q bHj;
    public List<z> bcS;

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.bHi = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.bcS = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        z zVar = new z();
                        zVar.a(threadInfo);
                        if (zVar.getType() == z.WC && !f(zVar)) {
                            this.bcS.add(zVar);
                        }
                    }
                }
            }
            if (hotThread.page != null) {
                this.bHj = new q();
                this.bHj.a(hotThread.page);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.bcS = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        z zVar = new z();
                        zVar.a(threadInfo);
                        if (zVar.getType() == z.WC && !f(zVar)) {
                            this.bcS.add(zVar);
                        }
                    }
                }
            }
            if (dataRes.page != null) {
                this.bHj = new q();
                this.bHj.a(dataRes.page);
            }
        }
    }

    private boolean f(z zVar) {
        return (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0) ? false : true;
    }
}
