package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes26.dex */
public class a {
    private boolean fNU;
    private List<b> kcX = new ArrayList();
    private boolean kcY;
    private Page page;

    public boolean cRu() {
        return this.kcY;
    }

    public boolean bHQ() {
        return this.fNU;
    }

    public void rJ(boolean z) {
        this.fNU = z;
    }

    public List<b> cRv() {
        return this.kcX;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kcY = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kcX.add(bVar);
                }
            }
        }
    }

    public void cRw() {
        if (this.kcX != null && this.kcX.size() > 0) {
            for (b bVar : this.kcX) {
                if (bVar != null) {
                    l.cRl().c(bVar.cRD().forum_id.longValue(), bVar.cRB() * 100, bVar.cRz());
                }
            }
        }
    }
}
