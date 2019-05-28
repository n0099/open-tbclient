package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String eqP;
    public long eqQ;
    public int eqR;
    public int eqS;
    public int eqT;
    public int eqU;
    public String eqV;
    public boolean eqW;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.eqP = dataRes.portrait;
            this.name = dataRes.name_show;
            this.eqQ = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.eqR = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.eqS = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.eqT = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.eqU = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.eqW = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
