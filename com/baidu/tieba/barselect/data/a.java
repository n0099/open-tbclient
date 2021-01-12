package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes7.dex */
public class a {
    public long forumId;
    public long ikA;
    public int ikB;
    public int ikC;
    public int ikD;
    public int ikE;
    public String ikF;
    public boolean ikG;
    public String name;
    public String portraitUrl;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.portraitUrl = dataRes.portrait;
            this.name = dataRes.name_show;
            this.ikA = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.ikB = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.ikC = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.ikD = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.ikE = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.ikG = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
