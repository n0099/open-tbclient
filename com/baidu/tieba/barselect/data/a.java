package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes7.dex */
public class a {
    public long forumId;
    public long isf;
    public int isg;
    public int ish;
    public int isi;
    public int isj;
    public String isk;
    public boolean isl;
    public String name;
    public String portraitUrl;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.portraitUrl = dataRes.portrait;
            this.name = dataRes.name_show;
            this.isf = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.isg = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.ish = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.isi = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.isj = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.isl = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
