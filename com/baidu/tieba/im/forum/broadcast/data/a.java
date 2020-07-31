package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes20.dex */
public class a {
    private boolean eZg;
    private List<b> iXV = new ArrayList();
    private boolean iXW;
    private Page page;

    public boolean ctF() {
        return this.iXW;
    }

    public boolean bqE() {
        return this.eZg;
    }

    public void pM(boolean z) {
        this.eZg = z;
    }

    public List<b> ctG() {
        return this.iXV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.iXW = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.iXV.add(bVar);
                }
            }
        }
    }

    public void ctH() {
        if (this.iXV != null && this.iXV.size() > 0) {
            for (b bVar : this.iXV) {
                if (bVar != null) {
                    l.ctw().b(bVar.ctO().forum_id.longValue(), bVar.ctM() * 100, bVar.ctK());
                }
            }
        }
    }
}
