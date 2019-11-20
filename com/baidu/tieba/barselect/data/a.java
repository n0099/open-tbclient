package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public int eFA;
    public int eFB;
    public int eFC;
    public String eFD;
    public boolean eFE;
    public String eFx;
    public long eFy;
    public int eFz;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.eFx = dataRes.portrait;
            this.name = dataRes.name_show;
            this.eFy = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.eFz = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.eFA = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.eFB = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.eFC = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.eFE = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
