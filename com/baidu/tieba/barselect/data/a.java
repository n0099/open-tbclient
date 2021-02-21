package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public int iqA;
    public String iqB;
    public boolean iqC;
    public long iqw;
    public int iqx;
    public int iqy;
    public int iqz;
    public String name;
    public String portraitUrl;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.portraitUrl = dataRes.portrait;
            this.name = dataRes.name_show;
            this.iqw = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.iqx = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.iqy = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.iqz = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.iqA = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.iqC = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
