package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes8.dex */
public class a {
    public long forumId;
    public long ipj;
    public int ipk;
    public int ipl;
    public int ipm;
    public int ipn;
    public String ipo;
    public boolean ipp;
    public String name;
    public String portraitUrl;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.portraitUrl = dataRes.portrait;
            this.name = dataRes.name_show;
            this.ipj = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.ipk = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.ipl = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.ipm = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.ipn = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.ipp = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
