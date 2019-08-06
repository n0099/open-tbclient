package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes3.dex */
public class a {
    public String evU;
    public long evV;
    public int evW;
    public int evX;
    public int evY;
    public int evZ;
    public String ewa;
    public boolean ewb;
    public long forumId;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.evU = dataRes.portrait;
            this.name = dataRes.name_show;
            this.evV = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.evW = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.evX = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.evY = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.evZ = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.ewb = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
