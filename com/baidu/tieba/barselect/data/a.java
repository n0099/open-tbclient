package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes15.dex */
public class a {
    public long forumId;
    public String hda;
    public long hdb;
    public int hdc;
    public int hdd;
    public int hde;
    public int hdf;
    public String hdg;
    public boolean hdh;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hda = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hdb = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hdc = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hdd = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hde = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hdf = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hdh = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
