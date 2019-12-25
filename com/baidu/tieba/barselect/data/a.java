package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes5.dex */
public class a {
    public long forumId;
    public int fxA;
    public String fxB;
    public boolean fxC;
    public String fxv;
    public long fxw;
    public int fxx;
    public int fxy;
    public int fxz;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.fxv = dataRes.portrait;
            this.name = dataRes.name_show;
            this.fxw = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.fxx = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.fxy = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.fxz = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.fxA = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.fxC = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
