package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes21.dex */
public class a {
    public long forumId;
    public String hLr;
    public long hLs;
    public int hLt;
    public int hLu;
    public int hLv;
    public int hLw;
    public String hLx;
    public boolean hLy;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hLr = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hLs = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hLt = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hLu = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hLv = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hLw = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hLy = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
