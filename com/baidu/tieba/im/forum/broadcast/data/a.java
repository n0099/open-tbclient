package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes8.dex */
public class a {
    private boolean geO;
    private List<b> kCb = new ArrayList();
    private boolean kCc;
    private Page page;

    public boolean cXL() {
        return this.kCc;
    }

    public boolean bNb() {
        return this.geO;
    }

    public void sD(boolean z) {
        this.geO = z;
    }

    public List<b> cXM() {
        return this.kCb;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kCc = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kCb.add(bVar);
                }
            }
        }
    }

    public void cXN() {
        if (this.kCb != null && this.kCb.size() > 0) {
            for (b bVar : this.kCb) {
                if (bVar != null) {
                    l.cXC().d(bVar.cXT().forum_id.longValue(), bVar.cXS() * 100, bVar.cXQ());
                }
            }
        }
    }
}
