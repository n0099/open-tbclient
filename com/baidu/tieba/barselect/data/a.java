package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public String fEb;
    public long fEc;
    public int fEd;
    public int fEe;
    public int fEf;
    public int fEg;
    public String fEh;
    public boolean fEi;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.fEb = dataRes.portrait;
            this.name = dataRes.name_show;
            this.fEc = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.fEd = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.fEe = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.fEf = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.fEg = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.fEi = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
