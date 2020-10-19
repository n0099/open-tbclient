package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes21.dex */
public class a {
    public long forumId;
    public String hyV;
    public long hyW;
    public int hyX;
    public int hyY;
    public int hyZ;
    public int hza;
    public String hzb;
    public boolean hzc;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hyV = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hyW = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hyX = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hyY = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hyZ = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hza = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hzc = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
