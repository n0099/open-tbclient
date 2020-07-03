package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public String gKA;
    public long gKB;
    public int gKC;
    public int gKD;
    public int gKE;
    public int gKF;
    public String gKG;
    public boolean gKH;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.gKA = dataRes.portrait;
            this.name = dataRes.name_show;
            this.gKB = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.gKC = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.gKD = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.gKE = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.gKF = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.gKH = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
