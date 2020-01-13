package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes6.dex */
public class a {
    public String fAG;
    public long fAH;
    public int fAI;
    public int fAJ;
    public int fAK;
    public int fAL;
    public String fAM;
    public boolean fAN;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.fAG = dataRes.portrait;
            this.name = dataRes.name_show;
            this.fAH = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.fAI = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.fAJ = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.fAK = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.fAL = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.fAN = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
