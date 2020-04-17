package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public String giF;
    public long giG;
    public int giH;
    public int giI;
    public int giJ;
    public int giK;
    public String giL;
    public boolean giM;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.giF = dataRes.portrait;
            this.name = dataRes.name_show;
            this.giG = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.giH = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.giI = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.giJ = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.giK = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.giM = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
