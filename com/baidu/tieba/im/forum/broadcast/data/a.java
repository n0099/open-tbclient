package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes25.dex */
public class a {
    private boolean fnv;
    private List<b> jvF = new ArrayList();
    private boolean jvG;
    private Page page;

    public boolean cId() {
        return this.jvG;
    }

    public boolean bAM() {
        return this.fnv;
    }

    public void qC(boolean z) {
        this.fnv = z;
    }

    public List<b> cIe() {
        return this.jvF;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.jvG = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.jvF.add(bVar);
                }
            }
        }
    }

    public void cIf() {
        if (this.jvF != null && this.jvF.size() > 0) {
            for (b bVar : this.jvF) {
                if (bVar != null) {
                    l.cHU().b(bVar.cIm().forum_id.longValue(), bVar.cIk() * 100, bVar.cIi());
                }
            }
        }
    }
}
