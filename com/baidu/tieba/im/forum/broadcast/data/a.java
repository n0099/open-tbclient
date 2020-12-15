package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes26.dex */
public class a {
    private boolean fVi;
    private List<b> krm = new ArrayList();
    private boolean krn;
    private Page page;

    public boolean cWp() {
        return this.krn;
    }

    public boolean bKJ() {
        return this.fVi;
    }

    public void so(boolean z) {
        this.fVi = z;
    }

    public List<b> cWq() {
        return this.krm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.krn = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.krm.add(bVar);
                }
            }
        }
    }

    public void cWr() {
        if (this.krm != null && this.krm.size() > 0) {
            for (b bVar : this.krm) {
                if (bVar != null) {
                    l.cWg().c(bVar.cWx().forum_id.longValue(), bVar.cWw() * 100, bVar.cWu());
                }
            }
        }
    }
}
