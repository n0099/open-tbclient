package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ForumInfoData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 1;
    public String forum_name = "";
    public int forum_id = 0;
    public String avatar = "";
    public String slogan = "";
    public int member_count = 0;
    public int thread_count = 0;
    public int is_like = 0;
    public int mbr_inter_rank = 0;

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ai
    public LinkedList<String> getForumPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.avatar);
        return linkedList;
    }
}
