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
    private List<b> krk = new ArrayList();
    private boolean krl;
    private Page page;

    public boolean cWo() {
        return this.krl;
    }

    public boolean bKJ() {
        return this.fVi;
    }

    public void so(boolean z) {
        this.fVi = z;
    }

    public List<b> cWp() {
        return this.krk;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.krl = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.krk.add(bVar);
                }
            }
        }
    }

    public void cWq() {
        if (this.krk != null && this.krk.size() > 0) {
            for (b bVar : this.krk) {
                if (bVar != null) {
                    l.cWf().c(bVar.cWw().forum_id.longValue(), bVar.cWv() * 100, bVar.cWt());
                }
            }
        }
    }
}
