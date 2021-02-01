package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public long iqi;
    public int iqj;
    public int iqk;
    public int iql;
    public int iqm;
    public String iqn;
    public boolean iqo;
    public String name;
    public String portraitUrl;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.portraitUrl = dataRes.portrait;
            this.name = dataRes.name_show;
            this.iqi = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.iqj = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.iqk = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.iql = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.iqm = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.iqo = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
