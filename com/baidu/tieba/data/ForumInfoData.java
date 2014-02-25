package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ForumInfoData extends com.baidu.tieba.util.au implements Serializable {
    public String forum_name = "";
    public int forum_id = 0;
    public String avatar = "";
    public String slogan = "";
    public int member_count = 0;
    public int thread_count = 0;
    public int is_like = 0;
    public int mbr_inter_rank = 0;

    public String toString() {
        return "Forum{forum_name='" + this.forum_name + "', forum_id=" + this.forum_id + ", avatar='" + this.avatar + "', slogan='" + this.slogan + "', member_count=" + this.member_count + ", thread_count=" + this.thread_count + ", is_like=" + this.is_like + ", mbr_inter_rank=" + this.mbr_inter_rank + '}';
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getForumPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.avatar);
        return linkedList;
    }
}
