package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String evN;
    public long evO;
    public int evP;
    public int evQ;
    public int evR;
    public int evS;
    public String evT;
    public boolean evU;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.evN = dataRes.portrait;
            this.name = dataRes.name_show;
            this.evO = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.evP = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.evQ = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.evR = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.evS = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.evU = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
