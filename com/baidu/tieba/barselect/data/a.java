package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String eGo;
    public long eGp;
    public int eGq;
    public int eGr;
    public int eGs;
    public int eGt;
    public String eGu;
    public boolean eGv;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.eGo = dataRes.portrait;
            this.name = dataRes.name_show;
            this.eGp = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.eGq = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.eGr = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.eGs = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.eGt = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.eGv = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
