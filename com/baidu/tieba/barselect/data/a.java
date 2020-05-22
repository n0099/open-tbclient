package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public String gxB;
    public long gxC;
    public int gxD;
    public int gxE;
    public int gxF;
    public int gxG;
    public String gxH;
    public boolean gxI;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.gxB = dataRes.portrait;
            this.name = dataRes.name_show;
            this.gxC = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.gxD = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.gxE = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.gxF = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.gxG = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.gxI = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
