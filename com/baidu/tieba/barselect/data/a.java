package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public String gxM;
    public long gxN;
    public int gxO;
    public int gxP;
    public int gxQ;
    public int gxR;
    public String gxS;
    public boolean gxT;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.gxM = dataRes.portrait;
            this.name = dataRes.name_show;
            this.gxN = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.gxO = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.gxP = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.gxQ = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.gxR = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.gxT = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
