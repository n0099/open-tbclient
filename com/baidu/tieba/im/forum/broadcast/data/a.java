package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes7.dex */
public class a {
    private boolean gae;
    private List<b> kxw = new ArrayList();
    private boolean kxx;
    private Page page;

    public boolean cTU() {
        return this.kxx;
    }

    public boolean bJk() {
        return this.gae;
    }

    public void sz(boolean z) {
        this.gae = z;
    }

    public List<b> cTV() {
        return this.kxw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kxx = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kxw.add(bVar);
                }
            }
        }
    }

    public void cTW() {
        if (this.kxw != null && this.kxw.size() > 0) {
            for (b bVar : this.kxw) {
                if (bVar != null) {
                    l.cTL().d(bVar.cUc().forum_id.longValue(), bVar.cUb() * 100, bVar.cTZ());
                }
            }
        }
    }
}
