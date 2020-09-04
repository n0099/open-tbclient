package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes20.dex */
public class a {
    private boolean fkC;
    private List<b> jnc = new ArrayList();
    private boolean jnd;
    private Page page;

    public boolean cEx() {
        return this.jnd;
    }

    public boolean bzD() {
        return this.fkC;
    }

    public void qu(boolean z) {
        this.fkC = z;
    }

    public List<b> cEy() {
        return this.jnc;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.jnd = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.jnc.add(bVar);
                }
            }
        }
    }

    public void cEz() {
        if (this.jnc != null && this.jnc.size() > 0) {
            for (b bVar : this.jnc) {
                if (bVar != null) {
                    l.cEo().b(bVar.cEG().forum_id.longValue(), bVar.cEE() * 100, bVar.cEC());
                }
            }
        }
    }
}
