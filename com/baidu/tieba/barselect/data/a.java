package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes21.dex */
public class a {
    public long forumId;
    public String hRo;
    public long hRp;
    public int hRq;
    public int hRr;
    public int hRs;
    public int hRt;
    public String hRu;
    public boolean hRv;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hRo = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hRp = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hRq = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hRr = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hRs = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hRt = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hRv = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
