package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes8.dex */
public class a {
    private boolean gcC;
    private List<b> kFQ = new ArrayList();
    private boolean kFR;
    private Page page;

    public boolean cVZ() {
        return this.kFR;
    }

    public boolean bJJ() {
        return this.gcC;
    }

    public void sM(boolean z) {
        this.gcC = z;
    }

    public List<b> cWa() {
        return this.kFQ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kFR = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kFQ.add(bVar);
                }
            }
        }
    }

    public void cWb() {
        if (this.kFQ != null && this.kFQ.size() > 0) {
            for (b bVar : this.kFQ) {
                if (bVar != null) {
                    l.cVQ().c(bVar.cWh().forum_id.longValue(), bVar.cWg() * 100, bVar.cWe());
                }
            }
        }
    }
}
