package com.baidu.tieba.barselect.data;

import tbclient.Search.DataRes;
/* loaded from: classes15.dex */
public class a {
    public long forumId;
    public String hcW;
    public long hcX;
    public int hcY;
    public int hcZ;
    public int hda;
    public int hdb;
    public String hdc;
    public boolean hdd;
    public String name;
    public long tid;
    public long uid;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.uid = dataRes.uid == null ? 0L : dataRes.uid.longValue();
            this.hcW = dataRes.portrait;
            this.name = dataRes.name_show;
            this.hcX = dataRes.apply_id == null ? 0L : dataRes.apply_id.longValue();
            this.hcY = dataRes.vote_num == null ? 0 : dataRes.vote_num.intValue();
            this.hcZ = dataRes.agree_num == null ? 0 : dataRes.agree_num.intValue();
            this.hda = dataRes.thread_num == null ? 0 : dataRes.thread_num.intValue();
            this.hdb = dataRes.post_num == null ? 0 : dataRes.post_num.intValue();
            this.hdd = dataRes.is_vote != null ? dataRes.is_vote.booleanValue() : false;
            this.tid = dataRes.tid != null ? dataRes.tid.longValue() : 0L;
        }
    }
}
