package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public String giL;
    public long giM;
    public int giN;
    public int giO;
    public int giP;
    public int giQ;
    public String giR;
    public boolean giS;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.giL = dataRes.portrait;
            this.name = dataRes.name_show;
            this.giM = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.giN = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.giO = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.giP = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.giQ = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.giS = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
