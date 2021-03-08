package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes7.dex */
public class a {
    private boolean gec;
    private List<b> kHS = new ArrayList();
    private boolean kHT;
    private Page page;

    public boolean cWg() {
        return this.kHT;
    }

    public boolean bJN() {
        return this.gec;
    }

    public void sM(boolean z) {
        this.gec = z;
    }

    public List<b> cWh() {
        return this.kHS;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.kHT = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.kHS.add(bVar);
                }
            }
        }
    }

    public void cWi() {
        if (this.kHS != null && this.kHS.size() > 0) {
            for (b bVar : this.kHS) {
                if (bVar != null) {
                    l.cVX().b(bVar.cWo().forum_id.longValue(), bVar.cWn() * 100, bVar.cWl());
                }
            }
        }
    }
}
