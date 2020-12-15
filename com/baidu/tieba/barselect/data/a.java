package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes21.dex */
public class a {
    public long forumId;
    public String icJ;
    public long icK;
    public int icL;
    public int icM;
    public int icN;
    public int icO;
    public String icP;
    public boolean icQ;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.icJ = dataRes.portrait;
            this.name = dataRes.name_show;
            this.icK = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.icL = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.icM = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.icN = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.icO = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.icQ = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
