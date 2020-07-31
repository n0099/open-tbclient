package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes15.dex */
public class a {
    public long forumId;
    public String gQg;
    public long gQh;
    public int gQi;
    public int gQj;
    public int gQk;
    public int gQl;
    public String gQm;
    public boolean gQn;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.gQg = dataRes.portrait;
            this.name = dataRes.name_show;
            this.gQh = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.gQi = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.gQj = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.gQk = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.gQl = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.gQn = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
