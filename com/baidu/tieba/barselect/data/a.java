package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String eqO;
    public long eqP;
    public int eqQ;
    public int eqR;
    public int eqS;
    public int eqT;
    public String eqU;
    public boolean eqV;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.eqO = dataRes.portrait;
            this.name = dataRes.name_show;
            this.eqP = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.eqQ = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.eqR = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.eqS = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.eqT = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.eqV = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
