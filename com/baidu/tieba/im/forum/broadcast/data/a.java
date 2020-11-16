package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes25.dex */
public class a {
    private boolean fNx;
    private List<b> kdH = new ArrayList();
    private boolean kdI;
    private Page page;

    public boolean cRa() {
        return this.kdI;
    }

    public boolean bHj() {
        return this.fNx;
    }

    public void rM(boolean z) {
        this.fNx = z;
    }

    public List<b> cRb() {
        return this.kdH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kdI = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kdH.add(bVar);
                }
            }
        }
    }

    public void cRc() {
        if (this.kdH != null && this.kdH.size() > 0) {
            for (b bVar : this.kdH) {
                if (bVar != null) {
                    l.cQR().c(bVar.cRj().forum_id.longValue(), bVar.cRh() * 100, bVar.cRf());
                }
            }
        }
    }
}
