package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tieba.im.db.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes26.dex */
public class a {
    private boolean fzJ;
    private List<b> jKC = new ArrayList();
    private boolean jKD;
    private Page page;

    public boolean cLM() {
        return this.jKD;
    }

    public boolean bDy() {
        return this.fzJ;
    }

    public void ri(boolean z) {
        this.fzJ = z;
    }

    public List<b> cLN() {
        return this.jKC;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.page = dataRes.page;
            if (this.page != null) {
                this.jKD = this.page.has_more.intValue() == 1;
            }
            List<BroadcastInfo> list = dataRes.bcast_infos;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    b bVar = new b();
                    bVar.a(list.get(i));
                    this.jKC.add(bVar);
                }
            }
        }
    }

    public void cLO() {
        if (this.jKC != null && this.jKC.size() > 0) {
            for (b bVar : this.jKC) {
                if (bVar != null) {
                    l.cLD().c(bVar.cLV().forum_id.longValue(), bVar.cLT() * 100, bVar.cLR());
                }
            }
        }
    }
}
