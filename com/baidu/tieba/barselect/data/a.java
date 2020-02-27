package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public String fDe;
    public long fDf;
    public int fDg;
    public int fDh;
    public int fDi;
    public int fDj;
    public String fDk;
    public boolean fDl;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.fDe = dataRes.portrait;
            this.name = dataRes.name_show;
            this.fDf = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.fDg = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.fDh = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.fDi = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.fDj = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.fDl = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
