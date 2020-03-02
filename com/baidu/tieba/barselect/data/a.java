package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public String fDg;
    public long fDh;
    public int fDi;
    public int fDj;
    public int fDk;
    public int fDl;
    public String fDm;
    public boolean fDn;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.fDg = dataRes.portrait;
            this.name = dataRes.name_show;
            this.fDh = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.fDi = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.fDj = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.fDk = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.fDl = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.fDn = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
