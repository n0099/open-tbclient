package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes20.dex */
public class a {
    public long forumId;
    public String hRO;
    public long hRP;
    public int hRQ;
    public int hRR;
    public int hRS;
    public int hRT;
    public String hRU;
    public boolean hRV;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hRO = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hRP = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hRQ = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hRR = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hRS = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hRT = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hRV = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
