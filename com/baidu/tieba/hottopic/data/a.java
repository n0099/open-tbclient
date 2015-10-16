package com.baidu.tieba.hottopic.data;

import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a extends w {
    public List<w> aTA;
    public String boQ;
    public o boR;

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.boQ = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.aTA = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        w wVar = new w();
                        wVar.a(threadInfo);
                        if (wVar.getType() == w.Vu && !d(wVar)) {
                            this.aTA.add(wVar);
                        }
                    }
                }
            }
            if (hotThread.page != null) {
                this.boR = new o();
                this.boR.a(hotThread.page);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.aTA = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        w wVar = new w();
                        wVar.a(threadInfo);
                        if (wVar.getType() == w.Vu && !d(wVar)) {
                            this.aTA.add(wVar);
                        }
                    }
                }
            }
            if (dataRes.page != null) {
                this.boR = new o();
                this.boR.a(dataRes.page);
            }
        }
    }

    private boolean d(w wVar) {
        return (wVar.getAnchorInfoData() == null || wVar.getAnchorInfoData().getGroup_id() == 0) ? false : true;
    }
}
