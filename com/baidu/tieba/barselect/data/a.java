package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes21.dex */
public class a {
    public long forumId;
    public String icH;
    public long icI;
    public int icJ;
    public int icK;
    public int icL;
    public int icM;
    public String icN;
    public boolean icO;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.icH = dataRes.portrait;
            this.name = dataRes.name_show;
            this.icI = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.icJ = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.icK = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.icL = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.icM = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.icO = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
