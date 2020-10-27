package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes26.dex */
public class a {
    private boolean fIe;
    private List<b> jXa = new ArrayList();
    private boolean jXb;
    private Page page;

    public boolean cOT() {
        return this.jXb;
    }

    public boolean bFr() {
        return this.fIe;
    }

    public void rA(boolean z) {
        this.fIe = z;
    }

    public List<b> cOU() {
        return this.jXa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.jXb = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.jXa.add(bVar);
                }
            }
        }
    }

    public void cOV() {
        if (this.jXa != null && this.jXa.size() > 0) {
            for (b bVar : this.jXa) {
                if (bVar != null) {
                    l.cOK().c(bVar.cPc().forum_id.longValue(), bVar.cPa() * 100, bVar.cOY());
                }
            }
        }
    }
}
