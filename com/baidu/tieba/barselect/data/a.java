package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes20.dex */
public class a {
    public long forumId;
    public String hka;
    public long hkb;
    public int hkc;
    public int hkd;
    public int hke;
    public int hkf;
    public String hkg;
    public boolean hkh;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hka = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hkb = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hkc = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hkd = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hke = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hkf = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hkh = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
