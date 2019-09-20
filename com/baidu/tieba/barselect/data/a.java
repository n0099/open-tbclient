package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String exF;
    public long exG;
    public int exH;
    public int exI;
    public int exJ;
    public int exK;
    public String exL;
    public boolean exM;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.exF = dataRes.portrait;
            this.name = dataRes.name_show;
            this.exG = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.exH = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.exI = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.exJ = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.exK = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.exM = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
