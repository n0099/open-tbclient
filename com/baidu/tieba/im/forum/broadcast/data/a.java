package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes20.dex */
public class a {
    private boolean fky;
    private List<b> jmW = new ArrayList();
    private boolean jmX;
    private Page page;

    public boolean cEw() {
        return this.jmX;
    }

    public boolean bzC() {
        return this.fky;
    }

    public void qs(boolean z) {
        this.fky = z;
    }

    public List<b> cEx() {
        return this.jmW;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.jmX = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.jmW.add(bVar);
                }
            }
        }
    }

    public void cEy() {
        if (this.jmW != null && this.jmW.size() > 0) {
            for (b bVar : this.jmW) {
                if (bVar != null) {
                    l.cEn().b(bVar.cEF().forum_id.longValue(), bVar.cED() * 100, bVar.cEB());
                }
            }
        }
    }
}
