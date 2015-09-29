package com.baidu.tieba.hottopic.data;

import java.io.Serializable;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes.dex */
public class RelateForumItemData implements Serializable {
    private static final long serialVersionUID = 1;
    public long forumId = 0;
    public String forumName = null;
    public String forumAvatar = null;
    public String forumAbstract = null;
    public long threadNum = 0;
    public long postNum = 0;
    public long followNum = 0;
    public boolean isLiked = false;

    public void parserProtobuf(RelateForum relateForum) {
        if (relateForum != null) {
            this.forumId = relateForum.forum_id.intValue();
            this.forumName = relateForum.forum_name;
            this.forumAvatar = relateForum.avatar;
            this.forumAbstract = relateForum.desc;
            this.threadNum = relateForum.thread_num.intValue();
            this.postNum = relateForum.post_num.intValue();
            this.followNum = relateForum.member_num.intValue();
            this.isLiked = relateForum.is_liked.intValue() != 0;
        }
    }

    public void setIsLiked(boolean z) {
        this.isLiked = z;
    }
}
