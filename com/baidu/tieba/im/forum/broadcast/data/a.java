package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes8.dex */
public class a {
    private boolean gcx;
    private List<b> kFC = new ArrayList();
    private boolean kFD;
    private Page page;

    public boolean cVS() {
        return this.kFD;
    }

    public boolean bJE() {
        return this.gcx;
    }

    public void sM(boolean z) {
        this.gcx = z;
    }

    public List<b> cVT() {
        return this.kFC;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kFD = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kFC.add(bVar);
                }
            }
        }
    }

    public void cVU() {
        if (this.kFC != null && this.kFC.size() > 0) {
            for (b bVar : this.kFC) {
                if (bVar != null) {
                    l.cVJ().c(bVar.cWa().forum_id.longValue(), bVar.cVZ() * 100, bVar.cVX());
                }
            }
        }
    }
}
